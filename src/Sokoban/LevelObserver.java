package Sokoban;

import Base.WindowObserver;

public class LevelObserver implements WindowObserver {
   private int[][] currentLevel;

    @Override
    public void update(Object[][] banana) {

        for(int i = 0; i < banana.length; i++){
            for(int j = 0; j < banana[i].length; j++){
                this.currentLevel[i][j] = (int) banana[i][j];
            }
        }

    }
}
