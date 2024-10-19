import java.util.Scanner;

// Bartłomiej Koźluk

public class CzteryKwadraty {
    public static void main(String[] args) {
        // Pobieranie przedziału
        System.out.print("Podaj przedział: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = 1;
        double tab3;
        sc.close();

        int[] tab = new int[4];

        for(int l = a; l <= b; l++) { // Pętla przechodząca przez podany przedział
            brk:
            // Algorytm szukający kwadratów
            for (int i = (int) Math.sqrt(l); i > 0; i--) {
                for (int j = (int) Math.sqrt(l - i * i); j >= 0; j--) {
                    for (int k = (int) Math.sqrt(l - i * i - j * j); k >= 0 && k <= j; k--) {
                        tab3 = Math.sqrt(l - i * i - j * j - k * k);

                        if (tab3 % 1 == 0) {
                            tab[0] = i; tab[1] = j; tab[2] = k; tab[3] = (int) tab3;
                            break brk;
                        }
                        c++;
                    }
                }
            }
            // Wypisanie wyniku
            System.out.printf("%d = %d^2 + %d^2 + %d^2 + %d^2\n",
                    l, tab[0], tab[1], tab[2], tab[3]);
        }
        System.out.println("Licznik: " + c); // Licznik dla [0;1000]: 2965

        StringBuilder sb = new StringBuilder();
        boolean if0;
        // Szuka liczb, dla których nie istnieje rozkład bez 0
        for(int l = 0; l <= 1000; l++) {
            if0 = true;
            // Algorytm szukający kwadratów
            brk1:
            for (int i = (int) Math.sqrt(l); i > 0; i--) {
                for (int j = (int) Math.sqrt(l - i * i); j > 0; j--) {
                    for (int k = (int) Math.sqrt(l - i * i - j * j); k > 0; k--) {
                        tab3 = Math.sqrt(l - i * i - j * j - k * k);
                        if (tab3 % 1 == 0 && tab3 != 0) {
                            if0 = false;
                            break brk1;
                        }
                    }
                }
            }
            if(if0) sb.append(l).append(" ");
        }
        System.out.println("Liczby [0; 1000], dla których nie istnieją rozkłady bez 0: " +
                sb);
    }
}
