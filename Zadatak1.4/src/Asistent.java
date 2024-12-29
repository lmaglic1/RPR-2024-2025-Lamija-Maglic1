import java.util.Date;

public class Asistent extends NastavnoOsoblje{

    private String laboratorija, termin;

    public Asistent(String ime, String prezime, String adresa, Date datumRodjenja, Integer norma, Integer godinaZaposljenja, String kancelarija, String laboratorija, String termin) {
        super(ime, prezime, adresa, datumRodjenja, norma, godinaZaposljenja, kancelarija);
        this.laboratorija = laboratorija;
        this.termin = termin;
    }
}