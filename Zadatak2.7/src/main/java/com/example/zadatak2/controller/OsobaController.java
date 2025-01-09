package com.example.zadatak2.controller;

import com.example.zadatak2.model.Osoba;
import com.example.zadatak2.model.OsobaModel;
import com.example.zadatak2.view.OsobaView;

import java.util.List;

public class OsobaController {

    private OsobaModel model;
    private OsobaView view;

    public OsobaController(OsobaModel model, OsobaView view){
        this.model = model;
        this.view = view;
    }

    public Osoba dajOsobuPoId(Integer id){
        Osoba osoba = model.dajOsobuPoId(id);
        if(osoba == null){
            view.setPoruka("Osoba nije pronađena!");
        }else{
            view.setPoruka = ("Pronađena osoba: " + osoba.toString());
        }
        return osoba;
    }


    public void azurirajIme(Integer id){
        try{
            model.azurirajOsobu(id, view.getUlazniTekst(), null, null, null, null, null);
            view.setPoruka("Ime je uspješno ažurirano!");
        }catch(Exception e){
            view.setPoruka("Greška: " +e.getMessage());
        }
    }


    public void dajOsobeIzTxtDatoteke(String filePath) {
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

