import java.util.Arrays;
import java.util.Scanner;
// Bartłomiej Koźluk
/*
Funkcje intToArray, reverseArray,
arrayToInt umieściłem w oddzielnej klasie
 */
public class MinMax4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num, num2;

        do {
            System.out.print("Podaj 4-cyfrową liczbę: ");
            num = scan.nextInt();
        } while(num < 1000 || num > 9999);
        scan.close();

        int[] tab1, tab2;
        do {
            num2 = num;
            tab1 = FunPom.intToArray(num);
            Arrays.sort(tab1);
            tab2 = FunPom.reverseArray(tab1);
            num = FunPom.arrayToInt(tab2) - FunPom.arrayToInt(tab1);
            if(num != 0) System.out.println(num);
        } while(num > 0 && num != num2);
    }
}
