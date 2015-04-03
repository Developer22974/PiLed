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
    Integer watchFaces = 0;
    double face1Counter = 0;

    public Clock(Graphics2D g2d) {
        this.g2d = g2d;

        hh.applyPattern("hh");
        mm.applyPattern("mm");
        ss.applyPattern("ss");
        st = new scrollingText(0.6, 0, 10, "Arial", "", 1, g2d, 14);
    }

    public void render() {
        if (ClockOn) {

            switch (watchFaces) {
                case 0:
                    st.setText(hh.format(new Date()) + ":" + ss.format(new Date()), false);
                    st.render();
                    break;
                case 1:
                    if (face1Counter < 31) {
                        face1Counter += 0.25;
                    } else {
                        face1Counter = 0;
                    }
                    if (face1Counter < 11) {
                        st.setText(hh.format(new Date()), false);
                        st.render();
                    } else if (face1Counter < 21) {
                        st.setText("Uhr", false);
                        st.render();
                    } else {
                        st.setText(ss.format(new Date()), false);
                        st.render();
                    }
            }
        }
    }


    public void SerialData(String SerialData) {

        if (SerialData.charAt(0) == 65) {
            if (SerialData.charAt(1) == 102) {
                if (watchFaces < 1) {
                    watchFaces += 1;
                } else {
                    watchFaces = 0;
                }
            }

        }

    }

    public void visible(boolean visible) {

        ClockOn = visible;

    }


}
