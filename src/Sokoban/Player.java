package Sokoban;

import Base.GameObject;
import Base.Visitor;

import java.io.File;

public class Player extends GameObject {
    public Player() {
        super(4, new File("sokoban_icons/player.png"), 100, 100);
    }


    @Override
    public void accept(Visitor iv) {
        iv.visit(this);
    }
}
