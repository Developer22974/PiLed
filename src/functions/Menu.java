package functions;

import toolbox.scrollingText;

import java.awt.*;

/**
 * Created by Daniel on 20.03.15.
 */
public class Menu implements functionsInterface {
    Boolean MenuOn = true;
    Graphics2D g2d;
    int itemIndex = 0;
    String[] items= new String[10];
    scrollingText st;
    FunctionController functions;

    public Menu(Graphics2D g2d,FunctionController functions ) {
        this.g2d = g2d;
        this.functions =  functions;

        items[0] = "Clock".toUpperCase();
        items[1] = "StopWatch";//.toUpperCase();
        items[2] = "Serial Event ygjµ";
        items[3] = "Ga";

        st = new scrollingText(1, 0, "Arial", items[itemIndex], 1, g2d, 11);
    }

    public void SerialData() {

        functions.getfunctionsSize();

    }

    public void SerialData(String SerialData) {

        if(SerialData.charAt(0)==65){
            if (itemIndex == functions.getfunctionsSize()) itemIndex = 0;
            if (itemIndex < functions.getfunctionsSize()){
                itemIndex+=1;
                st.setText(items[itemIndex]);
            }
        }

    }

    public void visible(boolean visible) {

    }


    public void render() {
        if(MenuOn){


            st.render();
        }
    }
}
