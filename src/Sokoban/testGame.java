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
    public testGame() throws IOException {
        super(7,7);
        levels = new Levels();

        gLogic = new SokobanLogic(levels.getLevel_1());
        setLogic(gLogic);

        JLabel[][] ljlk = Levels.levelCreator(levels.getLevel_1());

        changeScreen(ljlk);


    }


    @Override
    public void upButtonPressed() {
        gLogic.move(0);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));

    }

    @Override
    public void downButtonPressed() {
            gLogic.move(2);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
    }

    @Override
    public void leftButtonPressed() {
            gLogic.move(3);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
    }

    @Override
    public void rightButtonPressed() {
        gLogic.move(1);

        changeScreen(Levels.levelCreator(gLogic.getCurrLevel()));
    }

    @Override
    public void useButtonPressed() {
        System.out.println(Arrays.deepToString(levels.getLevel_1()));
        gLogic.setCurrLevel(levels.getLevel_1());
        gLogic.resetPlayerPos();
        changeScreen(Levels.levelCreator(levels.getLevel_1()));

    }
}
