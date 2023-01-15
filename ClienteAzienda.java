import java.io.IOException;
import java.util.Scanner;
public class ClienteAzienda extends ClienteGenerico {
    String Ragionesociale= "";
    String Partitaiva= "";
        ClienteAzienda(String Partitaiva) throws IOException {
        Scanner clienteazienda = new Scanner(System.in);
        System.out.println("Inserire la Ragione sociale ");
        Ragionesociale = clienteazienda.nextLine();
        System.out.println( "ragione sociale : " +Ragionesociale);
        System.out.println ( " Partita Iva :" + Partitaiva +"\n" );
        System.out.print("Indirizzo: " + super.Indirizzo.toUpperCase() + " Citta: " + super.Citta.toUpperCase());

    }

}
