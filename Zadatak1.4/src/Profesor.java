import java.util.Date;

public class Profesor extends NastavnoOsoblje{

    private String zvanje;
    private Integer brojDipolomanat;
    public Profesor(String ime, String prezime, String adresa, Date datumRodjenja, Integer norma, Integer godinaZaposljenja, String kancelarija, String zvanje, Integer brojDipolomanat) {
        super(ime, prezime, adresa, datumRodjenja, norma, godinaZaposljenja, kancelarija);
        this.zvanje = zvanje;
        this.brojDipolomanat = brojDipolomanat;
    }

    public String DajInformacije(){
        return "Profesor: " + zvanje + " " + ime + " " + prezime;
    }
}