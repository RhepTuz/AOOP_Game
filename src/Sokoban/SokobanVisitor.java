package Sokoban;

import Base.GameObject;
import Base.Visitor;

public class SokobanVisitor implements Visitor {

    @Override
    public void visit(GameObject o) {
        if(o.getObjectID()== 4){
            visitPlayer(o);
        }
    }

    public void visitPlayer(GameObject pl){

    }

}
