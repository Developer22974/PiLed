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
    static Long[] Zeit = new Long[900];
    static int count=0;

    public static void FlankenScope(){
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07, PinPullResistance.PULL_DOWN);
        Boolean Positiv=true;
        long Time=0;
        while (true){
            System.nanoTime();
            if (myButton.isHigh()!=Positiv){
                System.out.println(System.nanoTime()-Time);
                Time=System.nanoTime();
                Positiv=true;
            }
        }
    }

    public static void IR_Recive() throws InterruptedException {

        System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07, PinPullResistance.PULL_DOWN);

        // create and register gpio pin listener
        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
            //    int count=0;

                if (count<100){
                count++;
                Zeit[count]=System.nanoTime();
                }
                //System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState()+" Time: "+System.nanoTime());
            }

        });

        System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");

        // keep program running until user aborts (CTRL-C)
        //for (;;) {

        //}
        Thread.sleep(5000);
        //for(int x=1;x<9000000;x++)
        for (int a=0;a<99;a++)System.out.println(Zeit[a]);
    }
    public static void Serielle_com()  throws InterruptedException {
        final Serial serial = SerialFactory.createInstance();

        serial.addListener(new SerialDataListener() {
            @Override
            public void dataReceived(SerialDataEvent event) {
                // print out the data received to the console
                System.out.print(event.getData());

            }
        });
        serial.open(Serial.DEFAULT_COM_PORT, 9600);
        }
}
