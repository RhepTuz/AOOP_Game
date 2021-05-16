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
        super(8,8);
        levels = new Levels();

        gLogic = new SokobanLogic(levels.getLevel_1());
        setLogic(gLogic);
        gLogic.addObs(new WinObserver(gLogic));

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
    public void resetButtonPressed() {
        gLogic.setCurrLevel(levels.levelGetter(currLevel));
        gLogic.resetPlayerPos();
        changeScreen(Levels.levelCreator(levels.levelGetter(currLevel)));
        update();
    }

    private void update(){
        if(gLogic.getWon()){
            System.out.println(gLogic.getWon());
            currLevel++;
            gLogic.setCurrLevel(levels.levelGetter(currLevel));
            gLogic.resetPlayerPos();
            changeScreen(Levels.levelSelector(currLevel));
            gLogic.setWon(false);
        }
    }
}
