package Base;

import java.io.IOException;

public abstract class Game extends GUI{

    private GameLogic logic;
    private State currentState;
    private State previousState;

    public Game(int gridSizeX, int gridSizeY) throws IOException {
        super(gridSizeX,gridSizeY);
    }

    public void setLogic(GameLogic lgc){
        logic = lgc;
    }
}

