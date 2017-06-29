
package logic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Adam Whittaker
 * 
 * Handles Image manipulation.
 */
public class ImageHandler{
    
    /**
     * Resize an ImageIcon by setting width and hight.
     * @param srcImg The ImageIcon to be resized.
     * @param w The new width.
     * @param h The new hight.
     * @return The resized ImageIcon.
     */
    public static ImageIcon resize(ImageIcon srcImg, int w, int h){
        Image img = srcImg.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), 
                img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, w, h, null);
        return new ImageIcon(bi);
    }
    
    /**
     * Resize an ImageIcon by multiplying dimensions by a scale factor.
     * @param srcImg The ImageIcon to be resized.
     * @param scaleFactor The scale factor to resize by.
     * @return The resized ImageIcon.
     */
    public static ImageIcon resize(ImageIcon srcImg, double scaleFactor){
        Image img = srcImg.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), 
                img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, (int)(scaleFactor*srcImg.getIconWidth()),
                (int)(srcImg.getIconHeight()*scaleFactor), null);
        return new ImageIcon(bi);
    }
}
