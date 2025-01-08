import controller.OsobaController;
import model.*;
import view.OsobaView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Profesor p = new Profesor("model.Profesor", "1", "", new Date(99, 0, 1), 150, 2000, "3-00", "red. prof. dr.", 50);
        //Student s = new Student("model.Student", "1", "", new Date(98, 2, 2), "12345", 2, 0.0);
       // Predmet pr = new Predmet("RPR", p, null, 5.0);

        List<IInformacije> objekti = new ArrayList<IInformacije>();
       // objekti.add(p);
        //objekti.add(s);
        //objekti.add(pr);
        //for (IInformacije o : objekti)
            //System.out.println(o.DajInformacije());

        Osoba osoba = new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25),"2509997123456", Uloga.STUDENT);


        System.out.println("Osoba ima pravo na stipendiju: " + osoba.imaPravoNaStipendiju());

        OsobaView osobaView = new OsobaView();

        osobaView.setUlazniTeskt("Novo ime");

        OsobaController osobaController = new OsobaController(osoba, osobaView);
        osobaController.azurirajIme();
        System.out.println("1) View ispisuje: " + osobaView.getPoruka());


        osobaController.dajOsobeIzTxtDatoteke("src/data/osobe.txt");
        System.out.println("2) View ispisuje: " + osobaView.getPoruka());


        osobaController.dajOsobeIzXmlDatoteke("src/data/osobe.xml");
        System.out.println("3) View ispisuje: " + osobaView.getPoruka());
    }


}