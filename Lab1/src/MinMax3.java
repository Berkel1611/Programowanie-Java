import java.util.Arrays;
import java.util.Scanner;
// Bartłomiej Koźluk
/*
Funkcje intToArray, reverseArray,
arrayToInt umieściłem w oddzielnej klasie
 */
public class MinMax3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num, num2;

        // Wczytanie liczby
        do {
            System.out.print("Podaj 3-cyfrową liczbę: ");
            num = scan.nextInt();
        } while(num < 100 || num > 999);
        scan.close();

        int[] tab1, tab2;
        do {
            num2 = num;
            tab1 = FunPom.intToArray(num); // Wyłuskuje pojedyncze cyfry
            Arrays.sort(tab1); // Sortuje tablicę (najmniejsza liczba)
            tab2 = FunPom.reverseArray(tab1); // Odwraca tablicę (największa liczba)
            num = FunPom.arrayToInt(tab2) - FunPom.arrayToInt(tab1); // Różnica liczb
            if(num != 0) System.out.println(num);
        } while(num > 0 && num != num2);
    }
}
