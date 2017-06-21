package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logic.PasswordHolder;
import logic.UserLog;
import logic.SuggestionLog;

import exceptions.PasswordNotFoundException;

/*
* @author Charlie Hands
*
* This is the main class that sets the JFrame and will run any different pages
*/
public class MainClass implements ActionListener{

    //Full screen on school computer.
    public static final int WIDTH = 1280, HEIGHT = WIDTH / 5 * 4;
    protected static UserLog userlog = new UserLog();
    protected static SuggestionLog suglog = new SuggestionLog();

    protected JFrame frame; //Variables don't get edited in methods, only fields.
    private static Login login;
    private static SignUp signup;

    /**
     * Initialises the frame.
     */
    public MainClass(){
        frame = new JFrame("WHSB Suggestion System");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //newly added. Makes full screen.
        getBare(frame);
        
        login = new Login(this);
        signup = new SignUp(this);
        
        login.display(frame);
        
        //always push the userlog and suglog at the end or users get deleted.
        userlog.push();
        suglog.push();
    }
    
    /**
     * Provides a bare JFrame. May be optimizable.
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

    //If you have multiple ActionListeners, more memory is taken up, but if you 
    //have one that loops through all of them, it is still faster because less 
    //mem. is used. SOURCE: Sims + Rahman. Also a switch will be 25% faster as 
    //they work with primatives the compiler will recognise them and optimize.
    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Login":
                try{
                    PasswordHolder.passwordValidation(login.Username.getText(),
                            login.Password.getText(), userlog.userList);
                    //Don't worry about how getText() is deprecated as it had
                    //security issues that aren't applicable to us.
                }catch(PasswordNotFoundException ex){
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Sign Up":
                if(e.getSource()==login.Signupbtn){
                    signup.display(frame);
                }else{
                    userlog.newUser(signup.Username.getText(), 
                            signup.Password.getText(), signup.Email.getText());
                }
                break;
        }
    }
    
}
