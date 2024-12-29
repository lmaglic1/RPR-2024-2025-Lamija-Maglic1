import java.util.List;

public abstract class Hrana implements IZdravlje{

    public String latinskiNaziv;
    public String zemljaPorijekla;
    public double[] nutritivneVrijednosti;

    public Hrana(String latinskiNaziv, String zemljaPorijekla, double[] nutritivneVrijednosti){
        this.latinskiNaziv = latinskiNaziv;
        this.zemljaPorijekla = zemljaPorijekla;
        this.nutritivneVrijednosti = nutritivneVrijednosti;
    }

    public double DajBrojKalorija(){
        return 0;
    }

}