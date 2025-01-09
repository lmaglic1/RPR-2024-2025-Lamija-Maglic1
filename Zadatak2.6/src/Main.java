import controller.PredmetController;
import model.Predmet;
import view.PredmetView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Predmet predmet = new Predmet("Matematika", 7.0);

        PredmetController.dajPredmeteIzTxtDatoteke("src/data/predmet.txt");
        System.out.println("1) View ispisuje: " + PredmetView.getPoruka());
    }
}