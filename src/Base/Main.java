package Base;

import Sokoban.testGame;

import java.io.IOException;
import java.util.Arrays;

//lmaoKekW
public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        GUI gui = new testGame();

        int[][] jk = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println(Arrays.deepToString(jk));

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(jk[i][j] + " ");
            }
            System.out.println();
        }

    }
}
