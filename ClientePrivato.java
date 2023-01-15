import java.util.Scanner;
public class ClientePrivato extends ClienteGenerico {
        String nome= "";
        String cognome= "";
        ClientePrivato(String Indirizzo, String Citta,String CodiceFiscale) {
            Scanner clienteprivato = new Scanner(System.in);
            System.out.println("Inserire il nome ");
            nome = clienteprivato.nextLine();
            System.out.println("inserire il cognome : " + cognome);
            cognome = clienteprivato.nextLine();
            System.out.print(" Codice Fiscale :" + CodiceFiscale + "\n");
            System.out.println("Nome "+ nome.toUpperCase() +" Cognome " + cognome.toUpperCase());
            System.out.println("Indirizzo: " + super.Indirizzo.toUpperCase() + " Citta: " + super.Citta.toUpperCase());

        }
}
