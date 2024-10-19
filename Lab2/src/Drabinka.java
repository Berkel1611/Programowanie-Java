import java.util.Random;
import java.util.Scanner;

// Bartłomiej Koźluk

public class Drabinka {
    public static void main(String[] args) {
        System.out.print("Podaj liczbę zawodników: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int[] ladder = prepareLadder(num);
        int size = ladder.length;

        for(int j = 1; size != 1; j++) {
            System.out.println("RUNDA " + j + ".");
            for(int i = 0; i < size-1; i+=2)
                System.out.print(ladder[i] + "-" + ladder[i+1] + " ");
            System.out.println("\n");

            for(int k = 0, l = 0; k < size-1; k+=2, l++)
                ladder[l] = whoWon(ladder[k], ladder[k+1]);

            size /= 2;
        }
        System.out.println("Zwyciężył gracz z pozycją: " + ladder[0]);
    }
    static int[] prepareLadder(int num) {
        if(num == 2) return new int[]{1, 2};
        // Ustala rozmiar tablicy
        int size = num%2 == 0 ? num : num+1;
        while((Math.log(size)/Math.log(2))%1 != 0)
            size += 2;
        // Inicjuje kolejkę
        int[] ladder = new int[size];
        int i;
        for(i = 0; i < num; i++)
            ladder[i] = i+1;
        for(; i < size; i++)
            ladder[i] = 0;
        // Ustawia pary
        for(int j = 1; j < size/2; j+=2) {
            i = ladder[j];
            ladder[j] = ladder[size-j];
            ladder[size-j] = i;
        }
        // Układa pary
        int flag = ladder[size/2];
        for(int j = 4; ladder[2] != flag; j+=2) {
            for(int k = (j)%4 + 2; k < size-4; k+=4) {
                i = ladder[k];
                ladder[k] = ladder[k+2];
                ladder[k+2] = i;

                i = ladder[k+1];
                ladder[k+1] = ladder[k+3];
                ladder[k+3] = i;
            }
        }
        return ladder;
    }
    static int whoWon(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        Random rnd = new Random();
        return rnd.nextBoolean() ? a : b;
    }
}
