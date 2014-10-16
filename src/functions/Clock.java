package functions;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel on 12.10.14.
 */
public class Clock {

    Boolean ClockOn = true;
    Graphics2D g2d;
    double a;
    double speed=0.6;
    double direction=-1;
    SimpleDateFormat hh = new SimpleDateFormat();
    SimpleDateFormat mm = new SimpleDateFormat();
    SimpleDateFormat ss = new SimpleDateFormat();

    public Clock(Graphics2D g2d) {
        this.g2d=g2d;

        hh.applyPattern("hh");
        mm.applyPattern("mm");
        ss.applyPattern("ss");
    }

    public void render(){
        if(ClockOn){
            long time = System.nanoTime();

            g2d.setColor(new Color(0, 0, 0));
            g2d.fillRect(0,0,18,10);
            g2d.setColor(new Color(0,0,255));
            g2d.setFont( new Font( "Arial",0,14) );
            g2d.drawString(hh.format(new Date())+":"+ss.format(new Date()),(int)a,10);
            a=a+direction*speed;
            if(a>0) direction = -1;
            if(a<(-24)) direction = +1;

            //System.out.println(ss.format(new Date()));


        }
    }


}
