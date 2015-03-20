import com.sun.java.swing.plaf.windows.resources.windows;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

/**
 * Created by Patrick on 22.05.2014.
 */
public class DisplaySim {
    private Grid grid = new Grid();
    private static PiLed piled;
    private final JFrame window = new JFrame("Sim");

    public static class Grid extends JPanel {
        private int[][] cells = new int[18][10];



        public void paintComponent(Graphics g){

            //PiLed.image.getRGB(10,9);
            g.setColor(new Color(0,0,0));
            g.fillRect(4,4,379,211);
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    int cellX = 5+ i *21;
                    int cellY = 5+ j *21;
                    if ((PiLed.image.getRGB(i,j)& 0xFF)!=0) {
                        //if (cells[i][j]!=0) {
                        //g.setColor(new Color(0, 0,(PiLed.image.getRGB(i,j)& 0xFF)));
                        g.setColor(new Color(0, 0,255));
                        //System.out.println(PiLed.image.getRGB(i,j)& 0xFF);
                        //g.setColor(new Color(0, 0, cells[i][j]));
                    } else {
                        g.setColor(new Color(255, 255, 255));
                    }

                    g.fillRect(cellX, cellY, 20, 20);
                }
            }
        }

        public void fillCell(int x, int y,int state){
            cells[x][y] = state;

        }
    }


    public DisplaySim() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                grid.setSize(410,270);
                //window.setBackground(Color.white);
                //grid.setPreferredSize(new Dimension(225,160));
                window.setSize(410, 270); //410,270
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Box box = Box.createHorizontalBox();
                box.add(grid);
                //box.add(new draw());
                window.add(box);
                window.setVisible(true);
            }
        });  }

    public void fillCell(int x, int y, int state){
        grid.fillCell(x, y, state);
        //window.repaint();
    }

    public void repaint(){
        window.repaint();
    }

}
