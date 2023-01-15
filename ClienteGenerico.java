import java.util.Scanner;
//da sistemare controllo cliente esistente
//gestione Arraylist o gestione db esterno per clienti

public class ClienteGenerico {
    String Indirizzo;
    String Citta;
    // String prov;
    //  String telefono1;
    //  String email;
    Scanner cligenerico = new Scanner(System.in);

    ClienteGenerico(/*String Indirizzo, String Citta*/) {
        this.Indirizzo = Indirizzo;
        this.Citta = Citta;
        // ClientePrivato cliente= new ClientePrivato();
        System.out.println("Inserire l'indirizzo ");
        //cligenerico.next();
        Indirizzo = cligenerico.nextLine();
        System.out.println("Inserire la citta ");
        Citta = cligenerico.nextLine();
        //   this.prov=prov;
        //    this.telefono1=telefono1;
        //    this.email=email;
        //System.out.println("Indirizzo " + Indirizzo.toUpperCase() + " Citta " + Citta.toUpperCase());

    }
}
