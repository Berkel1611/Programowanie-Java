import java.util.Scanner;

// Bartłomiej Koźluk

public class Palindrom {
    public static void main(String[] args) {
        System.out.print("Podaj liczbę: ");

        // Wczytanie liczby
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();

        if(Integer.toString(num).equals(
                FunPom.reverseString(Integer.toString(num))))
            System.out.println("Liczba jest palindromem.");
        else System.out.println("Liczba nie jest palindromem.");
    }
}
