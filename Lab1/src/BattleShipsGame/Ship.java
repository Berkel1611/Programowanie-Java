package BattleShipsGame;
// Bartłomiej Koźluk
import java.util.Random;

public class Ship {
    public Ship(int size){
        this.size = size;
        this.life = size;
        location = new int[size][2];
    }

    int size, life;
    int[][] location;
    boolean rotation;

    void generateOneMastedShipLocation(){
        Random rnd = new Random();
        location[0][0] = rnd.nextInt(10)+1;
        location[0][1] = rnd.nextInt(10)+1;
    }

    void generateShipLocation(){
        Random rnd = new Random();
        this.rotation = rnd.nextBoolean(); //true - horizontal, false - vertical
        boolean side;
        int row = rnd.nextInt(10)+1, a, b;
        a = b = rnd.nextInt(10)+1;

        for(int i = 0; i < this.size; i++){
            side = rnd.nextBoolean(); //true - decrease a, false - increase b
            if(side) {
                if (a - 1 >= 1) a--;
                else b++;
            }
            else {
                if (b + 1 < 11) b++;
                else a--;
            }
        }
        for(int i = 0; i < this.size; i++){
            location[i][0] = rotation ? a+i : row;
            location[i][1] = rotation ? row : a+i;
        }
    }
}
