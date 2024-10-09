import java.util.ArrayList;
import java.util.Scanner;

// Bartłomiej Koźluk

public class Pusty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String sur;

        // Wczytywanie nazwisk
        System.out.println("Podaj nazwiska:");
        do {
            sur = scan.next();
            list.add(sur);
        } while(!sur.equals("Pusty"));

        // Wypisywanie nazwisk od tyłu
        for(int i = list.size()-2; i >= 0; i--)
            System.out.println(list.get(i));
        scan.close();
    }
}
