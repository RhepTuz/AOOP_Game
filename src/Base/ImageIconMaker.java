package Base;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageIconMaker {
    public static ImageIcon makeImageIcon(File file, int width, int height){
        ImageIcon imgrtn = null;
        try {

            BufferedImage img = ImageIO.read(file);
            BufferedImage reScaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

            Graphics2D g2 = reScaled.createGraphics();
            g2.drawImage(img, 0, 0, width, height, null);
            g2.dispose();

            imgrtn = new ImageIcon(reScaled);

        } catch (IOException e) {
            System.out.println("file not found");
        }
        return imgrtn;
    }
}
