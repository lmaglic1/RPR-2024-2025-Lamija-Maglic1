package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OsobaTest {

    private Osoba osoba;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        osoba = new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25),"2509997123456", Uloga.STUDENT);
    }

    @Test
    void testOsobaIspravnoKreirana(){
        assertNotNull(osoba);
        assertEquals("Neko", osoba.getIme());
        assertEquals("Nekic", osoba.getPrezime());
        assertEquals("2509997123456", osoba.getMaticniBroj());
        assertEquals("new Date(97,8,25)", osoba.getDatumRodjenja());
        assertEquals("Neka adresa", osoba.getAdresa());
    }
    @Test
    void testImeNeispravno(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            new Osoba(1, "", "Nekic","Neka adresa", new Date(97,8,25),"2509997123456", Uloga.STUDENT);
        });
        assertEquals("Ime ne može biti prazno!", exception.getMessage());

    }

    @Test
    void testMaticniBrojDuzina(){
        Exception exception = assertThrows(IllegalAccessException.class, () ->{
            new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25),"250999", Uloga.STUDENT);
        });
        assertEquals("Maticni broj mora imati tacno 13 znakova", exception.getMessage());

    }

    @Test
    void testMaticniBrojPodudaranje(){
        Exception exception = assertThrows(IllegalAccessException.class, () -> {
            new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25),"1234567891234", Uloga.STUDENT);
        });
        assertEquals("Maticni broj nije u skladu sa datumom rodjenja!", exception.getMessage());
    }

    @Test
    void testNeispravnaPutanjaTxt(){
        Exception exception = assertThrows(RuntimeException.class, () ->{
            Osoba.ucitajOsobeIzTxtDatoteke("nepostojeca_datoteka.txt");
        });
        assertEquals("Datoteka nije pronadjena", exception.getMessage());
    }

    @Test
    void testNeispravnaPutanjaXml(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Osoba.ucitajOsobeIzXmlDatoteke("nepostojeca_datoteka.xml");
        });
        assertEquals("Datoteka nije pronadjena!", exception.getMessage());
    }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getPrezime() {
    }

    @org.junit.jupiter.api.Test
    void setPrezime() {
    }

    @org.junit.jupiter.api.Test
    void getId() {
    }

    @org.junit.jupiter.api.Test
    void setId() {
    }

    @org.junit.jupiter.api.Test
    void getIme() {
    }

    @org.junit.jupiter.api.Test
    void setIme() {
    }

    @org.junit.jupiter.api.Test
    void getAdresa() {
    }

    @org.junit.jupiter.api.Test
    void setAdresa() {
    }

    @org.junit.jupiter.api.Test
    void getDatumRodjenja() {
    }

    @org.junit.jupiter.api.Test
    void setDatumRodjenja() {
    }

    @org.junit.jupiter.api.Test
    void getMaticniBroj() {
    }

    @org.junit.jupiter.api.Test
    void setMaticniBroj() {
    }

    @org.junit.jupiter.api.Test
    void getUloga() {
    }

    @org.junit.jupiter.api.Test
    void setUloga() {
    }

    @org.junit.jupiter.api.Test
    void mozeUcestvovatiUProjektu() {
    }

    @org.junit.jupiter.api.Test
    void imaPravoNaStipendiju() {
    }

    @org.junit.jupiter.api.Test
    void ucitajOsobeIzTxtDatoteke() {
    }

    @org.junit.jupiter.api.Test
    void ucitajOsobeIzXmlDatoteke() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}