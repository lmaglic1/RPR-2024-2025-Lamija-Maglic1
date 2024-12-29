public class Main{

    public static void main(String[] args){

        double[] nutritivneVrijednostiVoca={12, 8, 1, 2, 0};
        Voce voce = new Voce("Citrus sinensis", "Brazil", nutritivneVrijednostiVoca);

        double[] nutritivneVrijednostiPovrca={4, 5, 1, 4, 2};
        Povrce povrce = new Povrce("Solanum lycopersicum", "Italija", nutritivneVrijednostiPovrca);

        double[] nutritivneVrijednostiMesa={30, 0, 40, 0, 0};
        Meso meso = new Meso("Bos taurus", "Francuska", nutritivneVrijednostiMesa);

        Prodavac prodavac = new Prodavac("Marko", "Markic", 5, "12345601");

        System.out.println("Voce kalorije: "+ voce.DajBrojKalorija());
        System.out.println("Voce zdravlje: "+ voce.Zdravlje(0.8));

        System.out.println("Povrce kalorije: "+ povrce.DajBrojKalorija());
        System.out.println("Povrce zdravlje: "+ povrce.Zdravlje(0.6));

        System.out.println("Meso kalorije: "+ meso.DajBrojKalorija());
        System.out.println("Meso zdravlje: "+ meso.Zdravlje(0.97));

        System.out.println("Prodavac zdravlje: "+ prodavac.Zdravlje((0.0)));
    }

}