package controller;

import model.Predmet;
import model.PredmetModel;
import view.PredmetView;

import java.util.List;

public class PredmetController {

    private PredmetModel model;
    private PredmetView view;


    public PredmetController(PredmetModel model, PredmetView view){
        this.model = model;
        this.view = view;
    }

    public Predmet dajPredmetPoNazivu(String naziv){
        return model.dajPredmetPoImenu(naziv);
    }

    public void azurirajIme(String naziv){
        try{
            model.azurirajPredmet(naziv, view.getUlazniTekst(), null,null);
            view.setPoruka("Naziv uspješno ažuriran!");
        }catch(Exception e){
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    public void dajPredmetIzTxtDatoteke(String filePath) {
        try
        {
            List<Predmet> osobe = Predmet.ucitajPredmetIzTxtDatoteke(filePath);
            String poruka = "Predmeti ucitani iz txt datoteke su:\n";
            Predmet[] predmeti = new Predmet[0];
            for (Predmet predmet : predmeti)
            {
                poruka += predmet.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e)
        {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
}
