import com.pi4j.io.gpio.GpioPinDigitalOutput;

import javax.xml.soap.Text;
import java.net.Socket;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Ausgabe gpio = new Ausgabe();
        gpio = Ausgabe.init();
        Global.gpio=gpio;
       // Programme.Snake();
       //Programme.ScrollingText(args[0],200,false,gpio);



        //IR_Controll.IR_Recive();
        //Programme.Uhr();
        IR_Controll.Serielle_com();
        //IR_Controll.IR_Recive();
        while(true){

        Thread.sleep(10);
        }
    }
}
