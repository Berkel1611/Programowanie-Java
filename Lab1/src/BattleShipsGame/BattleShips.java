package BattleShipsGame;
// Bartłomiej Koźluk
import java.util.Scanner;

public class BattleShips {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.prepare();
        board.spawnShips();

        Scanner scan = new Scanner(System.in);
        String shot;
        while(true){
            System.out.println("\n");
            board.print();
            do {
                System.out.print("Oddaj strzał: ");
                shot = scan.next();
            } while(isShotInvalid(shot));

            board.shot(shot.toCharArray());
            if(board.endgame == 0) {
                System.out.println("Wygrałeś :D Gratulacje");
                break;
            }
        }
        scan.close();
    }
    static boolean isShotInvalid(String shot){
        return shot.charAt(1) < 48 || shot.charAt(1) > 57 ||
                shot.charAt(0) < 65 || shot.charAt(0) > 74;
    }
}
