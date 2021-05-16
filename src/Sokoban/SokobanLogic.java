package Sokoban;

import Base.GameLogic;

import java.util.Arrays;

/**
 * This class handles the interaction between the different integers of the 2D array
 * this includes movement of the playercharacter pushing the boxes and walls and the pressure plates
 */
public class SokobanLogic extends GameLogic {
    private int[][] currLevel;
    private int[] playerPos = new int[2];
    private int[] boxPos = new int[2];
    private OperationMovement opMove;

    public SokobanLogic(int[][] lvl){

        currLevel = lvl;
        opMove = new OperationMovement();

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



    /* private int moveAvailable(int dir){
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
*/
  /*  public int moveTo(int dir, int condition){
        System.out.println(moveAvailable(dir));
        int move = moveAvailable(dir);
        switch (move){
            default:
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
        return move;


    }
*/
    public void setCurrLevel(int[][] currLevel) {
        this.currLevel = currLevel;
    }

    public int[][] getCurrLevel(){
        return currLevel;
    }

    public void resetPlayerPos(){
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



    @Override
    public void interact(Object[] o) {
        System.out.println("lmao");
    }

    public void move(int dir){
        opMove.setContext(new OperationMoveAvailable());

        switch (opMove.executeStrategy(dir, currLevel, playerPos)){
            case 0:
                break;
            case 1:
                opMove.setContext(new OperationMoveTo());
                opMove.executeStrategy(dir, currLevel, playerPos);
            break;
            case 2:
                opMove.setContext(new OperationMoveBox());
                opMove.executeStrategy(dir, currLevel, playerPos);
            break;
        }
        opMove.setContext(null);


    }

}
