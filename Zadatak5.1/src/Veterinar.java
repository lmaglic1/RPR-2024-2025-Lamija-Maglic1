import java.util.ArrayList;
import java.util.List;

public class Veterinar {

    private String ime;
    private Specijalizacija specijalizacija;
    private List<Ljubimac> pregledi;

    public Veterinar(String ime, Specijalizacija specijalizacija, List<Ljubimac> pregledi){
        this.ime = ime;
        this.specijalizacija = specijalizacija;
        this.pregledi = new ArrayList<>();
    }

    public void PregledajLjubimca(Ljubimac ljubimac) throws ValidacijaVrsteException{
        if((specijalizacija == Specijalizacija.Psi && ljubimac instanceof Pas) || (specijalizacija == Specijalizacija.Macke && ljubimac instanceof Macka)){
            pregledi.add(ljubimac);
        }else{
            throw new ValidacijaVrsteException("Veterinar nije specijalizovan za ovu vrstu ljubimca.");
        }
    }
}
