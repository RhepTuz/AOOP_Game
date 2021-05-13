package Sokoban;

import Base.GUI;
import Base.Game;
import Base.GameLogic;

import javax.swing.*;
import java.io.IOException;

public class testGame extends Game {

    private SokobanLogic gLogic;

    public testGame() throws IOException {
        super(7,7);
        Levels levels = new Levels();

        gLogic = new SokobanLogic(levels.getLevel_1());
        setLogic(gLogic);

        JLabel[][] ljlk = Levels.levelCreator(levels.getLevel_1());

        changeScreen(ljlk);


    }


    @Override
    public void upButtonPressed() {
        gLogic.moveTo(0);
        for(int i = 0; i < gLogic.getCurrLevel().length; i++){
            for(int j = 0; j < gLogic.getCurrLevel()[i].length; j++){
                System.out.print(gLogic.getCurrLevel()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
    }

    @Override
    public void downButtonPressed() {
            gLogic.moveTo(2);
        for(int i = 0; i < gLogic.getCurrLevel().length; i++){
            for(int j = 0; j < gLogic.getCurrLevel()[i].length; j++){
                System.out.print(gLogic.getCurrLevel()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
    }

    @Override
    public void leftButtonPressed() {
            gLogic.moveTo(3);
        for(int i = 0; i < gLogic.getCurrLevel().length; i++){
            for(int j = 0; j < gLogic.getCurrLevel()[i].length; j++){
                System.out.print(gLogic.getCurrLevel()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
    }

    @Override
    public void rightButtonPressed() {
            gLogic.moveTo(1);
        for(int i = 0; i < gLogic.getCurrLevel().length; i++){
            for(int j = 0; j < gLogic.getCurrLevel()[i].length; j++){
                System.out.print(gLogic.getCurrLevel()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
    }

    @Override
    public void useButtonPressed() {

    }
}
