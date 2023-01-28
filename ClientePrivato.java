import java.util.Scanner;
public class ClientePrivato extends ClienteGenerico {
        String nome= "";
        String cognome= "";
        ClientePrivato(String Indirizzo, String Citta,String CodiceFiscale) {

            Scanner ClPr = new Scanner(System.in);
            System.out.println("Inserire il nome ");
            nome = ClPr.nextLine();
            System.out.println("inserire il cognome : " + cognome);
            cognome = ClPr.nextLine();
            System.out.println("********************************************");
            System.out.print("Codice Fiscale :" + CodiceFiscale + "\n");
            System.out.println("Nome "+ nome.toUpperCase() +" Cognome " + cognome.toUpperCase());
            System.out.println("Indirizzo: " + super.Indirizzo.toUpperCase() + " Citta: " + super.Citta.toUpperCase());
            System.out.println("********************************************"+ "\n");

        }
}
