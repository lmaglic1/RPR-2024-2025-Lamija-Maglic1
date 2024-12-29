public class Prodavac implements IZdravlje{

    public String ime;
    public String prezime;
    public int brojStanda;
    public String idLicenca;

    public Prodavac(String ime, String prezime, int brojStanda, String idLicenca){
        this.ime = ime;
        this.prezime = prezime;
        this.brojStanda = brojStanda;
        this.idLicenca = idLicenca;
    }

    @Override
    public boolean Zdravlje(double koeficijentZdravlja) {
        return idLicenca.endsWith("01");
    }
}