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

        items[0] = "0_Clock".toUpperCase();
        items[1] = "1_StopWatch";//.toUpperCase();
        items[2] = "2_Serial Event ygjµ";
        items[3] = "Ga";

        st = new scrollingText(1, 0, "Arial", items[itemIndex], 1, g2d, 11);
    }



    public void SerialData(String SerialData) {

        if(SerialData.charAt(0)==65){
            if(SerialData.charAt(1)==49){
                if (itemIndex == functions.getfunctionsSize()) itemIndex = 0;
                if (itemIndex < functions.getfunctionsSize()){
                    itemIndex+=1;
                    st.setText(items[itemIndex],true);
                }

            }

            if(SerialData.charAt(1)==114){
                MenuOn = false;
                System.out.println("Start Programm:   "+items[itemIndex]);
                functions.functions.get(itemIndex).visible(true);
            }

            if(SerialData.charAt(1)==113){
                MenuOn = true;
                System.out.println("End Programm:   "+items[itemIndex]);
                functions.functions.get(itemIndex).visible(false);
            }

        }

    }

    public void visible(boolean visible) {

        MenuOn = visible;

    }


    public void render() {
        if(MenuOn){


            st.render();
        }
    }
}
