package model;

import com.example.zadatak2.model.Osoba;
import com.example.zadatak2.model.OsobaModel;
import com.example.zadatak2.model.Uloga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OsobaModelTest {

    private OsobaModel osobaModel;

    @BeforeEach
    void setUp(){
        osobaModel = new OsobaModel();
    }


    @Test
    void testNapuni(){
        osobaModel.napuni();
        assertEquals(2, osobaModel.dajSveOsobe().size(), "Lista osoba treba imati dva elementa nakon poziva metode napuni!");

        Osoba prvaOsoba = osobaModel.dajSveOsobe().get(0);
        assertEquals("Neko", prvaOsoba.getIme(), "Ime prve osobe nije ispravno postavljeno!");
        assertEquals("Nekić", prvaOsoba.getPrezime(), "Prezime prve osobe nije ispravno postavljeno!");


    }



    @Test
    void testAzurirajOsobuPostojeciId() {
        osobaModel.napuni();
        String rezultat = osobaModel.azurirajOsobu(1,"NovoIme", null, null,
                null, null, null );
        assertEquals("Osoba je uspješno žurirana!", rezultat,"Poruka o ispravnom ažuriranju nije ispravna");
        Osoba azuriranaOsoba = osobaModel.dajOsobuPoId(1);
        assertNotNull(azuriranaOsoba, "Osoba s ID-jem 1 treba postojati.");
        assertEquals("NovoIme", azuriranaOsoba.getIme(), "Ime nije ispravno ažurirano.");
        assertEquals("Nekic", azuriranaOsoba.getPrezime(), "Prezime ne bi trebalo biti promijenjeno.");
    }

    @Test
    void testAzurirajOsobuNePostojeciId() {
        osobaModel.napuni();
        String rezultat = osobaModel.azurirajOsobu(99, "NovoIme", null, null, null, null, null);

        assertEquals("Osoba nije pronađena!", rezultat, "Poruka za nepostojeći ID nije ispravna.");
    }

    @Test
    void testAzurirajOsobuDjelimicnaPolja() {
        osobaModel.napuni();
        String rezultat = osobaModel.azurirajOsobu(2, null, "NovoPrezime", null, null, null, Uloga.STUDENT);

        assertEquals("Osoba je uspješno ažurirana!", rezultat, "Poruka o uspješnom ažuriranju nije ispravna.");
        Osoba azuriranaOsoba = osobaModel.dajOsobuPoId(2);
        assertNotNull(azuriranaOsoba, "Osoba s ID-jem 2 treba postojati.");
        assertEquals("Neko 2", azuriranaOsoba.getIme(), "Ime ne bi trebalo biti promijenjeno.");
        assertEquals("NovoPrezime", azuriranaOsoba.getPrezime(), "Prezime nije ispravno ažurirano.");
        assertEquals(Uloga.STUDENT, azuriranaOsoba.getUloga(), "Uloga nije ispravno ažurirana.");
    }
}