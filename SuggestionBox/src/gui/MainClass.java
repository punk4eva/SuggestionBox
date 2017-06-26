package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logic.PasswordHolder;
import logic.UserLog;
import logic.SuggestionLog;

import exceptions.*;
import logic.MailManager;

/**
 * @author Charlie Hands
 *
 * This is the main class that sets the JFrame and will run any different pages.
 */
public class MainClass implements ActionListener{

    //Full screen on school computer.
    public static final int WIDTH = 1280, HEIGHT = WIDTH / 5 * 4;
    protected static UserLog userlog = new UserLog();
    protected static SuggestionLog suglog = new SuggestionLog();
    
    public static Random r = new Random();

    protected JFrame frame; //Variables don't get edited in methods, only fields.
    private static Login login;
    private static SignUp signup;
    private static Policies policies;

    /**
     * Initializes the frame.
     */
    public MainClass(){
        frame = new JFrame("WHSB Suggestion System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        getBare(frame);
        
        login = new Login(this);
        signup = new SignUp(this);
        policies = new Policies(this);
        
        //Uncomment the next line to activate testing mode.
        //if(true){new TestingPage(this).display(frame);}else
        login.display(frame);
        
        //always push the userlog and suglog at the end or users get deleted.
        userlog.push();
        suglog.push();
    }
    
    /**
     * Provides a bare JFrame. May be optimizable.
     * @param frame The frame.
     * @return a non-contrast Color Object for text.
     */
    protected static Color getBare(JFrame frame){
        clear(frame);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        int R = r.nextInt(205)+30;
        int G = r.nextInt(195)+60; 
        int B = r.nextInt(135)+120;
        frame.getContentPane().setBackground(new Color(R, G, B));
        return new Color(R, (G+127)%256, (B+127)%256);
    }
    
    /**
     * Clears the frame.
     * @param frame The frame to be cleared.
     */
    protected static void clear(JFrame frame){
        frame.getContentPane().removeAll();
    }

    public static void main(String[] args){
        MainClass mc = new MainClass();
    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Login":
                try{
                    PasswordHolder.passwordValidation(login.Username.getText(),
                            login.Password.getText(), userlog.userList);
                    policies.display(frame);
                }catch(PasswordNotFoundException ex){
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Sign Up":
                if(e.getSource()==login.Signupbtn){
                    signup.display(frame);
                }else{
                    try{
                        String email = signup.Username.getText();
                        String verCode = PasswordHolder.getCode();
                        String given = null;
                        boolean success = false;
                        while(!success){
                            while(given==null){
                                /**MailManager.send("SuggestionBox Verification Code",
                                    "Your verification code is:   " + verCode,
                                    "suggestionbox31@gmail.com",
                                    MailManager.prep(email));*/
                                given = (String)JOptionPane.showInputDialog(frame,
                                    "What is the verification code that you recieved"
                                    + " in an email?", "Confirm Email",
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    new String[] {"OK", "Resend"}, "OK");
                            }
                            if(given.toUpperCase().equals(verCode)){
                                userlog.newUser(email, signup.Password.getText(), 
                                    signup.Email.getText());
                                success = true;
                            }
                        }
                        userlog.newUser(signup.Username.getText(), 
                        signup.Password.getText(), signup.Email.getText());
                    }catch(PasswordUnsafeException | UserAlreadyExistsException 
                            | UnsanitaryEntryException
                            | EmailNotEnteredException ex){
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "<html>Back to<br>Login":
                login.display(frame);
                break;
            case "Agree":
                //Uncomment the next line after completion.
                //frame.setLayout(new GridBagLayout());
                //Sent to homepage
                break;
            case "Disagree":
                switch(JOptionPane.showConfirmDialog(frame, 
                        "If you disagree, you will be sent to the login page. "
                                + "Are you sure you want to exit?", "Warning!",
                                JOptionPane.YES_NO_OPTION)){
                    case 0: //Yes
                        frame.setLayout(new GridBagLayout());
                        login.display(frame);
                        break;
                }
                break;
        }
    }
    
}
