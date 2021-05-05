package testGame;

import Base.GameObject;

import javax.swing.*;
import java.io.File;

public class testGameObj extends GameObject {
    private ImageIcon icon = null;

    public testGameObj(File f){
        icon = setIcon(f);
    }

    @Override
    public void update() {

    }
}
