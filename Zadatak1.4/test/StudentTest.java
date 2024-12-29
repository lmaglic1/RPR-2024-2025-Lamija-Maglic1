import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    void DajInformacije(){
        Student s = new Student("Student", "1", "", new Date(98, 2, 2), "12345", 2, 0.0);
        String ocekivaniRezultat = "Student: Student 1, broj indeksa: 12345";
        assertEquals(ocekivaniRezultat, s.DajInformacije());
    }
}