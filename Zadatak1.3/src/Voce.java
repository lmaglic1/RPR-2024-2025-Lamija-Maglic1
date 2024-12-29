public class Voce extends Hrana implements IZdravlje{
    public Voce(String latinskiNaziv, String zemljaPorijekla, double[] nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }

    @Override
    public double DajBrojKalorija() {
        double kalorije = 0.0;
        for(double nutritivnaVrijednost : nutritivneVrijednosti){
            kalorije+=nutritivnaVrijednost;
        }
        return kalorije;
    }

    public boolean Zdravlje(double koeficientZdravlja){
        return koeficientZdravlja>=0.75 && DajBrojKalorija()>=50;
    }

}