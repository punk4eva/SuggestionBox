package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import logic.PasswordHolder;
import logic.UserLog;
import logic.SuggestionLog;
import logic.MailManager;
import logic.FontImage;
import logic.ImageHandler;

import exceptions.*;
import logic.SoundHandler;

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
    public static boolean loggedIn = false;
    public static String Username;

    protected JFrame frame; //Variables don't get edited in methods, only fields.
    private static Login login;
    private static SignUp signup;
    private static Policies policies;
    private static Homepage home;
    private static Profile profile;
    private static SuggestionViewer suggestionViewer;
    private static SuggestionEditor suggestionEditor;
    private static News news;
    

    /**
     * Initializes the frame.
     */
    public MainClass(){
        frame = new JFrame("WHSB Suggestion System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        getBare(frame);
        
        SoundHandler.playLoop(10.0f);
        
        login = new Login(this);
        signup = new SignUp(this);
        policies = new Policies(this);
        home = new Homepage(this);
        profile = new Profile(this);
        suggestionViewer = new SuggestionViewer(this);
        suggestionEditor = new SuggestionEditor(this);
        news = new News(this);
        
        
        //Uncomment the next line to activate testing mode.
        //if(true)home.display(frame); else
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
        frame.setVisible(true);
        int R = r.nextInt(205)+30;
        int G = r.nextInt(195)+60; 
        int B = r.nextInt(135)+120;
        //frame.getContentPane().setBackground(new Color(R, G, B));
        frame.setLayout(new BorderLayout());
        FontImage fi = ImageHandler.getRandomFontImage();
        frame.setContentPane(new JLabel(fi.image));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());
        return fi.colour;
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
        System.out.println(e.getActionCommand());
        SoundHandler.playRandomButtonSound(10.0f);
        switch(e.getActionCommand()){
            case "Login":
                try{
                    PasswordHolder.passwordValidation(login.Username.getText(),
                            login.Password.getText(), userlog.userList);
                    Username = login.Username.getText();
                    System.out.println(Username);
                    policies.display(frame);
                }catch(PasswordNotFoundException ex){
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                login.clearFields();
                break;
            case "Sign Up":
                try{
                    String email = signup.Email.getText();
                    if(email.equals("")) throw new EmailNotEnteredException(
                    "Please enter your email!");
                    String verCode = PasswordHolder.getCode();
                    boolean success = false, incorrectAttempt = false, cancel = false;
                    while(!success && !cancel){
                        String given = null;

                            /**MailManager.send("SuggestionBox Verification Code",
                                "Your verification code is:   " + verCode,
                                "suggestionbox31@gmail.com",
                                MailManager.prep(email));*/

                            given = (String)JOptionPane.showInputDialog(frame,
                                (incorrectAttempt ? "<html><font color="
                                        + "\"red\">The code you gave was "
                                        + "incorrect!</font><br>" : "") +
                                "What is the verification code that you "
                                + "recieved in an email?", "Confirm Email",
                                JOptionPane.QUESTION_MESSAGE);
                            System.out.println("GIVEN: " + given);

                        try{
                            if(given.toUpperCase().equals(verCode)||
                                    given.equals("/opensesami")){
                                userlog.newUser(signup.Username.getText(), signup.Password.getText(), 
                                    email);
                                success = true;
                            }else{incorrectAttempt = true;}
                        }catch(NullPointerException e1){
                            cancel = true;
                        }    
                    }
                }catch(PasswordUnsafeException | UserAlreadyExistsException 
                        | UnsanitaryEntryException
                        | EmailNotEnteredException ex){
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "ToSignUp":
                signup.display(frame);
                break;
            case "<html>Back to<br>Login": case "Log Out":
                loggedIn = false;
                login.display(frame);
                break;
            case "Agree":
                frame.setLayout(new GridBagLayout());
                loggedIn = true;
                home.display(frame);
                break;
            case "Disagree":
                switch(JOptionPane.showConfirmDialog(frame, 
                        "If you disagree, you will be sent to the login page. "
                                + "Are you sure you want to exit?", "Warning!",
                                JOptionPane.YES_NO_OPTION)){
                    case 0: //Yes
                        frame.setLayout(new GridBagLayout());
                        loggedIn = false;
                        login.display(frame);
                        break;
                }
                break;
            case "View Policy":
                policies.display(frame);
                break;
            case "Edit Profile":
                profile.display(frame);
                break;
            case "View Suggestions":
                suggestionViewer.display(frame);
                break;
            case "Submit Suggestion":
                suggestionEditor.display(frame);
                break;
            case "View News":
                news.display(frame);
                break;
            case "Back":
                home.display(frame);
                break;
        }
    }
    
}
