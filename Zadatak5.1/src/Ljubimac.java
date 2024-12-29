import java.util.Date;

abstract class Ljubimac {

    private String ime;
    private Date datumRodjenja;
    private String zdravstveoStanje;

    public Ljubimac(String ime, Date datumRodjenja, String zdravstveoStanje){
        this.ime = ime;
        this.datumRodjenja = datumRodjenja;
        this.zdravstveoStanje = zdravstveoStanje;
    }
public abstract String PrikaziInformacije();

}
