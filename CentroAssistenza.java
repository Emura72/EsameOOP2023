    import java.util.Scanner;
    public class CentroAssistenza {
        public static void main(String[] args){
            System.out.println("Esame di OOP 2023");
            System.out.println("Gestione Centro Assistenza Tecnica");
            int x=99;
            while (x!=0){
                Scanner test=new Scanner(System.in);
                System.out.println("****** MENU' **********");
                System.out.println("1 Inserimento anagrafica cliente : ");
                System.out.println("2 Inserimento anagrafica apparecchio : ");
                System.out.println("3 apertura Ticket : ");
                System.out.println("4 Aggiornamento Ticket : ");
                System.out.println("5 statistiche interventi : ");
                System.out.println("0 Uscita : ");
                x=test.nextInt();//per inserire numero nextint
                System.out.println("il numero la scelta da menù :" +x);
                switch(x) {
                    case (1):
                        System.out.println("Inserimento anagrafica cliente ");
                        break;
                    case (2):
                        System.out.println("Inserimento anagrafica prodotto ");
                        break;
                    case (3):
                        System.out.println("Apertura ticket ");
                        break;
                    case (4):
                        System.out.println("inserimento ticket ");
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

            }
            System.out.println("siamo usciti dal programma ");
        }
    }


