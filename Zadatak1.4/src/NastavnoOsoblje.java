import java.util.Date;

public abstract class NastavnoOsoblje extends Osoba{

    protected Integer norma, godinaZaposljenja;
    protected String kancelarija;
    public NastavnoOsoblje(String ime, String prezime, String adresa, Date datumRodjenja, Integer norma, Integer godinaZaposljenja, String kancelarija) {
        super(ime, prezime, adresa, datumRodjenja);
        this.norma = norma;
        this.godinaZaposljenja = godinaZaposljenja;
        this.kancelarija = kancelarija;
    }
}