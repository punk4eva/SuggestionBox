
package logic;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Adam Whittaker
 * 
 * Holds an ImageIcon with a contrasting Color for text.
 */
public class FontImage{
    
    public ImageIcon image;
    public Color colour;
    
    /**
     * @param img The ImageIcon.
     * @param col The contrasting Color for text.
     */
    public FontImage(ImageIcon img, Color col){
        image = img;
        colour = col;
    }
    
    public FontImage(String img, Color col){
        image = new ImageIcon("images/" + img + ".png");
        colour = col;
    }
    
}
