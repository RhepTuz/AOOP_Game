package Sokoban;

import Base.WindowObserver;

public class WinObserver implements WindowObserver {
   private int[][] currentLevel;
   private SokobanLogic logic;

   public WinObserver(SokobanLogic lgc){
       logic = lgc;
   }

    @Override
    public void update() {
        int[][] map = logic.getCurrLevel();

        for (int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                if(map[i][j] == Assets.crate.getObjectID()){

                }
            }
        }

    }
}
