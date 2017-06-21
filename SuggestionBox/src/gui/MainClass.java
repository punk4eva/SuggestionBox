package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.UserLog;

import javax.swing.JFrame;

/*
* @author Charlie Hands
*
* This is the main class that sets the JFrame and will run any different pages
*/
public class MainClass implements ActionListener{

    public static final int WIDTH = 1369/**1024*/, HEIGHT = WIDTH / 12 * 9;
    protected static UserLog userlog = new UserLog();

    protected JFrame frame; //Variables don't get edited in methods, only fields.
    private static Login login;
    private static SignUp signup;

    /*
     * Initialises the frame.
     */
    public MainClass(){
        frame = new JFrame("WHSB Suggestion System");
        getBare(frame);
        
        login = new Login(this);
        signup = new SignUp(this);
        
        login.display(frame);
        
        //always push the userlog at the end or users get deleted.
        userlog.push();
    }
    
    /**
     * Provides a bare JFrame.
     * @param frame The frame.
     */
    protected static void getBare(JFrame frame){
        clear(frame);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 250));
    }
    
    /**
     * Clears the frame.
     * @param frame The frame to be cleared.
     */
    protected static void clear(JFrame frame){
        frame.getContentPane().removeAll();
    }

    public static void main(String[] args) {
        new MainClass();
    }

    //If you have multiple ActionListeners, more memory is taken up, but if you have one that loops through all of them, it is still
    //faster because less mem. is used. SOURCE: Sims + Rahman.
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("ACTION");
        if(e.getSource() == login.Loginbtn){
            
        }
        else if(e.getSource() == login.Signupbtn){
            signup.display(frame);
            System.out.println("Checkpoint");
        }
    }
    
}
