import java.util.Objects;
public class Cliente {
    String Codice;
    String Nome;
    String Cognome;
    String Ragionesociale;
    String Indirizzo;
    String Piva;
    String Codifisc;
    String Citta;
        //in questo seguente modo si definisce il costruttore che permette di decidere quali sono i dati
        //da passare come parametri
        Cliente(String Codice ,String Nome,String Cognome,String Ragionesociale,String Piva,String Codfisc,String Citta,String Indirizzo){
            this.Codice=Codice;
            this.Nome=Nome;//la parola this permette di volta in volta di attribuire i valori delle istanze differenti
            //associate ai singoli campi
            this.Cognome=Cognome;
            this.Ragionesociale=Ragionesociale;
            this.Piva=Piva;
            this.Codifisc=Codfisc;
            this.Indirizzo=Indirizzo;
            this.Citta=Citta;
        }
    public String getCodice() {
        return Codice;
    }
    public String getNome() {
        return Nome;
    }
    public String getCognome() {
        return Cognome;
    }
    public String getRagionesociale() {
        return Ragionesociale;
    }
    public String getIndirizzo() {
        return Indirizzo;
    }
    public String getPiva() {
        return Piva;
    }
    public String getCodifisc() {
        return Codifisc;
    }
    public String getCitta() {
        return Citta;
    }
    public void setCodice(String codice) {
        Codice = codice;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public void setCognome(String cognome) {
        Cognome = cognome;
    }
    public void setRagionesociale(String ragionesociale) {
        Ragionesociale = ragionesociale;
    }
    public void setIndirizzo(String indirizzo) {
        Indirizzo = indirizzo;
    }
    public void setPiva(String piva) {
        Piva = piva;
    }
    public void setCodifisc(String codifisc) {
        Codifisc = codifisc;
    }
    public void setCitta(String citta) {
        Citta = citta;
    }
    @Override
    public String toString() {
        return "Cliente{" +" Codice "+Codice +
                " Nome= " + Nome + '\'' +
                ", Cognome= " + Cognome + '\'' +
                ", Ragionesociale= " + Ragionesociale + '\'' +
                ", Indirizzo= " + Indirizzo + '\'' +
                ", Piva= " + Piva + '\'' +
                ", Codifisc= " + Codifisc + '\'' +
                ", Citta= " + Citta + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(Piva, cliente.Piva) || Objects.equals(Codifisc, cliente.Codifisc);

    }
    @Override
    public int hashCode() {
        return Objects.hash(Piva, Codifisc);
    }
}
