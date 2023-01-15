import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class CentroAssistenza {
    public static void main(String[] args) {
        String privato;
        System.out.println("Esame di OOP 2023");
        System.out.println("Gestione Centro Assistenza Tecnica");
        int x = 99;
        while (x != 0) {
            Scanner codiceprodotto ;
            Scanner cliprivato;
            try {

                Scanner test = new Scanner(System.in);
                cliprivato = new Scanner(System.in);
                System.out.println("****** MENU' **********");
                System.out.println("1 Inserimento anagrafica cliente : ");
                System.out.println("2 Inserimento anagrafica apparecchio : ");
                System.out.println("3 apertura Ticket : ");
                System.out.println("4 Aggiornamento Ticket : ");
                System.out.println("5 statistiche interventi : ");
                System.out.println("0 Uscita : ");
                x = test.nextInt();//per inserire numero nextint
                System.out.println("il numero la scelta da menù :" + x);


            switch (x){
            case (1):
                System.out.println("Inserimento anagrafica cliente ");
                System.out.println("Il cliente è Privato (P) o Azienda (A) (P/A)");
                privato = cliprivato.next();
                privato = privato.toUpperCase();
                //in base alla risposta inserisco i dati aziendali o privati
                if (privato.equals("P")) {
                    //verifico se il cliente è già presente
                    String codfisc;
                    System.out.println("Inserire Codice fiscale ");
                    codfisc = cliprivato.next();
                    //if (verificaCliente()==False){
                    ClientePrivato cliente = new ClientePrivato("", "", codfisc);

                    //}
                }
                if (privato.equals("A")) {
                    String piva;
                    System.out.println("Inserire la partita iva ");
                    //cliprivato.next();    //verifico se il cliente è già presente
                    piva = cliprivato.next();
                    //if (verificaCliente()==False){
                    ClienteAzienda clienteaz = new ClienteAzienda( piva);
                    //}
                }
                break;
            case (2):

                // inserisco un pò di codici per testare il funzionamento
                ArrayList<ProdottoNew> list=new ArrayList<>();
                list.add(new ProdottoNew("123","112233","Personal computer","Pz"));
                list.add(new ProdottoNew("234","223344","Stampante Laser","Pz"));
                list.add(new ProdottoNew("456","334455","Monitor LCD","Pz"));
                //vado  leggere il nuovo codice e ne verifico l'esistenza
                codiceprodotto = new Scanner(System.in);
                System.out.println("Inserimento nuovo codice prodotto ");
                System.out.println("Inserire Codice ");
                String codice = codiceprodotto.nextLine();
                System.out.println("Inserire la Matricola ");
                String matricola = codiceprodotto.nextLine();
                Iterator<ProdottoNew> it=list.iterator();
                boolean result;
                while(it.hasNext()){
                ProdottoNew p =it.next() ;
                //in base all'equals due prodotti sono uguali se hanno codice e matricola uguali
                    //***** non sta entrando nel ciclo perchè nn riconosce l'equal true *****
               if (codiceprodotto.equals(p) ) {
                    result= (p.equals(codiceprodotto)) ;
                    System.out.println("Codice già esistente ");
                    System.out.println("result di equals "+result);
                    break;
                   }
                    System.out.println("Inserire Descrizione ");
                    String descrizione = codiceprodotto.nextLine();
                    System.out.println("Inserire unità di misura ");
                    String um = codiceprodotto.nextLine();
                    list.add(new ProdottoNew(codice,matricola,descrizione,um));
                    break;
                }
                System.out.println("Vuoi visualizzare articoli presenti (S/N)");
                String scelta = cliprivato.next();
                privato = scelta.toUpperCase();
                               //in base alla risposta inserisco stampa elenco prodotti
              if (privato.equals("S")) {
                Iterator<ProdottoNew> iter=list.iterator();
                while(iter.hasNext()){
                   ProdottoNew p =iter.next();
                   System.out.println(p);
                    }
                  }
                break;
            case (3):
                System.out.println("Apertura ticket ");
                break;
            case (4):
                System.out.println("aggiornamento ticket ");
                break;
            case (5):
                System.out.println("Statistiche ed esportazioni ");
                break;
            case (0):
                System.out.println("uscita ");
                break;
            default:
                System.out.println("la scelta fatta non è corretta 0 per uscire ");
        }
        } catch (InputMismatchException e){ System.out.println("La scelta deve essere un numero da 0 a 5");
       //     break;
        } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("siamo usciti dal programma ");
    }


}


