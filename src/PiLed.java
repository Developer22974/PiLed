import functions.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class PiLed implements Runnable {

    private static Boolean windows = false;
    private Boolean running = false;
    private Thread thread;
    public static Ausgabe gpio;
    public static BufferedImage image = new BufferedImage(18, 10, BufferedImage.TYPE_BYTE_GRAY);
    public static Graphics2D g2d = image.createGraphics();
    public static StringBuilder SerialBuffer = new StringBuilder();
    public static List<String> contend = new ArrayList<String>();
    private static DisplaySim Sim;
    private static FunctionController fContrl;

    public void init() {

    }

    private synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();

    }

    private synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);

    }

    public void run() {
        init();
        long lastTime = System.nanoTime();
        long tics = 1000000000 / 100;
        long count = 0, count2 = 0, Frames = 0;
        while (running) {
            if (System.nanoTime() - lastTime > tics) {
                lastTime = System.nanoTime();
                tic();
                count++;
                count2++;

            }

            if (count2 >= 10) {
                render();
                Frames++;
                count2 = 0;
            }

            if (count >= 100) {
                //System.out.println(count + " Tics , Frames " + Frames);
                count = 0;
                Frames = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) throws InterruptedException {
        PiLed PiLed = new PiLed();
        windows = System.getProperty("os.name").equals("Windows 7") || System.getProperty("os.name").equals("Windows 8");

        if (!windows) {
            gpio = Ausgabe.init();
            SerialControl sc = new SerialControl(PiLed);
        } else {
            Sim = new DisplaySim();
        }
        //1
        PiLed.start();
        fContrl = new FunctionController(g2d);
        //fContrl.functions.get(0).visible(true);
        //System.out.println(fContrl.functions.get(0));

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Geben Sie etwas ein: ");
        while (true) {
            String zeile = null;
            try {
                zeile = console.readLine();
            } catch (IOException e) {
                // Sollte eigentlich nie passieren
                e.printStackTrace();
            }
            //System.out.println("Ihre Eingabe war: " + zeile);
            SerialDataEvent(zeile);
        }
        //SerialDataEvent("123");
    }

    public static void SerialDataEvent(String Data) {
        Boolean lastCharX = false, dataFrame = false, frameEnd = false;
        char frameContend[] = new char[32];
        int contendCount = 0;
        int frameEndPos = 0;
        SerialBuffer.append(Data);
        for (int a = 0; a < SerialBuffer.length(); a++) {
            if ((SerialBuffer.charAt(a) == 88)) {
                frameEnd = false;
                if (dataFrame) {
                    contend.add((String.copyValueOf(frameContend)).trim());
                    System.out.println("Frame contend: " + String.copyValueOf(frameContend));
                    Arrays.fill(frameContend, (char) 0);
                    contendCount = 0;
                    frameEndPos = a + 1;
                    dataFrame = false;
                    lastCharX = false;
                    frameEnd = true;
                }
                if (lastCharX) {
                    dataFrame = true;
                    contendCount = 0;
                }
                if (!frameEnd) lastCharX = true;
                System.out.printf("X an der Position: %d erkannt \n", a);
            } else {
                lastCharX = false;
            }
            if ((dataFrame) && (!(SerialBuffer.charAt(a) == 88))) {
                contendCount++;
                frameContend[contendCount] = SerialBuffer.charAt(a);
            }

        }
        System.out.println("Original: " + SerialBuffer);
        SerialBuffer.delete(0, frameEndPos);
        System.out.println("Geändert: " + SerialBuffer);
        System.out.println("LST: " + String.valueOf(contend));

        for (int a = 0; a < contend.size(); a++) {
                fContrl.SerialData(contend.get(a));
                contend.remove(a);
        }


    }

    public void tic() {
        //if (c != null) c.tic();

    }

    public void render() {
        //if (c != null) c.render();
        //if (stw != null) stw.render();

        for (int i = 0; i < fContrl.functions.size(); i++) {
            fContrl.functions.get(i).render();
        }

        if (windows) Sim.repaint();
        if (!windows) Ausgabe.AusgabeImg(gpio.out[1], gpio.out[4], gpio.out[5]);
    }

}
