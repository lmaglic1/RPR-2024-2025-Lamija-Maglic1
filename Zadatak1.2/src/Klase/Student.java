package Klase;

import Izuzeci.DijeljenjeSNulomException;
import Izuzeci.PremladStudentException;
import Izuzeci.StudentBuducnostException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    String ime, prezime, brojIndeksa, odsjek;
    Date datumRodjenja;
    Integer godinaStudija;
    List<Integer> ocjene;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) throws StudentBuducnostException, PremladStudentException {
        Date today = new Date();
        if (datumRodjenja.compareTo(today) >= 0)
            throw new StudentBuducnostException("Datum rođenja ne može biti u budućnosti!");
        else if (today.getYear() - datumRodjenja.getYear() < 16) {
            throw new PremladStudentException("Student ne može biti mlađi od 16 godina!");
        }
        this.datumRodjenja = datumRodjenja;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getOdsjek() {
        return odsjek;
    }

    public void setOdsjek(String odsjek) {
        this.odsjek = odsjek;
    }

    public Integer getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(Integer godinaStudija) {
        if (godinaStudija > 0 && godinaStudija < 6)
            this.godinaStudija = godinaStudija;
    }

    public List<Integer> getOcjene() {
        return ocjene;
    }

    public void setOcjene(List<Integer> ocjene) {
        this.ocjene = ocjene;
    }
    public Student(String ime, String prezime, Date datumRodjenja, String brojIndeksa, Odsjek odsjek, Integer godinaStudija) throws StudentBuducnostException, PremladStudentException {
        setIme(ime);
        setPrezime(prezime);
        setDatumRodjenja(datumRodjenja);
        setBrojIndeksa(brojIndeksa);
        setOdsjek(String.valueOf(odsjek));
        setGodinaStudija(godinaStudija);
        setOcjene(new ArrayList<Integer>());
    }
    public Double Prosjek() throws DijeljenjeSNulomException {
        if (ocjene.size() == 0) {
            throw new DijeljenjeSNulomException("Student nema nijednu ocjenu. Nije moguće ispisati podatke.");
        }
        Double prosjek = 0.0;
        for (Integer ocjena : ocjene) {
            prosjek += ocjena;
        }
        return prosjek / ocjene.size();
    }
    public String toString() {
        try {
            return "Student: " + ime + " " + prezime + ", broj indeksa: " + brojIndeksa + ", prosjek: " + Prosjek();
        } catch (DijeljenjeSNulomException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
    public void dodajOcjenu(int ocjena) {
        ocjene.add(ocjena);
    }
}