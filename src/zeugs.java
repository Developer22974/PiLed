/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 18.08.13
 * Time: 10:02
 * To change this template use File | Settings | File Templates.
 */
/*
public class zeugs {

  while(true) {
            String in = sc.nextLine();
            if (in.contains("1")){
                out[1].toggle();
                System.out.println("IN(1) = "+out[1].getState());
            }
            if (in.contains("4")){
                out[4].toggle();
                System.out.println("SCK(4) = "+out[4].getState());
            }
            if (in.contains("5")){
                out[5].toggle();
                System.out.println("RCK(5) = "+out[5].getState());
            }
            if (in.contains("6")){
                out[6].toggle();
                System.out.println("G(6) = "+out[6].getState());
            }


           //SI.toggle();
            //for (int a=0 ;a<10000000;a++){
            //    int t=Ausgabe.Adressen;
            //}


                    /*while(true) {
            led1.toggle();
            //Thread.sleep(500);
        }




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

}

*/
