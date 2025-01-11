package model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class PredmetModel {

    private ObservableList<Predmet> predmeti;

    public PredmetModel(){
        predmeti = FXCollections.observableArrayList();
    }

    public String dodajPredmet(StringProperty naziv, Profesor odgovorniProfesor, List<Asistent> asistenti, DoubleProperty ECTS){
        try{
            Predmet noviPredmet = new Predmet(naziv, odgovorniProfesor, asistenti, ECTS);
            predmeti.add(noviPredmet);
            return "Predmet je uspješno dodan!";
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    public ObservableList<Predmet> dajSvePredmete(){
        return predmeti;
    }

    public Predmet dajPredmetPoImenu(String naziv){
        for(Predmet predmet : predmeti){
            if(predmet.getNaziv().equalsIgnoreCase(naziv)){
                return predmet;
            }
        }
        return null;
    }
    public String azurirajPredmet(String naziv, Profesor noviOdgovorniProfesor, List<Asistent> noviAsistenti, Double noviECTS){
    Predmet trazeniPredmet = dajPredmetPoImenu(String.valueOf(naziv));
    if(trazeniPredmet != null){
        try{
            if(noviOdgovorniProfesor!=null){
                trazeniPredmet.setOdgovorniProfesor(noviOdgovorniProfesor);
            }
            if(noviAsistenti != null){
                trazeniPredmet.setAsistenti(noviAsistenti);
            }

            if(noviECTS != null){
                trazeniPredmet.setECTS(noviECTS);
            }
            return "Predmet je uspješno ažuriran!";
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }
    return "Predmet nije pronađen!";
    }

    public void obrisiPredmet(String naziv){
        predmeti.removeIf(predmet -> predmet.getNaziv()==naziv);
    }

    public void naouni(){
        Profesor profesor = new Profesor(
                new SimpleStringProperty("Docent"),
                new SimpleIntegerProperty(10),
                new SimpleStringProperty("Marko"),
                new SimpleStringProperty("Marković"),
                new SimpleStringProperty("Adresa 123"),
                new SimpleObjectProperty<>(new Date()),
                new SimpleIntegerProperty(40),
                new SimpleIntegerProperty(2015),
                new SimpleStringProperty("Kancelarija 5")
        );


        Asistent asistent = new Asistent(
                new SimpleStringProperty("laboratorija"),
                new SimpleStringProperty("termin"),
                new SimpleStringProperty("ime"),
                new SimpleStringProperty("prezime"),
                new SimpleStringProperty("adresa"),
                new SimpleObjectProperty<>(new Date()),
                new SimpleIntegerProperty(15),
                new SimpleIntegerProperty(2018),
                new SimpleStringProperty("kancelarija")
        );
        predmeti.add(new Predmet(new SimpleStringProperty("Matematika 1"), profesor , FXCollections.observableArrayList(asistent), new SimpleDoubleProperty(7.0)));

    }

    public void napuniPodatkeIzTxtDatoteke(String putanjaDoDatoteke)
        throws IOException, ParseException{
        predmeti = FXCollections.observableArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));

        String linija;
        while((linija = reader.readLine())!=null){
            String[] polja = linija.split(",");
            if(polja.length == 4){
                String naziv = polja[0];
                String profesor = polja[1];
                String asistent = polja[2];
                Double ECTS = Double.valueOf(polja[3]);

                Predmet predmet = new Predmet(naziv, profesor, asistent, ECTS);
                predmeti.add(predmet);


            }
        }
        reader.close();
    }


}
