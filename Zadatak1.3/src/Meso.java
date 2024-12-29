public class Meso extends Hrana implements IZdravlje{
    public Meso(String latinskiNaziv, String zemljaPorijekla, double[] nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }

    @Override
    public double DajBrojKalorija() {
        double kalorije = 0.0;
        for(double nutritivnaVrijednost : nutritivneVrijednosti){
            kalorije+=nutritivnaVrijednost;
        }
        return kalorije*1.2;
    }

    @Override
    public boolean Zdravlje(double koeficijentZdravlja) {
        return koeficijentZdravlja>0.95;
    }
}