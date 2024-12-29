import java.util.Date;

public class Macka extends Ljubimac{

    private VrstaMacke vrstaMacke;

    public Macka(String ime, Date datumRodjenja, String zdravstvenoStanje, VrstaMacke vrstaMacke){
        super(ime, datumRodjenja, zdravstvenoStanje);
        this.vrstaMacke = vrstaMacke;
    }

    public String PrikaziInformacije(){
        return "Macka: " + vrstaMacke;
    }

}
