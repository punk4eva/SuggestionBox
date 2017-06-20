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

/**
 *
 * @author Charlie Hands
 * 
 * Handles the Sign Ups
 * 
 * @Unfinished
 */
public class SignUp implements ActionListener{
    
    JTextField Username;
    JPasswordField Password;
    GridBagConstraints c;
    JLabel UTitle;
    JLabel PTitle;
    JLabel Title;
    JLabel Message;
    JButton Signupbtn;
    MainClass main;
    
    public SignUp(MainClass main){
        Username = new JTextField("", 15);
        Password = new JPasswordField("", 15);
        c = new GridBagConstraints();
        UTitle = new JLabel("Username:");
        PTitle = new JLabel("Password:");
        Title = new JLabel("WHSB Suggestion System");
        Message = new JLabel("Sign in with your Username and Password.");
        Signupbtn = new JButton("Sign Up");
        this.main = main;
    }
    
    public void display(){
        main.frame = MainClass.getBare();
        
        Font font = new Font("Arial", 10, 30);
        Font titleFont = new Font("Arial", 200, 50);
        Font btnfont = new Font("Arial", 10, 15);

        Username.setFont(font);
        Password.setFont(font);
        UTitle.setFont(font);
        PTitle.setFont(font);
        Title.setFont(titleFont);
        Message.setFont(font);
        Signupbtn.setFont(btnfont);

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

        c.gridx = 1;
        c.anchor = GridBagConstraints.SOUTH;
        main.frame.add(Signupbtn, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
