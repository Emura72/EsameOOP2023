import java.io.IOException;
import java.util.Scanner;
public class ClienteAzienda extends ClienteGenerico {
    String Ragionesociale= "";
    //String Partitaiva= "";
        ClienteAzienda(String Partitaiva) throws IOException {
        Scanner ClAz = new Scanner(System.in);
        System.out.println("Inserire la Ragione sociale ");
        Ragionesociale = ClAz.nextLine();
        System.out.println("********************************************");
        System.out.println( "ragione sociale : " +Ragionesociale);
        System.out.println ( "Partita Iva :" + Partitaiva );
        System.out.println("Indirizzo: " + super.Indirizzo.toUpperCase() + " Citta: " + super.Citta.toUpperCase()+"\n");
        System.out.println("********************************************"+ "\n");

        }

}
