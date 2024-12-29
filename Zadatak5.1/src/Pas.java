import java.util.Date;

public class Pas extends Ljubimac{

    private VrstaPsa vrstaPsa;

    public Pas(String ime, Date datumRodjenja, String zdravstvenoStanje, VrstaPsa vrstaPsa){
        super(ime, datumRodjenja, zdravstvenoStanje);
        this.vrstaPsa = vrstaPsa;
    }

    @Override
    public String PrikaziInformacije() {
        return "Pas: " + vrstaPsa;
    }
}
