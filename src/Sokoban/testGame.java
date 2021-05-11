package Sokoban;

import Base.Game;
import Base.GameLogic;

import java.io.IOException;

public class testGame extends Game {

    private SokobanLogic gLogic;

    public testGame() throws IOException {
        super(7,7);
        Levels levels = new Levels();


        gLogic = new SokobanLogic(levels.getLevel_1());
        setLogic(gLogic);


    }


        @Override
        public void upButtonPressed() {
        gLogic.moveTo(0);
    }

        @Override
        public void downButtonPressed() {
            gLogic.moveTo(2);
    }

        @Override
        public void leftButtonPressed() {
            gLogic.moveTo(3);
    }

        @Override
        public void rightButtonPressed() {
            gLogic.moveTo(1);
    }

        @Override
        public void useButtonPressed() {

    }
}
