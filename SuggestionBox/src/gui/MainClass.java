package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import logic.UserLog;

import javax.swing.JFrame;

/*
* @author Charlie Hands
*
* This is the main class that sets the JFrame and will run any different pages
*/
public class MainClass{

    public static final int WIDTH = 1024, HEIGHT = WIDTH / 12 * 9;
    protected static UserLog userlog = new UserLog();

    protected JFrame frame; //Variables don't get edited in methods, only fields.
    private Login login = new Login();

    /*
     * Initialises the frame.
     */
    public MainClass(){
        frame = getBare();

        login.display(this);

        //always push the userlog at the end or users get deleted.
        userlog.push();
    }
    
    /**
     * Provides a bare JFrame.
     * @return The bare necessities of a JFrame.
     */
    protected static JFrame getBare(){
        JFrame frame = new JFrame("WHSB Suggestion System");

        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 250));
        return frame;
    }

    public static void main(String[] args) {
        new MainClass();
    }

}
