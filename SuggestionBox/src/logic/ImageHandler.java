
package logic;

import gui.MainClass;
import java.awt.Color;
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
    
    private static FontImage[] fontImages = new FontImage[] {
        new FontImage("charlotteHurst", new Color(160, 12, 44)),
        new FontImage("dancersFoot", new Color(192, 135, 237)),
        new FontImage("heatherMurray", new Color(98, 209, 166)),
        new FontImage("intellectuallyCurious", new Color(8, 9, 22)),
        new FontImage("landscape", new Color(7, 247, 0)),
        new FontImage("liamHeatherson", new Color(226, 148, 13)),
        new FontImage("roughSeasAndMemories", new Color(255,255,255)),
        new FontImage("theSea", new Color(0, 0, 255)),
        new FontImage("thrillsInSpills", new Color(96, 233, 21)),
        new FontImage("urbanNightscape", new Color(206, 141, 12)),
        new FontImage("youth2012", new Color(255,255,255))
    };
    
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
    
    /**
     * Returns a random FontImage.
     * @return The random FontImage.
     */
    public static FontImage getRandomFontImage(){
        return fontImages[MainClass.r.nextInt(fontImages.length)];
    }
    
}
