import java.util.List;

public class Predmet implements IInformacije{

    private String naziv;
    private Profesor odgovorniProfesor;
    private List<Asistent> asistent;
    private Double ECTS;

    Predmet(String naziv, Profesor odgovorniProfesor, List<Asistent> asistent, Double ECTS){
        this.naziv = naziv;
        this.odgovorniProfesor = odgovorniProfesor;
        this.asistent = asistent;
        this.ECTS = ECTS;
    }

    @Override
    public String DajInformacije() {
        return "Predmet: " + naziv + ", odgovorni profesor:  " +odgovorniProfesor.DajInformacije();
    }
}