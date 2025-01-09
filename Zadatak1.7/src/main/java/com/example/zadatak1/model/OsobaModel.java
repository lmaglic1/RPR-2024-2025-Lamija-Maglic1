package com.example.zadatak1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import java.text.SimpleDateFormat;


public class OsobaModel {
    private ObservableList<Osoba> osobe;

    public OsobaModel(){
        osobe = FXCollections.observableArrayList();
    }

    public String dodajOsobu(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga){
        try{
            Osoba newOsoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
            osobe.add(newOsoba);
            return "Osoba je uspješno dodana!";
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    public ObservableList<Osoba> dajSveOsobe(){
        return osobe;
    }

    public Osoba dajOsobuPoId(Integer id){
        for(Osoba osoba : osobe){
            if(osoba.getId().equals(id)){
                return osoba;
            }
        }
        return null;
    }

    public String azurirajOsobu(Integer id, String novoIme, String novoPrezime, String novaAdresa, Date noviDatumRodjenja, String noviMaticniBroj, Uloga novaUloga){

        Osoba trazenaOsoba = dajOsobuPoId(id);
        if(trazenaOsoba != null){
            try{
                if(novoIme!=null) {
                    trazenaOsoba.setIme(novoIme);
                }
                if(novoPrezime!=null){
                    trazenaOsoba.setPrezime(novoPrezime);
                }
                if(novaAdresa!=null){
                    trazenaOsoba.setAdresa(novaAdresa);
                }
                if(noviDatumRodjenja!=null){
                    trazenaOsoba.setDatumRodjenja(noviDatumRodjenja);
                }
                if(noviMaticniBroj!=null){
                    trazenaOsoba.setMaticniBroj(noviMaticniBroj);
                }
                if(novaUloga!=null){
                    trazenaOsoba.setUloga(novaUloga);
                }
                    return "Osoba je uspješno ažurirana!";
            }catch(IllegalArgumentException e){
                return e.getMessage();
            }
        }
        return "Osoba nije pronađena!";
    }

    public String obrisiOsobu(Integer id){
        boolean osobaPronadjena = osobe.removeIf(osoba -> osoba.getId().equals(id));
        if(osobaPronadjena){
            return "Osoba je uspješno obrisana!";
        }else{
            return  "Osoba nije pronađena!";
        }

    }

    public void napuni(){
        osobe.add(new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25), "2509997123456", Uloga.STUDENT));
        osobe.add(new Osoba(2,"Neko 2","Nekic 2","Neka adresa 2",new Date(97,8,25), "2509997123456", Uloga.NASTAVNO_OSOBLJE));
    }

    public void napuniPodatkeIzTxtDatoteke(String putanjaDoDatoteke) throws IOException, ParseException {
        osobe = FXCollections.observableArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String linija;
        while ((linija = reader.readLine()) != null) {
            String[] polja = linija.split(",");
            if (polja.length == 7) {
                Integer id = Integer.parseInt(polja[0]);
                String ime = polja[1];
                String prezime = polja[2];
                String adresa = polja[3];
                Date datumRodjenja = dateFormat.parse(polja[4]);
                String maticniBroj = polja[5];
                Uloga uloga = Uloga.valueOf(polja[6].toUpperCase());


                Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj,uloga);
                osobe.add(osoba);
            }
        }
        reader.close();
    }

    public void napuniPodatkeIzXmlDatoteke(String putanjaDoDatoteke) throws Exception
    {
        osobe = FXCollections.observableArrayList();
        File xmlFile = new File(putanjaDoDatoteke);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlFile);


        doc.getDocumentElement().normalize();


        NodeList listaCvorova = doc.getElementsByTagName("osoba");


        for (int i = 0; i < listaCvorova.getLength(); i++)
        {
            Node cvor = listaCvorova.item(i);


            if (cvor.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) cvor;


                Integer id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                String ime = element.getElementsByTagName("ime").item(0).getTextContent();
                String prezime = element.getElementsByTagName("prezime").item(0).getTextContent();
                String adresa = element.getElementsByTagName("adresa").item(0).getTextContent();
                Date datumRodjenja = dateFormat.parse(element.getElementsByTagName("datumRodjenja").item(0).getTextContent());
                String maticniBroj = element.getElementsByTagName("maticniBroj").item(0).getTextContent();
                Uloga uloga = Uloga.valueOf(element.getElementsByTagName("uloga").item(0).getTextContent().toUpperCase());


                Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
                osobe.add(osoba);
            }
        }
    }




}
