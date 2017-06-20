package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import logic.PasswordHolder;

/*
* @author Charlie Hands
* 
* This is the login page
* @Unfinished
*/
public class Login implements ActionListener {

    JTextField Username;
    JPasswordField Password;
    GridBagConstraints c;
    JLabel UTitle;
    JLabel PTitle;
    JLabel Title;
    JLabel Message;
    JButton Loginbtn;
    JButton Signupbtn;
    MainClass main;
    
    SignUp signup;

    /*
     * Initialises all the components
     */
    public Login(MainClass main) {
        Username = new JTextField("", 15);
        Password = new JPasswordField("", 15);
        c = new GridBagConstraints();
        UTitle = new JLabel("Username:");
        PTitle = new JLabel("Password:");
        Title = new JLabel("WHSB Suggestion System");
        Message = new JLabel("Sign in with your Username and Password.");
        Loginbtn = new JButton("Login");
        Signupbtn = new JButton("Sign Up");
        this.main = main;
        this.signup = new SignUp(main);
    }

    /*
     * Displays all the components in the JFrame
     * 
     * @param frame The JFrame from MainClass
     */
    public void display(){

        main.frame = MainClass.getBare();
        /** The way you make the individual pages is quite different. Usually
         * one extends a JPanel or something. I made a quick untested solution
         * to your bug by clearing the JFrame each new page, only 50% chance of
         * working. We'll wait and see if it works after you finish the SignUp
         * class.
         */
        
        Font font = new Font("Arial", 10, 30);
        Font titleFont = new Font("Arial", 200, 50);
        Font btnfont = new Font("Arial", 10, 15);

        Username.setFont(font);
        Password.setFont(font);
        UTitle.setFont(font);
        PTitle.setFont(font);
        Title.setFont(titleFont);
        Message.setFont(font);
        Loginbtn.setFont(btnfont);
        Signupbtn.setFont(btnfont);

        Loginbtn.addActionListener(this);
        Signupbtn.addActionListener(this);

        c.ipady = 30;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 3;
        main.frame.add(Username, c);

        c.gridx = 0;
        main.frame.add(UTitle, c);

        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 6;
        main.frame.add(Password, c);

        c.gridx = 0;
        main.frame.add(PTitle, c);

        c.ipady = 0;
        c.gridheight = 1;
        c.gridy = 0;
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        main.frame.add(Title, c);

        c.gridy = 2;
        main.frame.add(Message, c);

        c.gridy = 8;
        c.anchor = GridBagConstraints.SOUTH;
        main.frame.add(Loginbtn, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.SOUTHEAST;
        main.frame.add(Signupbtn, c);
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Loginbtn){
            //PasswordHolder.passwordValidation(Username.getText(), Password.getText(), userList);
        }
        else if(e.getSource() == Signupbtn){
            //Go to different Sign Up page
            signup.display();
        }
    }
	
}
