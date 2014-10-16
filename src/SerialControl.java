/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 13.10.13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataListener;
import com.pi4j.io.serial.SerialFactory;

import java.text.Normalizer;

public class SerialControl {
    PiLed PiLed;


    public SerialControl(PiLed piLed) {
        PiLed = piLed;
        System.out.println("Initial IR Control");
        final Serial serial = SerialFactory.createInstance();

        serial.addListener(new SerialDataListener() {
            @Override
            public void dataReceived(SerialDataEvent event){
                String Daten ="";
                Daten =event.getData();
                if(!Daten.equals("")){
                    PiLed.SeralDataEvent(Daten);
                }
            }
        });
        serial.open(Serial.DEFAULT_COM_PORT, 9600);
    }

}
