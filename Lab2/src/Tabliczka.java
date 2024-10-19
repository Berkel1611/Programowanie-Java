// Bartłomiej Koźluk

public class Tabliczka {
    public static void main(String[] args) {
        int num;
        // Konwersja parametru na int
        try {
            num = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return;
        }

        int[][] tab = new int[num][num];

        // Tworzenie tabliczki mnożenia
        for(int i = 0; i < num; i++)
            for(int j = 0; j < num; j++)
                tab[i][j] = i*j;

        // Wypisanie tabliczki
        for(int[] e : tab){
            for(int f : e)
                System.out.print(f + "\t");
            System.out.println();
        }
    }
}
