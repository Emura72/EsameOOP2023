import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.out;
public class CentroAssistenza {
    public CentroAssistenza() {
    }

    public static void main(String[] args) {
        int Numint = 0;
        String privato;
        String PartitaIva = "";
        String CodiceFiscale = "";
        String RagioneSociale = "";
        String Indirizzo = "";
        String Tecnico="";
        String ProblemaRiscontrato = "";
        String CodiceProdotto = "";
        String MatricolaProdotto = "";
        String Articolo = "";
        String StatoIntervento = "Aperto";
        String DescriInt = "";
        Double OreInt = 0.0;
        Double CostoInt = 0.0;
        LocalDate DataApertura = LocalDate.now();
        LocalDate DataChiusura = LocalDate.now();

        TreeMap<String, Cliente> cliente = new TreeMap<>();
        //inserimento di codici per scopi didattici in modo da avere clienti e prodotti preinseriti per testare il codice
        String codice = "MRURST72A07I452H";
        cliente.put(codice, new Cliente(codice, "Ernesto", "Mura", "", "", "MRURST72A07I452H", "Roma", "Via Cagliari"));
        // out.println(cliente.get(codice).toString());
        codice = "02382300909";
        cliente.put(codice, new Cliente(codice, "", "", "Seven informatica srl", "02382300909", "", "Sassari", "Via Roma"));
        //  out.println(cliente.get(codice).toString());
        codice = "11111111111";
        cliente.put(codice, new Cliente(codice, "", "", "Azienda di prova", "11111111111", "", "Roma", "Via Italia"));
        //**********
        ArrayList<ProdottoNew> list = new ArrayList<>();
        // inserisco un pò di codici per testare il funzionamento
        list.add(new ProdottoNew("123", "111111", "Personal computer", "Pz"));
        list.add(new ProdottoNew("234", "222222", "Stampante Laser", "Pz"));
        list.add(new ProdottoNew("345", "333333", "Monitor LCD", "Pz"));
        //*******
        HashMap<Integer, Ticket> ticket = new HashMap<>();
        ticket.put(1, new Ticket(1, LocalDate.now(), "11111111111", "","Azienda di prova","Tecnico1" , "Non Parte", "123", "111111", "Aperto", "", 0.0, 0.0, LocalDate.now()));
        ticket.put(2, new Ticket(2, LocalDate.now(), "02382300909", "", "Seven Informatica srl", "Tecnico1" ,"Sfarfallio", "345", "333333", "Aperto", "", 0.0, 0.0, LocalDate.now()));
        ticket.put(3, new Ticket(3, LocalDate.now(), "", "MRURST72A07I452H", "Ernesto Mura", "Tecnico2" ,"Carta Inceppata", "234", "222222", "Aperto", "", 0.0, 0.0, LocalDate.now()));
        //********

        // Iterator<Map.Entry<Integer,Ticket>> tik=ticket.entrySet().iterator();
        //  while (tik.hasNext()) {
        //    Map.Entry<Integer, Ticket> e = tik.next();
        //    out.println(e.toString());
        //     out.println(e.getKey());
        //     out.println(e.getValue());
        //     out.println("Prossimo ticket ");
        //  }
        //********
        out.println("\n");
        out.println("                                            ********** Esame di OOP 2023 **********");
        out.println("                                         **** Gestione Centro Assistenza Tecnica ****");
        int x = 99;
        while (x != 0) {
            Scanner sc;
            try {
                Scanner ScTe = new Scanner(System.in); //scanner della scelta del case
                Scanner ScCp = new Scanner(System.in); //scanner della scelta cliente privato o azienda
                //out.println("\n");
                out.println("********** MENU' *************");
                //out.println("\n");
                out.println("1 Inserimento anagrafica cliente : ");
                out.println("2 Inserimento anagrafica apparecchio : ");
                out.println("3 apertura Ticket : ");
                out.println("4 Aggiornamento Ticket : ");
                out.println("5 statistiche interventi : ");
                out.println("0 Uscita : ");
                x = ScTe.nextInt();
                out.println("\n");

                switch (x) {
                    case (1):

                        out.println("Inserimento anagrafica cliente ");
                        out.println("Il cliente è Privato (P) o Azienda (A) (P/A)");
                        privato = ScCp.next();
                        privato = privato.toUpperCase();
                        //in base alla risposta inserisco i dati Aziendali o Privati
                        if (privato.equals("P")) {
                            String codfisc;
                            do {
                                out.println("Inserire Codice fiscale (16 caratteri)");
                                codfisc = ScCp.next();
                            } while (codfisc.length() != 16);
                            codfisc = codfisc.toUpperCase();
                            //verifico se il cliente esiste in caso di assenza permetto l'inserimento
                            boolean result = true;
                            try {
                                result = cliente.get(codfisc) == null;
                            } catch (NullPointerException e) {
                                System.out.println("Codice fiscale non presente");
                            }
                            if (!result) {
                                System.out.println("cliente " + cliente.get(codfisc));
                                System.out.println("Codice fiscale " + codfisc + " già esistente ");
                                break;
                            }
                            //System.out.println("result "+result);
                            ClientePrivato clientepriv = new ClientePrivato("", "", codfisc);
                            codice = codfisc;
                            cliente.put(codice, new Cliente(codice, clientepriv.nome, clientepriv.cognome, "", "", codfisc, clientepriv.Citta, clientepriv.Indirizzo));
                        }
                        if (privato.equals("A")) {
                            String piva;
                            do {
                                out.println("Inserire la partita iva (11 caratteri)");
                                piva = ScCp.next();
                            } while (piva.length() != 11);
                            //verifico se il cliente esiste in caso di assenza permetto l'inserimento
                            boolean result = true;
                            try {
                                result = cliente.get(piva) == null;
                            } catch (NullPointerException e) {
                                System.out.println("Partita Iva non presente");
                            }
                            if (!result) {
                                System.out.println("cliente " + cliente.get(piva));
                                System.out.println("Partita Iva " + piva + " già esistente ");
                                break;
                            }
                            ClienteAzienda clienteaz = new ClienteAzienda(piva);
                            codice = piva;
                            cliente.put(codice, new Cliente(codice, "", "", clienteaz.Ragionesociale, piva, "", clienteaz.Citta, clienteaz.Indirizzo));
                        }
                        out.println("Vuoi visualizzare lista clienti presenti (S/N)");
                        String scelta = ScCp.next();
                        privato = scelta.toUpperCase();
                        //in base alla risposta visualizzo elenco prodotti
                        if (privato.equals("S")) {
                            Iterator<Map.Entry<String, Cliente>> cli = cliente.entrySet().iterator();
                            while (cli.hasNext()) {
                                Map.Entry<String, Cliente> e = cli.next();
                                out.println(e.getKey());
                                out.println(e.getValue());

                                out.println("Prossimo Clientet ");
                            }
                        }
                        break;
                    case (2):
                        //vado  leggere il nuovo codice e ne verifico l'esistenza
                        sc = new Scanner(System.in);
                        out.println("Inserimento nuovo codice prodotto ");
                        out.println("Inserire Codice ");
                        String CodProdotto = sc.nextLine();
                        out.println("Inserire la Matricola ");
                        String MatProdotto = sc.nextLine();
                        Iterator<ProdottoNew> it = list.iterator();
                        boolean b = true;
                        while (it.hasNext()) {
                            ProdottoNew p = it.next();
                            //verifico se il prodotto esiste (codice e matricola uguali) in caso di assenza permetto l'inserimento
                            //  System.out.println("Ciclo while per vedere i prodotti "+p.toString());
                            if (CodProdotto.equals(p.getCodice()) && MatProdotto.equals(p.getMatricola())) {
                                out.println("Codice già esistente ");
                                b = false;
                                break;
                            }
                        }
                        if (b) {
                            out.println("Inserire Descrizione ");
                            String descrizione = sc.nextLine();
                            out.println("Inserire unità di misura ");
                            String um = sc.nextLine();
                            list.add(new ProdottoNew(CodProdotto, MatProdotto, descrizione, um));
                        }
                        out.println("Vuoi visualizzare articoli presenti (S/N)");
                        scelta = ScCp.next();
                        privato = scelta.toUpperCase();
                        //in base alla risposta visualizzo elenco prodotti
                        if (privato.equals("S")) {
                            for (ProdottoNew pr : list) {
                                out.println(pr);
                            }
                        }
                        break;
                    case (3):
                        Numint = 3;

                        Scanner ScTi = new Scanner(System.in);
                        //inserisco codice fiscale o partita iva e controllo correttezza
                        out.println("**************************** Apertura ticket *****************************");
                        String IdCliente;
                        do {
                            out.println("Inserimento cliente (Codice Fiscale o Partita Iva) : ");
                            IdCliente = ScCp.next();
                        } while ((IdCliente.length() != 16) && (IdCliente.length() != 11));
                        IdCliente = IdCliente.toUpperCase();
                        //out.println("Codice cliente inserito :"+IdCliente);
                        //verifico se l'identificativo del cliente esiste
                        //se non esiste rimando al menu per inserimento
                        boolean result = false;
                        try {
                            result = cliente.get(IdCliente) == null;
                        } catch (NullPointerException e) {
                            System.out.println("Inserire Anagrafica Cliente. Partita Iva o Codice Fiscale non presenti ");
                        }
                        if (!result) {
                            // System.out.println("cliente "+ cliente.get(IdCliente));
                            System.out.println("OK! Identificativo Cliente " + IdCliente + " già esistente ");
                            out.println("*********************************** Apertura ticket ***********************************");
                            // il cliente esiste vado ad inserire gli altri dati del ticket in HasMap
                        }
                        Numint = Numint + 1;
                        DataApertura = LocalDate.now();
                        DateTimeFormatter y = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        out.println("Tecnico Assegnato ");
                        String tecnico = ScTi.nextLine();
                        out.println("Intervento : " + Numint + " -------- Data Apertura :" + DataApertura.format(y)+" Tecnico "+tecnico);
                        if (IdCliente.length() == 11) PartitaIva = IdCliente;
                        else CodiceFiscale = IdCliente;
                        out.println("Codice Apparecchio ");
                        CodiceProdotto = ScTi.nextLine();
                        out.println("Matricola Prodotto ");
                        MatricolaProdotto = ScTi.nextLine();
                        //inserisco prodotto e verifico se esiste (codice e matricola uguali) in tal caso carico il ticket
                        //boolean ctr=false;
                        b = true;
                        int indice = -1;
                        for (ProdottoNew p1 : list) {
                            if (CodiceProdotto.equals(p1.getCodice()) && MatricolaProdotto.equals(p1.getMatricola())) {
                                indice = indice + 1;
                                out.println("OK! Prodotto esistente!" + "\n");
                                out.println("Problema Riscontrato ");
                                String ProbRisc = ScTi.nextLine();
                                System.out.println("Num " + Numint);
                                ticket.put(Numint, new Ticket(Numint, DataApertura, PartitaIva, CodiceFiscale, RagioneSociale,tecnico, ProbRisc, CodiceProdotto, MatricolaProdotto, StatoIntervento, DescriInt, OreInt, CostoInt, DataChiusura));
                                out.println(ticket.get(Numint).Numero);
                                out.println(ticket.get(Numint).DataApertura);
                                out.println("inserimento ticket");
                                out.println("************************************************************************************** ");
                                out.println("Ticket Num. .  [" + Numint + "] ---------  Data Apertura= " + DataApertura + " ------- Stato Intervento = " + StatoIntervento+" Tecnico "+tecnico);
                                out.println("");
                                out.println("");
                                out.println("Identificativo Cliente " + PartitaIva + CodiceFiscale);
                                RagioneSociale = cliente.get(IdCliente).getRagionesociale(); // ???????????????
                                out.println("Ragione Sociale: " + RagioneSociale);
                                Indirizzo = cliente.get(IdCliente).getCitta() + " - " + cliente.get(IdCliente).getIndirizzo();
                                out.println("Indirizzo: " + Indirizzo);
                                out.println("");
                                Articolo = String.valueOf(list.get(indice).getDescrizione()); // ???????????????
                                out.println("Articolo: " + Articolo);
                                out.println("Codice Prodotto = " + CodiceProdotto + " S/N :" + MatricolaProdotto);
                                out.println("");
                                out.println("Problema Riscontrato : " + ProbRisc);
                                out.println("");
                                out.println("fine ticket ");
                                System.out.println("************************************************************************************** " + "\n");
                                b = false;
                                break;
                            }
                        }
                        if (b) {
                            out.println("+++++++++++ Attenzione !!!! Inserire prodotto mancante +++++++++++*");
                            break;
                        }
                        break;

                    case (4):
                        //richiamo il ticket inserito in hasmap e inserisco dati mancanti
                        //stato intervento (aperto-chiuso-attesa ricambi)
                        //ore lavoro e descrizione lavoro
                        //data chiusura intervento
                        out.println("aggiornamento ticket ");
                        // Iterator tik = ticket.entrySet().iterator();
                        // Verifica con il metodo hasNext() che nella hashmap
                        // ci siano altri elementi su cui ciclare
                        Object Iterator;
                        Iterator<Map.Entry<Integer, Ticket>> tik = ticket.entrySet().iterator();
                        //Map.Entry<Integer, Ticket> t = tik.next();
                        while (tik.hasNext()) {
                            Map.Entry<Integer, Ticket> e = tik.next();
                            out.println(e.getValue().toString());
                            out.println("Prossimo ticket ");
                        }
                        Scanner ScNt = new Scanner(System.in);
                        Scanner ScAg = new Scanner(System.in);
                        out.println("Inserire il numero del Ticket da aggiornare");
                        int numtick = ScNt.nextInt();
                        out.println("Inserire la descrizione del lavoro eseguito");
                        DescriInt = ScAg.nextLine();
                        out.println("Inserire il tempo di esecuzione del lavoro eseguito in h.");
                        OreInt = ScAg.nextDouble();
                        out.println("Inserire il costo orario del lavoro eseguito in €. ");
                        CostoInt = ScAg.nextDouble();
                        CostoInt = CostoInt * OreInt;
                        out.println("Inserire lo stato dell'intevento");
                        StatoIntervento = ScAg.nextLine();
                        DataChiusura = LocalDate.now();
                        ticket.put(numtick, new Ticket(numtick, DataApertura, PartitaIva, CodiceFiscale, RagioneSociale,Tecnico, ProblemaRiscontrato, CodiceProdotto, MatricolaProdotto, StatoIntervento, DescriInt, OreInt, CostoInt, DataChiusura));
                        out.println("Aggiornamento ticket");
                        out.println("************************************************************************************** ");
                        out.println("Ticket Num. .  [" + numtick + "] ---------  Data Apertura= " + DataApertura + " ------- Stato Intervento = " + StatoIntervento);
                        out.println("");
                        out.println("");
                        out.println("Identificativo Cliente " + PartitaIva + CodiceFiscale);
                        //RagioneSociale = cliente.get(IdCliente).getRagionesociale(); // ???????????????
                        out.println("Ragione Sociale: " + RagioneSociale);
                        //Indirizzo = cliente.get(IdCliente).getCitta() + " - " + cliente.get(IdCliente).getIndirizzo();
                        //out.println("Indirizzo: " + Indirizzo);
                        out.println("");
                        // Articolo = String.valueOf(list.get(indice).getDescrizione()); // ???????????????
                        //out.println("Articolo: " + Articolo);
                        out.println("Codice Prodotto = " + CodiceProdotto + " S/N :" + MatricolaProdotto);
                        out.println("");
                        out.println("Problema Riscontrato : " + ProblemaRiscontrato);
                        out.println("Descrizione Lavoro : " + DescriInt);
                        out.println("Ore Intervento : " + OreInt + " Costo Intervento :" + CostoInt);
                        out.println("Chiusura Intervento : " + DataChiusura);
                        out.println("");
                        out.println("fine ticket ");
                        System.out.println("************************************************************************************** " + "\n");
                        break;
                    case (5):
                        //richiedo codice se voglio statistica per prodotto o cliente data o tecnico
                        //stampo su csv i dati degli interventi estratti
                        int x1 = 99;
                        while (x1 != 0) {
                            try {
                                Scanner ScSt = new Scanner(System.in); //scanner della scelta del case esportazioni
                                Scanner scannerstampe = new Scanner(System.in);

                                out.println("*************** Stampe e esportazioni *************");
                                out.println("1 Esporta dati per cliente : ");
                                out.println("2 Esporta dati per Articolo : ");
                                out.println("3 Esporta dati per Tecnico : ");
                                out.println("0 Uscita : ");
                                x1 = ScSt.nextInt();
                                out.println("\n");

                                switch (x1) {
                                    case (1):
                                        out.println("**************Generazione file per cliente **************** ");
                                        File file1 = new File("cliente.csv");
                                        if (file1.exists()) {
                                            out.println("Il file esiste ");
                                            out.println("Il file si trova in " + file1.getAbsolutePath());
                                            out.println("vuoi eliminare il file esistente ? (S/N) ");
                                            String risposta1 = ScSt.nextLine();
                                            risposta1 = risposta1.toUpperCase();
                                            if (risposta1.equals("S")) {
                                                file1.delete();
                                            }
                                            try {
                                                FileWriter writer = new FileWriter("cliente.csv");
                                                out.println("Inserimento identificativo cliente Partita Iva o codice fiscale");
                                                String idcliente = scannerstampe.nextLine();
                                                idcliente = idcliente.toUpperCase();
                                                writer.write("Codice Fiscale"+";"+"Partita Iva"+";"+"Ragione Sociale"+";"+"Data Apertura"+";"+"Numero"+";"+"Codice Prodotto"+";"+"Problema Riscontrato"+";"+"Descrizione Intervento"+";"+"Ore Intervento"+";"+"Costo Intervento"+";"+"Stato Intervento"+";"+"Data Chiusura\n");
                                                Iterator<Map.Entry<Integer, Ticket>> tik1 = ticket.entrySet().iterator();
                                                while (tik1.hasNext())
                                                {
                                                    Map.Entry<Integer, Ticket> e = tik1.next();

                                                    if ((e.getValue().PartitaIva.equals(idcliente)) || (e.getValue().CodiceFiscale.equals(idcliente))) {

                                                    }
                                                        {
                                                            if  ((e.getValue().PartitaIva == null) || (e.getValue().CodiceFiscale == null)) {
                                                                out.println("Non ci sono elementi");}else{
                                                            writer.append(e.getValue().CodiceFiscale+";"+e.getValue().PartitaIva+";"+e.getValue().Ragionesociale+";"+e.getValue().DataApertura+";"+e.getValue().Numero+";"+e.getValue().CodiceProdotto+";"+e.getValue().ProblemaRiscontrato+";"+e.getValue().descrizioneIntervento+";"+e.getValue().OreIntervento+";"+e.getValue().CostoIntervento+";"+e.getValue().StatoIntervento+";"+e.getValue().DataChiusura+"\n");
                                                            writer.close();}
                                                        }
                                                }
                                                } catch (IOException e)
                                                    {
                                                throw new RuntimeException(e);
                                                    }
                                                        }
                                                        else {
                                                                System.out.println("Il file non esiste");
                                                                file1.createNewFile();
                                                                //writer.write("Codice Fiscale"+";"+"Partita Iva"+";"+"Ragione Sociale"+";"+"Data Apertura"+";"+"Numero"+";"+"Codice Prodotto"+";"+"Problema Riscontrato"+";"+"Descrizione Intervento"+";"+"Ore Intervento"+";"+"Costo Intervento"+";"+"Stato Intervento"+";"+"Data Chiusura\n");
                                                             }
                                                       break;

                    case (2):
                        out.println("************** Generazione file per Articolo **************** ");
                        File file2 = new File("articolo.csv");
                        if (file2.exists()) {
                            out.println("Il file esiste ");
                            out.println("Il file si trova in " + file2.getAbsolutePath());
                            out.println("vuoi eliminare il file esistente ? (S/N) ");
                            String risposta = ScSt.nextLine();
                            risposta = risposta.toUpperCase();
                            if (risposta.equals("S")) {
                                file2.delete();
                            }
                            try {
                                FileWriter writer = new FileWriter("articolo.csv");
                                out.println("Inserimento codice articolo");
                                String idarticolo = scannerstampe.nextLine();
                                idarticolo = idarticolo.toUpperCase();
                                Iterator<Map.Entry<Integer, Ticket>> tik1 = ticket.entrySet().iterator();
                                while (tik1.hasNext())
                                {
                                    Map.Entry<Integer, Ticket> e = tik1.next();
                                    writer.write("Codice Fiscale"+";"+"Partita Iva"+";"+"Ragione Sociale"+";"+"Data Apertura"+";"+"Numero"+";"+"Codice Prodotto"+";"+"Problema Riscontrato"+";"+"Descrizione Intervento"+";"+"Ore Intervento"+";"+"Costo Intervento"+";"+"Stato Intervento"+";"+"Data Chiusura\n");
                                    if ((e.getValue().CodiceProdotto.equals(idarticolo)) )
                                    {
                                        writer.append(e.getValue().CodiceFiscale+";"+e.getValue().PartitaIva+";"+e.getValue().Ragionesociale+";"+e.getValue().DataApertura+";"+e.getValue().Numero+";"+e.getValue().CodiceProdotto+";"+e.getValue().ProblemaRiscontrato+";"+e.getValue().descrizioneIntervento+";"+e.getValue().OreIntervento+";"+e.getValue().CostoIntervento+";"+e.getValue().StatoIntervento+";"+e.getValue().DataChiusura+"\n");
                                        writer.close();
                                    }
                                }
                            } catch (IOException e)
                            {
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            System.out.println("Il file non esiste");
                        }

                        break;
                    case (3):
                        out.println("**************Generazione file per Tecnico **************** ");
                        File file3 = new File("tecnico.csv");
                        if (file3.exists()) {
                            out.println("Il file esiste ");
                            out.println("Il file si trova in " + file3.getAbsolutePath());
                            out.println("vuoi eliminare il file esistente ? (S/N) ");
                            String risposta = ScSt.nextLine();
                            risposta = risposta.toUpperCase();
                            if (risposta.equals("S")) {
                                file3.delete();
                            }
                            try {
                                FileWriter writer = new FileWriter("tecnico.csv");
                                out.println("Inserimento codice Tecnico");
                                Tecnico = scannerstampe.nextLine();
                                Tecnico = Tecnico.toUpperCase();
                                Iterator<Map.Entry<Integer, Ticket>> tik1 = ticket.entrySet().iterator();
                                while (tik1.hasNext())
                                {
                                    Map.Entry<Integer, Ticket> e = tik1.next();
                                    writer.write("Codice Fiscale"+";"+"Partita Iva"+";"+"Ragione Sociale"+";"+"Data Apertura"+";"+"Numero"+";"+"Codice Prodotto"+";"+"Problema Riscontrato"+";"+"Descrizione Intervento"+";"+"Ore Intervento"+";"+"Costo Intervento"+";"+"Stato Intervento"+";"+"Data Chiusura\n");
                                    if ((e.getValue().Tecnico.equals(Tecnico)) )
                                    {
                                        writer.append(e.getValue().CodiceFiscale+";"+e.getValue().PartitaIva+";"+e.getValue().Ragionesociale+";"+e.getValue().DataApertura+";"+e.getValue().Numero+";"+e.getValue().CodiceProdotto+";"+e.getValue().ProblemaRiscontrato+";"+e.getValue().descrizioneIntervento+";"+e.getValue().OreIntervento+";"+e.getValue().CostoIntervento+";"+e.getValue().StatoIntervento+";"+e.getValue().DataChiusura+"\n");
                                        writer.close();
                                    }
                                }
                            } catch (IOException e)
                            {
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            System.out.println("Il file non esiste");
                        }
                        break;
                    case (0):
                        break;
                    default:
                        out.println("la scelta fatta non è corretta 0 per uscire ");
                }

            } catch (InputMismatchException e) {
                out.println("La scelta deve essere un numero da 0 a 3");
            }
        }
                //********************* Mcase del menu principale *********************
            case (0):
                out.println("uscita ");
                break;
            default:
                out.println("la scelta fatta non è corretta 0 per uscire ");
        }
        } catch (InputMismatchException e){ out.println("La scelta deve essere un numero da 0 a 5");
       //     break;
        } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        out.println("++++++++++++++++++++++++++++  siamo usciti dal programma +++++++++++++++++++++++++++++++++++");
    }
}


