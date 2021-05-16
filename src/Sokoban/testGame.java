package Sokoban;

import Base.GUI;
import Base.Game;
import Base.GameLogic;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;


public class testGame extends Game {

    private SokobanLogic gLogic;
    private Levels levels;
    private int currLevel = 1;
    public testGame() throws IOException {
        super(7,7);
        levels = new Levels();

        gLogic = new SokobanLogic(levels.getLevel_1());
        setLogic(gLogic);

        JLabel[][] ljlk = Levels.levelSelector(currLevel);

        changeScreen(ljlk);


    }


    @Override
    public void upButtonPressed() {
        gLogic.move(0);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
        update();
    }

    @Override
    public void downButtonPressed() {
            gLogic.move(2);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
        update();
    }

    @Override
    public void leftButtonPressed() {
            gLogic.move(3);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
        update();
    }

    @Override
    public void rightButtonPressed() {
        gLogic.move(1);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
        update();
    }

    @Override
    public void useButtonPressed() {
        gLogic.setCurrLevel(levels.levelGetter(currLevel));
        gLogic.resetPlayerPos();
        changeScreen(Levels.levelCreator(levels.levelGetter(currLevel)));
        gLogic.setWon(true);
        update();
    }
    private void update(){
        if(gLogic.getWon()){
            System.out.println(currLevel);
            currLevel++;
            changeScreen(Levels.levelSelector(currLevel));
            gLogic.setWon(false);
        }
    }
}
