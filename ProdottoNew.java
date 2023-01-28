import java.util.Objects;

public class ProdottoNew {
    private String codice;
    private String matricola;
    private String descrizione;
    private String um;
    public ProdottoNew(String codice, String matricola, String descrizione, String um) {

    //public void Prodottonew (){}
    //public void Prodottonew (String codice, String matricola, String descrizione, String um){
        this.codice=codice;
        this.matricola=matricola;
        this.descrizione=descrizione;
        this.um=um;
    }

    public ProdottoNew() {

    }

    public String getCodice(){
        return codice;
    }
    public void  SetCodice(String codice){
        this.codice=codice;
    }
    public String getMatricola(){
        return matricola;
    }
    public void  SetMatricola(String matricola){
        this.matricola=matricola;
    }
    public String getDescrizione(){
        return descrizione;
    }
    public void  SetDescrizione(String descrizione){
        this.descrizione=descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdottoNew that)) return false;
        return codice.equals(that.codice) && matricola.equals(that.matricola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice, matricola);
    }

       @Override
    public String toString() {
        return "ProdottoNew{" +
                "codice='" + codice + '\'' +
                ", matricola='" + matricola + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", um='" + um + '\'' +
                '}';
    }

    public String getCodice(String codiceProdotto, String matricolaProdotto) {
        return codiceProdotto;
    }


}
