/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 13.10.13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.SerialPortException;

public class IR_Controll {

    public static void Serielle_com()  throws InterruptedException {
        final Serial serial = SerialFactory.createInstance();

        serial.addListener(new SerialDataListener() {
            @Override
            public void dataReceived(SerialDataEvent event){
                String Daten ="";
                Daten = event.getData();
                System.out.print(Daten);
                Character A;
                if (Daten.charAt(0)>33){
                try {
                    Programme.ScrollingText(String.valueOf(Daten.getBytes()[0]),200,false,Global.gpio);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                }

            }
        });
        serial.open(Serial.DEFAULT_COM_PORT, 9600);
        }
}
