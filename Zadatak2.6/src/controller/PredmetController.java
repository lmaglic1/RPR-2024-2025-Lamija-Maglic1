package controller;

import model.Predmet;
import view.PredmetView;

import java.util.List;

public class PredmetController {
    private Predmet model;
    private static PredmetView view;


    public PredmetController(Predmet model, PredmetView view){
        this.model = model;
        this.view = view;
    }

    public Predmet getModel(){
        return model;
    }

    public void setModel(Predmet model){
        this.model = model;
    }

    public PredmetView getView(){
        return view;
    }

    public void setView(PredmetView view){
        this.view = view;
    }

    public void azurirajImePredmeta(){
        try{
            model.setNaziv(view.getUlazniTekst());
            view.setPoruka("Ime je uspješno ažurirano!");
        }catch(Exception e){
            view.setPoruka("Greska: " +e.getMessage());
        }
    }

    public void azurirajECTSBodove(){
        try{
            String ulaz = view.getUlazniTekst();
            Double noviECTS = Double.parseDouble(ulaz);
            model.setECTS(noviECTS);
            view.setPoruka("ECTS bodovi su uspješno ažurirani!");
        }catch(Exception e){
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    public static void dajPredmeteIzTxtDatoteke(String filePath){
        try{
            List<Predmet> predmet = Predmet.ucitajPredmeteIzTxtDatoteke(filePath);
            String poruka = "Predmeti učitani iz datoteke su: \n";
            for(Predmet predmeti : predmet){

                poruka += predmet.toString() + "\n";
            }
            view.setPoruka(poruka);
        }catch(Exception e){
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

}

