import java.io.*;
import java.net.Socket;

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
        String s;
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
