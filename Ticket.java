import java.time.LocalDate;


public class Ticket {
    int Numero;
    LocalDate DataApertura;
    String PartitaIva;
    String CodiceFiscale;
    String Ragionesociale;
    String ProblemaRiscontrato;
    String CodiceProdotto;
    String MatricolaProdotto;
    String StatoIntervento;
    String descrizioneIntervento;
    Double OreIntervento;
    Double CostoIntervento;
    LocalDate DataChiusura;
    Ticket(int Numero, LocalDate DataApertura, String PartitaIva,String CodiceFiscale, String Ragionesociale, String ProblemaRiscontrato, String CodiceProdotto,String MatricolaProdotto, String StatoIntervento,  String descrizioneIntervento, Double OreIntervento, Double CostoIntervento, LocalDate DataChiusura) {
    }
    {
            this.Numero=Numero;
            this.DataApertura=DataApertura;
            this.PartitaIva=PartitaIva;
            this.CodiceFiscale=CodiceFiscale;
            this.Ragionesociale=Ragionesociale;
            this.ProblemaRiscontrato=ProblemaRiscontrato;
            this.CodiceProdotto=CodiceProdotto;
            this.MatricolaProdotto=MatricolaProdotto;
            this.StatoIntervento=StatoIntervento;
            this.DataChiusura=DataChiusura;
            this.descrizioneIntervento=descrizioneIntervento;
            this.OreIntervento=OreIntervento;
            this.CostoIntervento=CostoIntervento;
        }
    public int getNumero() {
        return Numero;
    }
    public void setNumero(int numero) {
        Numero = numero;
    }
    public LocalDate getDataApertura() {
        return DataApertura;
    }
    public void setDataApertura(LocalDate DataApertura) {
        DataApertura = DataApertura;
    }
    public String getPartitaIva() {
        return PartitaIva;
    }
    public void setPartitaIva(String partitaIva) {
        PartitaIva = partitaIva;
    }
    public String getCodiceFiscale() {
        return CodiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        CodiceFiscale = codiceFiscale;
    }
    public String getRagionesociale() {
        return Ragionesociale;
    }
    public void setRagionesociale(String ragionesociale) {
        Ragionesociale = ragionesociale;
    }
    public String getProblemaRiscontrato() {
        return ProblemaRiscontrato;
    }
    public void setProblemaRiscontrato(String ProblemaRiscontrato) {
        ProblemaRiscontrato = ProblemaRiscontrato;
    }
    public String getCodiceProdotto() {
        return CodiceProdotto;
    }
    public void setCodiceProdotto(String CodiceProdotto) {
        CodiceProdotto = CodiceProdotto;
    }
    public String getMatricolaProdotto() {
        return MatricolaProdotto;
    }
    public void setMatricolaProdotto(String MatricolaProdotto) {
        MatricolaProdotto = MatricolaProdotto;
    }
    public String getStatoIntervento() {
        return StatoIntervento;
    }
    public void setStatoIntervento(String StatoIntervento) {
        StatoIntervento = StatoIntervento;
    }
    public String getDescrizioneIntervento() {
        return descrizioneIntervento;
    }
    public void setDescrizioneIntervento(String DescrizioneIntervento) {
        this.descrizioneIntervento = DescrizioneIntervento;
    }
    public Double getOreIntervento() {
        return OreIntervento;
    }
    public void setOreIntervento(Double oreIntervento) {
        OreIntervento = oreIntervento;
    }
    public Double getCostoIntervento() {
        return CostoIntervento;
    }
    public void setCostoIntervento(Double costoIntervento) {
        CostoIntervento = costoIntervento;
    }
    public LocalDate getDataChiusura() {
        return DataChiusura;
    }
    public void setDataChiusura(LocalDate dataChiusura) {
        DataChiusura = dataChiusura;
    }

    @Override
    public String toString() {
        return "Ticket Nr{" +
                "Numero= " + Numero +"-  Data Apertura= " + DataApertura + ", Stato Intervento='" + StatoIntervento + '\'' +
                ", Partita Iva= " + PartitaIva + " Codice Fiscale= " + CodiceFiscale + '\'' +
                ", Ragione sociale= " + Ragionesociale + '\'' +
               ", Problema Riscontrato='" + ProblemaRiscontrato + '\'' +
                ", Codice Prodotto=' " + CodiceProdotto + "  -- " +MatricolaProdotto+
                ", descrizione Intervento='" + descrizioneIntervento + '\'' +
                ", Ore Intervento=" + OreIntervento + ", Costo Intervento=" + CostoIntervento + '\'' +
                ", Data Chiusura=" + DataChiusura +
                '}';
    }
}

