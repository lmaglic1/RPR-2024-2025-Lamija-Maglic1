import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;

public class ProfesorTest {
    @Test
    void DajInformacijeTest(){

        Profesor p = new Profesor("Profesor", "1", "", new Date(99, 0, 1), 150, 2000, "3-00", "red. prof. dr.", 50);
        String ocekivaniRezultat = "Profesor: red. prof. dr. Profesor 1";
        assertEquals(ocekivaniRezultat, p.DajInformacije());
    }

    @Test
    void  ProvjeriMaticniBrojTest(){
        Profesor p =  new Profesor("Profesor", "1", "", new Date(99, 0, 1), 150, 2000, "3-00", "red. prof. dr.", 50);
        assertTrue(p.ProvjerMaticnogBroja("0101999234567"));
        assertFalse(p.ProvjerMaticnogBroja("3112991234567"));
    }

}