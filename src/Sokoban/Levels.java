package Sokoban;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Levels {

    private static int[][] level_1 = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 4, 0, 0, 1},
            {1, 0, 0, 2, 0, 0, 1},
            {1, 0, 0, 3, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
    };
    private static int[][] level_1_layer_1 = {
            {0, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
    };

    private static JLabel[][] levelCreator(int[][] level){
        JLabel [][] testArray = new JLabel[level.length][level[0].length];

        int width = 100;
        int height = 100;

        for (int i = 0; i < testArray.length; i++){
            for(int j = 0; j < testArray[0].length; j++){
                switch (level[j][i]){
                    case 0:
                        try{
                            BufferedImage img = ImageIO.read(new File("sokoban_icons/blank.png"));
                            BufferedImage reScaled = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
                            ImageIcon texture = new ImageIcon();
                            Graphics2D g2 = reScaled.createGraphics();

                            g2.drawImage(img,0,0,width,height,null);
                            g2.dispose();

                            texture.setImage(reScaled);
                            testArray[i][j] = new JLabel(texture);
                        }
                        catch (IOException e){
                            System.out.println("file not found");
                        }
                    break;
                    case 1:
                        try{
                            BufferedImage img = ImageIO.read(new File("sokoban_icons/wall.png"));
                            BufferedImage reScaled = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
                            ImageIcon texture = new ImageIcon();
                            Graphics2D g2 = reScaled.createGraphics();

                            g2.drawImage(img,0,0,width,height,null);
                            g2.dispose();

                            texture.setImage(reScaled);
                            testArray[i][j] = new JLabel(texture);
                        }
                        catch (IOException e){
                            System.out.println("file not found");
                        }
                }
            }
        }

        return testArray;
    }

    public int[][] getLevel_1(){
        return level_1.clone();
    }

    public static JLabel[][] levelSelector(int level) {
        JLabel [][] bananaLevel;
        switch (level) {
            case 1:
                bananaLevel =  levelCreator(level_1);
            break;
            default:
                bananaLevel = new JLabel[0][0];

        }

        return bananaLevel;
    }
}
