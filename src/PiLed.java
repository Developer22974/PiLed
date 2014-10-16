import functions.*;
import sun.net.www.content.text.plain;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PiLed implements Runnable {

   public static final int WIDE = 18;
    public static final int HIGHT = 10;
    private static Boolean windows = false;
    private Boolean running = false;
    private Thread thread;

    public static Ausgabe gpio;

    public static BufferedImage image = new BufferedImage(18,10,BufferedImage.TYPE_BYTE_GRAY);
    public static Graphics2D g2d = image.createGraphics();

    public static Graphics2D g = image.createGraphics();
    public static StringBuilder SerialBuffer = new StringBuilder();


    public static Clock c;



    int state=3;
    private static DisplaySim Sim;

    public void init(){



        //g2d.setColor(new Color(0,0,0));
        //g2d.fillOval(1,1,15,5);
        //g2d.setFont( new Font( "Verdana",0,11) );
        //g2d.drawString("xD",0,9);

        //g2d.drawLine(0,0,5,5);
        //g2d.dispose();
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
        long count = 0,count2=0, Frames = 0;
        while (running) {
            if (System.nanoTime() - lastTime > tics) {
                lastTime = System.nanoTime();
                tic();
                count++;
                count2++;

            }

            if(count2>=10){
                render();
                Frames++;
                count2=0;
            }

            if (count >= 100) {
                System.out.println(count + " Tics , Frames " + Frames);
                count = 0;
                Frames = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) throws InterruptedException {
        PiLed PiLed = new PiLed();
        windows = System.getProperty("os.name").equals("Windows 7");
        if(windows) Sim = new DisplaySim();
        test();
        //SerialControl IR = new SerialControl(PiLed);
        if(!windows) {
            gpio = Ausgabe.init();
            SerialControl sc = new SerialControl(PiLed);
        }

        PiLed.start();
        c = new Clock(g2d);
    }

    public static void SeralDataEvent(String Data){
    SerialBuffer.append(Data);
    System.out.print(SerialBuffer);
    }

    public static void test(){

    }

    public void tic(){
        //if (c != null) c.tic();


    }

    public void render(){
        if (c != null) c.render();


        if(windows) Sim.repaint();
        if(!windows) Ausgabe.AusgabeImg(gpio.out[1],gpio.out[4],gpio.out[5]);
    }

}
