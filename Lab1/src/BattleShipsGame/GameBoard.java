package BattleShipsGame;
// Bartłomiej Koźluk
import java.util.Arrays;
import java.util.TreeSet;

public class GameBoard {
    char[][] board = new char[11][11];
    int endgame = 20;
    TreeSet<String> unavailableFields = new TreeSet<>(), shootedFields = new TreeSet<>();
    Ship[] ships = {new Ship(4), new Ship(3), new Ship(3),
            new Ship(2), new Ship(2), new Ship(2),
            new Ship(1), new Ship(1), new Ship(1), new Ship(1)};

    void prepare() {
        for (char[] e : board)
            Arrays.fill(e, ' ');

        board[0][0] = ' ';
        for (int i = 1; i < board[0].length; i++) {
            board[0][i] = (char) (64 + i);
            board[i][0] = (char) (47 + i);
        }
    }
    void print(){
        for(char[] e : board) {
            for (char f : e)
                System.out.print(f + "  ");
            System.out.println();
        }
    }
    void shot(char[] coord){
        int a = coord[1]-47, b = coord[0]-64;
        if(shootedFields.contains(coordsToString(a, b)))
            return;
        shootedFields.add(coordsToString(a, b));

        for(Ship e : ships) {
            for (int[] p : e.location) {
                if (p[0] == a && p[1] == b) {
                    board[a][b] = 'X';
                    System.out.println("Trafiłeś!");
                    e.life--;
                    endgame--;
                    if(e.life == 0) System.out.println("Zniszczyłeś statek !!!");
                    return;
                }
            }
        }
        board[a][b] = 'O';
        System.out.println("Pudło :/");
    }
    void spawnShips(){
        for(Ship e : ships){
            do{
                if(e.size == 1) e.generateOneMastedShipLocation();
                else e.generateShipLocation();
            } while(isLocationInvalid(e));
            lockFields(e);
        }
    }
    void lockFields(Ship ship){
        for(int i = ship.location[0][1]-1;
            i <= ship.location[ship.rotation ? 0 : ship.size-1][1]+1; i++)
        {
            for(int j = ship.location[0][0]-1;
                j <= ship.location[ship.rotation ? ship.size-1 : 0][0]+1; j++)
            {
                if(i >= 0 && i < 10 && j >= 0 && j < 10)
                    unavailableFields.add(coordsToString(j, i));
            }
        }
    }
    boolean isLocationInvalid(Ship ship){
        for(int[] e : ship.location){
            if(!unavailableFields.contains(coordsToString(e[0], e[1])))
                return false;
        }
        return true;
    }
    static String coordsToString(int a, int b){
        return (char)(a+48)+Character.toString((char)(b+48));
    }
}
