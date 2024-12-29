import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static boolean DaLiJeProst(int broj) {
        if (broj <= 1) {
            return false;
        } else {
            for(int i = 2; (double)i <= Math.sqrt((double)broj); ++i) {
                if (broj % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("Unesite broj n: ");
            int n = in.nextInt();
            if (n < 2) {
                System.out.println("Nije moguce izvrsiti izracunavanje prostih brojeva.");
                break;
            }

            if (n <= 500) {
                System.out.print("Prosti brojevi: ");

                for(int i = 2; i <= 2 * n; ++i) {
                    if (DaLiJeProst(i)) {
                        System.out.print("" + i + " ");
                    }
                }

                System.out.println();
                break;
            }

            System.out.println("Uneseni broj je prevelik!");
        }

        in.close();
    }
}

