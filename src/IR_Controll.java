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

public class IR_Controll {
    static Long[] Zeit = new Long[900];
    static int count=0;
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
        for (int a=0;a<99;a++)System.out.println(Zeit[a]);
    }
}
