package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Predmet {

    private String naziv;
    private Double ECTS;

        public Predmet(String naziv, Double ECTS){
            setNaziv(naziv);
            setECTS(ECTS);
    }


   public String getNaziv() {
    return naziv;
}

    public void setNaziv(String naziv) {
    if(naziv == null || naziv.length()<= 5|| naziv.length()>=100){
        throw new IllegalArgumentException("Naziv mora biti između 5 i 100 karaktera!");
        }
    this.naziv = naziv;
    }

    public Double getECTS(){
            return ECTS;
    }

    public void setECTS(Double ECTS){
            if(ECTS == null || ECTS < 5.0 || ECTS > 20.0){
                throw new IllegalArgumentException("ECTS bodovi moraju biti između 5 i 20!");
            }

            double decimalPart=ECTS - Math.floor(ECTS);
            if(decimalPart!=0.0 && decimalPart!=0.5){
                throw new IllegalArgumentException("ECTS nije ispravan!");
            }
            this.ECTS = ECTS;
    }

    public static List<Predmet> ucitajPredmeteIzTxtDatoteke(String putanjaDoDatotekt)
        throws IOException{
            List<Predmet> predmet = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatotekt));
        String linija;
        while((linija = reader.readLine()) != null){
            String[] polja = linija.split(",");
            if(polja.length == 2){
                String naziv = polja[0];
                Double ECTS = Double.parseDouble(polja[1]);

                Predmet predmeti = new Predmet(naziv, ECTS);
                predmet.add(predmeti);
            }
        }
        reader.close();
        return predmet;
    }

    public String toString(){
            return "Student{" +
                    "naziv='" + naziv + '\'' +
                    ", ECTS=" + ECTS +
                    '}';
    }


}