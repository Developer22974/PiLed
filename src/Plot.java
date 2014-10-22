import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 20.12.13
 * Time: 12:36
 * To change this template use File | Settings | File Templates.
 */
public class Plot {
    public static void Test() throws InterruptedException {
        System.out.println("*** Plot ***");
        int DirX = 0;
        int DirY = 0;
        int x = 9;
        int y = 5;
        int AppelX = 0;
        int AppelY = 0;
        int WormLength = 1;
        int[][] Worm = new int[200][2];
        Boolean Appel = false;
        while (true) {
        /*    if (Global.New_IR_Data) {
                Global.New_IR_Data = false;
                System.out.println(Global.IR_Data.getBytes()[0]);
                if (Global.IR_Data.getBytes()[0] == 31) {
                    DirY = -1;
                    DirX = 0;
                }
                if (Global.IR_Data.getBytes()[0] == 62) {
                    DirY = 1;
                    DirX = 0;
                }
                if (Global.IR_Data.getBytes()[0] == 115) {
                    DirX = 1;
                    DirY = 0;
                }
                if (Global.IR_Data.getBytes()[0] == 113) {
                    DirX = -1;
                    DirY = 0;
                }
            }
            */
            x = x + DirX;
            y = y + DirY;
            if (x > 18) x = 1;
            if (y > 10) y = 1;
            if (x < 1) x = 18;
            if (y < 1) y = 10;
            if ((x == AppelX) && (y == AppelY)) {
                Appel = false;
                WormLength++;
                int Bild2[][] = new int[19][11];
               // Ausgabe.Ausgabe(Bild2, Global.gpio.out[1], Global.gpio.out[4], Global.gpio.out[5]);
                Thread.sleep(100);
            }
            int Bild[][] = new int[19][11];
            for (int a = WormLength - 1; a > 0; a--) {
                Worm[a][0] = Worm[a - 1][0];
                Worm[a][1] = Worm[a - 1][1];
            }
            Worm[0][0] = x;
            Worm[0][1] = y;

            for (int a = 1; a < WormLength; a++) {
                if ((Worm[a][0] == x) & (Worm[a][1] == y)) {
                    int Full[][] = new int[19][11];
                    for (int c = 1; c < 19; c++) Arrays.fill(Full[c], 1);
                    //Ausgabe.Ausgabe(Full, Global.gpio.out[1], Global.gpio.out[4], Global.gpio.out[5]);
                    Thread.sleep(500);
                    for (int c = 1; c < 19; c++) Arrays.fill(Full[c], 0);
                    //Ausgabe.Ausgabe(Full, Global.gpio.out[1], Global.gpio.out[4], Global.gpio.out[5]);
                    DirX = 0;
                    DirY = 0;
                    x = 9;
                    y = 5;
                    AppelX = 0;
                    AppelY = 0;
                    WormLength = 1;
                    Appel=false;
                }
            }

            for (int a = 0; a < WormLength; a++) Bild[Worm[a][0]][Worm[a][1]] = 1;
            //Bild[x][y] = 1;


            if (!Appel) {
                AppelX = (int) (Math.random() * 18) + 1;
                AppelY = (int) (Math.random() * 10) + 1;
                Appel = true;
            }

            Bild[AppelX][AppelY] = 1;
            //Ausgabe.Ausgabe(Bild, Global.gpio.out[1], Global.gpio.out[4], Global.gpio.out[5]);
            // Thread.sleep(300);
            ///*
            for (int a = 0; a < 4; a++) {
                if (Bild[AppelX][AppelY] == 1) {
                    Bild[AppelX][AppelY] = 0;
                } else Bild[AppelX][AppelY] = 1;
               // Ausgabe.Ausgabe(Bild, Global.gpio.out[1], Global.gpio.out[4], Global.gpio.out[5]);
                Thread.sleep(100);
            }
            //*/
        }
    }
}
