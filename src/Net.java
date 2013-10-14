import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 21.08.13
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class Net {
    public static Socket soket() {
        Socket sok = null;
        try {
            sok = new Socket("192.168.178.28", 6832); // Herstellen einer neuen Verbindung mit dem Ziel Server
        } catch (IOException e) {
            System.out.println("Konnte keine Verbindung aufbauen");
        }

        return sok;
    }

    public static String Anfrage(Socket sok) {
        String s="";
        try{
        PrintStream os = new PrintStream( sok.getOutputStream() );
        BufferedReader in = new BufferedReader(new InputStreamReader( sok.getInputStream()) );

            os.println("???");
            //System.out.println("rdy_read");
            s = in.readLine();
            //System.out.println(s);
            //System.out.println("lesen ende");
        }catch (IOException e){
            System.out.println("Konnte keine I/O kanal öffnen");
            s="fehler";
        }


        return s;
    }

}
