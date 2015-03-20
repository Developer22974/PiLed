package functions;

import toolbox.scrollingText;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel on 12.10.14.
 */
public class Clock implements functionsInterface {

    Boolean ClockOn = false;
    Graphics2D g2d;
    SimpleDateFormat hh = new SimpleDateFormat();
    SimpleDateFormat mm = new SimpleDateFormat();
    SimpleDateFormat ss = new SimpleDateFormat();
    scrollingText st;

    public Clock(Graphics2D g2d) {
        this.g2d = g2d;

        hh.applyPattern("hh");
        mm.applyPattern("mm");
        ss.applyPattern("ss");
        st = new scrollingText(0.6, 0, "Arial", "", 1, g2d, 14);
    }

    public void render() {
        if (ClockOn) {

            st.setText(hh.format(new Date()) + ":" + ss.format(new Date()));
            st.render();

        }
    }

    public void visible(boolean visible) {

        ClockOn = visible;

    }


    public void SerialData() {

    }


}
