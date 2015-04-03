package functions;

import toolbox.*;


import java.awt.*;

/**
 * Created by Daniel on 20.03.15.
 */
public class StopWatch implements functionsInterface {

    Boolean StopWatchOn = false;
    int startTime;
    Graphics2D g2d;
    int startValue;
    //drawText dt;
    scrollingText dt;


    public StopWatch(Boolean StopWatchOn, int startTime, Graphics2D g2d) {
        this.StopWatchOn = StopWatchOn;
        this.startTime = startTime;
        this.g2d = g2d;
        startValue = (int) ((System.nanoTime()/1000000000) +startTime);
        //dt = new drawText(0,10,14,"Arial","",g2d);
        dt =   new scrollingText(0.5, 0,10, "Arial", "", 1, g2d, 14);


    }


    public void SerialData(String SerialData) {

    }

    public void visible(boolean visible) {
        StopWatchOn = visible;
        startValue = (int) ((System.nanoTime()/1000000000) +startTime);
    }


    public void setStopWatchOn(Boolean stopWatchOn) {
        StopWatchOn = stopWatchOn;
    }

    public void render() {

        if(StopWatchOn){
            //System.out.println(String.valueOf(startValue));
            //System.out.println(String.valueOf((System.nanoTime()/1000000000)-startValue));
            dt.setText(String.valueOf((System.nanoTime()/1000000000)-startValue),false);
            dt.render();

        }



    }
}
