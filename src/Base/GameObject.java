package Base;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GameObject {

    public ImageIcon setIcon(File file) {
        ImageIcon imgrtn = null;
        try {

            BufferedImage img = ImageIO.read(file);
            BufferedImage reScaled = new BufferedImage(200, 200, BufferedImage.TYPE_INT_BGR);

            Graphics2D g2 = reScaled.createGraphics();
            g2.drawImage(img, 0, 0, 200, 200, null);
            g2.dispose();

            imgrtn = new ImageIcon(reScaled);

        } catch (IOException e) {
            System.out.println("file not found");
        }
        return imgrtn;
    }

    public abstract void update();
}
