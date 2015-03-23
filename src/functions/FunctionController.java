package functions;

import functions.*;
import functions.Menu;
import functions.functionsInterface;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Daniel on 20.03.15.
 */
public class FunctionController {
    int functionID;
    Graphics2D g2d;
    public LinkedList<functionsInterface> functions = new LinkedList<functionsInterface>();


    public FunctionController(Graphics2D g2d) {
        this.g2d = g2d;
        functions.add(new Menu(g2d, this));
        functions.add(new StopWatch(false,0,g2d));
        functions.add(new Clock(g2d));
    }

    public void SerialData(String SerialData){
        for(int a = 0;a<functions.size();a++){
            functions.get(a).SerialData(SerialData);
        }
    }

    public int getfunctionsSize(){

        return functions.size();

    }


}
