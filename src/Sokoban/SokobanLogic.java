package Sokoban;

import Base.GameLogic;

import java.util.Arrays;

public class SokobanLogic extends GameLogic {

    private int[][] currLevel;

    public SokobanLogic(int[][] lvl){
        currLevel = lvl;
    }

    public boolean moveTo(int dir){
        return false;
    }

    public void setCurrLevel(int[][] currLevel) {
        this.currLevel = currLevel;
    }

    @Override
    public void interact(Object[] o) {
        System.out.println("lmao");
    }

}
