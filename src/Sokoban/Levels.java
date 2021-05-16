package Sokoban;

import Base.ImageIconMaker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Levels {

    private final static int[][] level_1 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 4, 0, 0, 1},
            {1, 0, 0, 2, 0, 0, 1},
            {1, 0, 0, 3, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
    };
    private final static int[][] level_2 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
    };

    public static JLabel[][] levelCreator(int[][] level){
        JLabel [][] testArray = new JLabel[level.length][level[0].length];

        int width = 100;
        int height = 100;

        for (int i = 0; i < testArray.length; i++){
            for(int j = 0; j < testArray[0].length; j++){
                switch (level[i][j]){
                    case 0:
                            testArray[i][j] = new JLabel(ImageIconMaker.makeImageIcon(new File("sokoban_icons/blank.png"),100,100));
                    break;
                    case 1:
                            testArray[i][j] = new JLabel(ImageIconMaker.makeImageIcon(new File("sokoban_icons/wall.png"),100,100));
                    break;
                    case 2:
                            testArray[i][j] = new JLabel(ImageIconMaker.makeImageIcon(new File("sokoban_icons/crate.png"),100,100));
                    break;
                    case 3:
                            testArray[i][j] = new JLabel(ImageIconMaker.makeImageIcon(new File("sokoban_icons/blankmarked.png"),100,100));
                    break;
                    case 4:
                            testArray[i][j] = new JLabel(ImageIconMaker.makeImageIcon(new File("sokoban_icons/player.png"),100,100));
                    break;
                    case 5:
                        testArray[i][j] = new JLabel(ImageIconMaker.makeImageIcon(new File("sokoban_icons/cratemarked.png"),100,100));
                    break;
                    case 6:
                        testArray[i][j] = new JLabel(ImageIconMaker.makeImageIcon(new File("sokoban_icons/playermarked.png"),100,100));
                    break;
                }
            }
        }

        return testArray;
    }

    public int[][] getLevel_1(){
        int[][] temp = new int[level_1.length][level_1[0].length];

        for (int i = 0; i < level_1.length; i++){
            for(int j = 0; j < level_1[0].length; j++){
                temp[i][j] = level_1[i][j];
            }
        }
        return temp;
    }

    public int[][] levelGetter(int level){
        int[][] ret;
        int[][] selLevel;
        switch (level){
            case 1:
                selLevel = level_1;
                break;
            case 2:
                selLevel = level_2;
                break;
            default:
                selLevel = new int[0][0];
        }
        ret = new int[selLevel.length][selLevel.length];

        for (int i = 0; i < selLevel.length; i++){
            for(int j = 0; j < selLevel[0].length; j++){
                ret[i][j] = selLevel[i][j];
            }
        }
        return ret;
    }

    public static JLabel[][] levelSelector(int level) {
        JLabel [][] bananaLevel;
        switch (level) {
            case 1 -> bananaLevel = levelCreator(level_1);
            case 2 -> bananaLevel = levelCreator(level_2);
            default -> {
                bananaLevel = new JLabel[1][0];
                bananaLevel[0][0] = new JLabel("You won");
            }
        }

        return bananaLevel;
    }
}
