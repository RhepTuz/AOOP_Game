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
        int dist  ;
        switch (direction){
            //Move Up
            case 0:
                dist = map[position[0] - 1][position[1]];
                if(dist == Assets.wall.getObjectID()){
                    //walking into a wall returns a 0 "A false move"
                    return 0;
                }
                else if(dist == Assets.crate.getObjectID()){
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
                    // If player character moves to any other tile i.e pressure plate or floor it counts as a...
                    //...legitimate move
                    return 1;
                }
                //Move Right
            case 1:
                dist = map[position[0]][position[1] + 1];
                if(dist == Assets.wall.getObjectID()){
                    //walking into a wall
                    return 0;
                }
                else if(dist == Assets.crate.getObjectID() || dist == Assets.crateMarked.getObjectID()){
                    //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (map[position[0]][position[1] + 2] == Assets.blank.getObjectID() || map[position[0]][position[1] + 2] == Assets.blankMarked.getObjectID()){
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
                if(dist == Assets.wall.getObjectID()){
                    //walking into a wall
                    return 0;
                }
                else if(dist == Assets.crate.getObjectID() || dist == Assets.crateMarked.getObjectID()){
                    //walking into a box
                    //Checks if the tile to the bottom of the box is either a tile or a pressure plate
                    if (map[position[0] + 2][position[1]] == Assets.blank.getObjectID() || map[position[0] + 2][position[1]] == Assets.blankMarked.getObjectID()){
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
                if(dist == Assets.wall.getObjectID()){
                    //walking into a wall
                    return 0;
                }
                else if(dist == Assets.crate.getObjectID()){
                    //walking into a box
                    //Checks if the tile to the left of the box is either a tile or a pressure plate
                    if (map[position[0]][position[1] - 2] == Assets.blank.getObjectID() || map[position[0]][position[1] - 2] == Assets.blankMarked.getObjectID()){
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
                    map[position[0] - 1][position[1]] = Assets.player.getObjectID();
                    position[0] = position[0] - 1;
                    break;
                case 1:
                    map[position[0]][position[1] + 1] = Assets.player.getObjectID();
                    position[1] = position[1] + 1;

                    break;
                case 2:
                    map[position[0] + 1][position[1]] = Assets.player.getObjectID();
                    position[0] = position[0] + 1;
                    break;
                case 3:
                    map[position[0]][position[1] - 1] = Assets.player.getObjectID();
                    position[1] = position[1] - 1;

                    break;
            }
        return direction;
    }
}

class OperationMoveBox implements BootlegStrategy{

    @Override
    public int doOperation(int direction ,int [][]map, int[]position) {
        map[position[0]][position[1]] = 0;

        switch (direction){
            case 0:

                if(map[position[0] - 2][position[1]] == Assets.blankMarked.getObjectID()){
                    map[position[0] - 2][position[1]] = Assets.crateMarked.getObjectID();
                }
                else{
                    map[position[0] - 2][position[1]] = Assets.crate.getObjectID();
                }
                map[position[0] - 1][position[1]] = Assets.player.getObjectID();
                position[0] = position[0] - 1;

                break;
            case 1:

                if(map[position[0]][position[1] + 2] == Assets.blankMarked.getObjectID()){
                    map[position[0]][position[1] + 2] = Assets.crateMarked.getObjectID();
                }
                else{
                    map[position[0]][position[1] + 2] = Assets.crate.getObjectID();
                }

                map[position[0]][position[1] + 1] = Assets.player.getObjectID();
                position[1] = position[1] + 1;


                break;
            case 2:

                if(map[position[0] + 2][position[1]] == Assets.blankMarked.getObjectID()){
                    map[position[0] + 2][position[1]] = Assets.crateMarked.getObjectID();
                }
                else{
                    map[position[0]][position[1] + 2] = Assets.crate.getObjectID();
                }

                map[position[0] + 1][position[1]] = Assets.player.getObjectID();
                position[0] = position[0] + 1;

                break;
            case 3:

                if(map[position[0]][position[1] - 2] == Assets.blankMarked.getObjectID()){
                    map[position[0]][position[1] - 2] = Assets.crateMarked.getObjectID();
                }
                else{
                    map[position[0]][position[1] - 2] = Assets.crate.getObjectID();
                }

                map[position[0]][position[1] - 1] = Assets.player.getObjectID();
                position[1] = position[1] - 1;

                break;
        }
        return direction;
    }
}

