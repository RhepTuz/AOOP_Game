package Base;

import javax.swing.*;
import java.io.File;

public abstract class GameObject {

    private ImageIcon icon;
    private int objID;

    public GameObject(int id, File file, int width, int height){
       icon = ImageIconMaker.makeImageIcon(file, width,height);
       objID = id;
    }

    public void setIcon(File file, int width, int height) {
        icon = ImageIconMaker.makeImageIcon(file, width,height);
    }
    public ImageIcon getIcon(){
        return icon;
    }

    public void setObjectID(int id){
        objID = id;
    }
    public int getObjectID(){
        return objID;
    }


}
