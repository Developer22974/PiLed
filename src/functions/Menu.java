package functions;

import java.awt.*;

/**
 * Created by Daniel on 20.03.15.
 */
public class Menu implements functionsInterface {
    Boolean MenuOn = true;
    Graphics2D g2d;
    int itemIndex=0;
    String[] items= new String[10];

    public Menu() {
        items[0] = "Clock";
        items[1] = "Date";
        items[2] = "Serial Event";
        items[3] = "Game";
    }

    public void SerialData() {

    }

    public void visible(boolean visible) {

    }


    public void render() {
        if(MenuOn){

        }
    }
}
