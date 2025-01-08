package controller;

import model.Osoba;
import view.OsobaView;

import java.util.List;

public class OsobaController {
    public Osoba model;
    public OsobaView view;

    public OsobaController(Osoba model, OsobaView view){
        this.model = model;
        this.view = view;
    }

    public void setModel(Osoba model){
        this.model = model;

    }

    public void setView(OsobaView view){
        this.view = view;

    }

public void azurirajIme(){
        try{
            model.setIme(view.getUlazniTekst());
            view.setPoruka("Ime je uspjesno azurirano!");
        }catch(Exception e){
            view.setPoruka("Greska: " + e.getMessage());

        }
}

    public void dajOsobeIzTxtDatoteke(String filePath)
    {
        try
        {
            List<Osoba> osobe = Osoba.ucitajOsobeIzTxtDatoteke(filePath);
            String poruka = "Osobe ucitane iz txt datoteke su:\n";
            for (Osoba osoba : osobe)
            {
                poruka += osoba.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e)
        {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    public void dajOsobeIzXmlDatoteke(String filePath)
    {
        try
        {
            List<Osoba> osobe = Osoba.ucitajOsobeIzXmlDatoteke(filePath);
            String poruka = "Osobe ucitane iz XML datoteke su:\n";
            for (Osoba osoba : osobe)
            {
                poruka += osoba.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e)
        {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }



}
