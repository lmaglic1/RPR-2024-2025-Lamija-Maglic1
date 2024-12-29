
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kalkulator {
    public Kalkulator() {
    }

    public static Double Plus(Double broj1, Double broj2) {
        return broj1 + broj2;
    }

    public static Double Podijeljeno(Double broj1, Double broj2) throws Exception {
        if (broj2 == 0.0) {
            throw new Exception("Nije dozvoljeno dijeljenje s nulom!");
        } else {
            double rezultat = broj1 / broj2;
            return (double)Math.round(rezultat * 100.0) / 100.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> brojevi = new ArrayList();
        System.out.print("Unesite operaciju ('plus' ili 'podijeljeno'): ");
        String operacija = scanner.nextLine();
        System.out.print("Unesite brojeve: ");

        while(true) {
            Double rezultat = scanner.nextDouble();
            if (rezultat == -400.0) {
                try {
                    rezultat = (Double)brojevi.get(0);

                    for(int i = 1; i < brojevi.size(); ++i) {
                        if (operacija.equals("plus")) {
                            rezultat = Plus(rezultat, (Double)brojevi.get(i));
                        } else if (operacija.equals("podijeljeno")) {
                            rezultat = Podijeljeno(rezultat, (Double)brojevi.get(i));
                        }
                    }

                    System.out.printf("Konacni rezultat je: %.2f\n", rezultat);
                } catch (Exception var6) {
                    System.out.println(var6.getMessage());
                }

                scanner.close();
                return;
            }

            brojevi.add(rezultat);
        }
    }
}

