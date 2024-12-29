public class Povrce extends Hrana implements IZdravlje{
    public Povrce(String latinskiNaziv, String zemljaPorijekla, double[] nutritivneVrijednosti) {
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

    @Override
    public boolean Zdravlje(double koeficijentZdravlja) {
        return DajBrojKalorija()<100 && (koeficijentZdravlja>=0.5 && koeficijentZdravlja<=0.7);
    }
}