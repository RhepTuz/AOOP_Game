package Sokoban;

import Base.BootlegStrategy;
import com.sun.jdi.BooleanType;

public class OperationMovement{

    private BootlegStrategy strategy;

    public OperationMovement(){
    }

    public void setContext(BootlegStrategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int direction ,int [][]map,int[]position){
        return strategy.doOperation(direction ,map ,position);
    }

    /*


    kör movaAvailable
    berorende på return

    MoveTo
    MoveBox


     */

}

class OperationMoveAvailable implements BootlegStrategy {

    @Override
    public int doOperation(int direction ,int [][]map,int[]position) {
        int dist;
        switch (direction){
            //Move Up
            case 0:
                dist = map[position[0] - 1][position[1]];
                if(dist == 1){
                    //walking into a wall returns a 0 "A false move"
                    return 0;
                }
                else if(dist == 2){
                    //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (map[position[0] - 2][position[1]] == 0 || map[position[0] - 2][position[1]] == 3){
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
                dist = map[position[0]][position[1] + 1];
                if(dist == 1){
                    //walking into a wall
                    return 0;
                }
                else if(dist == 2){
                    //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (map[position[0]][position[1] + 2] == 0 || map[position[0]][position[1] + 2] == 3){
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
                dist = map[position[0] + 1][position[1]];
                if(dist == 1){
                    //walking into a wall
                    return 0;
                }
                else if(dist == 2){
                    //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (map[position[0] + 2][position[1]] == 0 || map[position[0] + 2][position[1]] == 3){
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
                dist = map[position[0]][position[1] - 1];
                if(dist == 1){
                    //walking into a wall
                    return 0;
                }
                else if(dist == 2){
                    //walking into a box
                    //Checks if the tile to the left of the box is either a tile or a pressure plate
                    if (map[position[0]][position[1] - 2] == 0 || map[position[0]][position[1] - 2] == 3){
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
}

class OperationMoveTo implements BootlegStrategy{

    @Override
    public int doOperation(int direction ,int [][]map,int[]position) {
        map[position[0]][position[1]] = 0;
            switch (direction){
                case 0:
                    map[position[0] - 1][position[1]] = 4;
                    position[0] = position[0] - 1;
                    break;
                case 1:
                    map[position[0]][position[1] + 1] = 4;
                    position[1] = position[1] + 1;

                    break;
                case 2:
                    map[position[0] + 1][position[1]] = 4;
                    position[0] = position[0] + 1;
                    break;
                case 3:
                    map[position[0]][position[1] - 1] = 4;
                    position[1] = position[1] - 1;

                    break;
            }
        return direction;
    }
}

class OperationMoveBox implements BootlegStrategy{

    @Override
    public int doOperation(int direction ,int [][]map,int[]position) {
        map[position[0]][position[1]] = 0;

        switch (direction){
            case 0:
                map[position[0] - 1][position[1]] = 4;
                map[position[0] - 2][position[1]] = 2;
                position[0] = position[0] - 1;

                break;
            case 1:
                map[position[0]][position[1] + 1] = 4;
                map[position[0]][position[1] + 2] = 2;
                position[1] = position[1] + 1;

                break;
            case 2:
                map[position[0] + 1][position[1]] = 4;
                map[position[0] + 2][position[1]] = 2;
                position[0] = position[0] + 1;
                break;
            case 3:
                map[position[0]][position[1] - 1] = 4;
                map[position[0]][position[1] - 2] = 2;
                position[1] = position[1] - 1;

                break;
        }
        return direction;
    }
}

