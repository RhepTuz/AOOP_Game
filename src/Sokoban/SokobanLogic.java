package Sokoban;

import Base.GameLogic;

import java.util.Arrays;

public class SokobanLogic extends GameLogic {

    private int[][] currLevel;
    private int[] playerPos = new int[2];
    private int[] boxPos = new int[2];

    public SokobanLogic(int[][] lvl){
        currLevel = lvl;


        for(int i = 0; i < currLevel.length; i++){
            for(int j = 0; j < currLevel[i].length; j++){
               if(currLevel[i][j] == 4){
                   playerPos[0] = i;
                   playerPos[1] = j;
                   break;
               }
            }
        }
    }

    private int moveAvailable(int dir){
        int dist;
        switch (dir){
            //Move Up
            case 0:
                dist = currLevel[playerPos[0] - 1][playerPos[1]];
                if(dist == 1){
                    //walking into a wall returns a 0 "A false move"
                    return 0;
                }
                else if(dist == 2){
                     //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (currLevel[playerPos[0] - 2][playerPos[1]] == 0 || currLevel[playerPos[0] - 2][playerPos[1]] == 3){
                        return 2;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    // If player character moves to any other tile i.e pressure plate or floor it couns as a...
                    //...legitimate move
                    return 1;
                }
            //Move Right
            case 1:
                dist = currLevel[playerPos[0]][playerPos[1] + 1];
                if(dist == 1){
                    //walking into a wall
                    return 0;
                }
                else if(dist == 2){
                    //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (currLevel[playerPos[0]][playerPos[1] + 2] == 0 || currLevel[playerPos[0]][playerPos[1] + 2] == 3){
                        return 2;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 1;
                }
            //Move Down
            case 2:
                dist = currLevel[playerPos[0] + 1][playerPos[1]];
                if(dist == 1){
                    //walking into a wall
                    return 0;
                }
                else if(dist == 2){
                    //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (currLevel[playerPos[0] + 2][playerPos[1]] == 0 || currLevel[playerPos[0] + 2][playerPos[1]] == 3){
                        return 2;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 1;
                }
            //Move Left
            case 3:
                dist = currLevel[playerPos[0]][playerPos[1] - 1];
                if(dist == 1){
                    //walking into a wall
                    return 0;
                }
                else if(dist == 2){
                    //walking into a box
                    //Checks if the tile to the left of the box is either a tile or a pressure plate
                    if (currLevel[playerPos[0]][playerPos[1] - 2] == 0 || currLevel[playerPos[0]][playerPos[1] - 2] == 3){
                        return 2;
                    }
                    else{
                        return 0;
                    }
                }
                else{
                    return 1;
                }
            default:
                return 0;
        }
    }
    // Code rivaling the big game companies
    public void moveTo(int dir){
        System.out.println(moveAvailable(dir));
        switch (moveAvailable(dir)){

            case 0:
                break;
            case 1:
                currLevel[playerPos[0]][playerPos[1]] = 0;
                switch (dir){
                    case 0:
                        currLevel[playerPos[0] - 1][playerPos[1]] = 4;
                        playerPos[0] = playerPos[0] - 1;
                        break;
                    case 1:
                        currLevel[playerPos[0]][playerPos[1] + 1] = 4;
                        playerPos[1] = playerPos[1] + 1;

                        break;
                    case 2:
                        currLevel[playerPos[0] + 1][playerPos[1]] = 4;
                        playerPos[0] = playerPos[0] + 1;
                        break;
                    case 3:
                        currLevel[playerPos[0]][playerPos[1] - 1] = 4;
                        playerPos[1] = playerPos[1] - 1;

                        break;
                }
                break;
            case 2:
                currLevel[playerPos[0]][playerPos[1]] = 0;
                switch (dir){
                    case 0:
                        currLevel[playerPos[0] - 1][playerPos[1]] = 4;
                        currLevel[playerPos[0] - 2][playerPos[1]] = 2;
                        playerPos[0] = playerPos[0] - 1;

                        break;
                    case 1:
                        currLevel[playerPos[0]][playerPos[1] + 1] = 4;
                        currLevel[playerPos[0]][playerPos[1] + 2] = 2;
                        playerPos[1] = playerPos[1] + 1;

                        break;
                    case 2:
                        currLevel[playerPos[0] + 1][playerPos[1]] = 4;
                        currLevel[playerPos[0] + 2][playerPos[1]] = 2;
                        playerPos[0] = playerPos[0] + 1;
                        break;
                    case 3:
                        currLevel[playerPos[0]][playerPos[1] - 1] = 4;
                        currLevel[playerPos[0]][playerPos[1] - 2] = 2;
                        playerPos[1] = playerPos[1] - 1;

                        break;
                }

                break;

        }


    }

    public void setCurrLevel(int[][] currLevel) {
        this.currLevel = currLevel;
    }

    public int[][] getCurrLevel(){
        return currLevel;
    }

    @Override
    public void interact(Object[] o) {
        System.out.println("lmao");
    }

}
