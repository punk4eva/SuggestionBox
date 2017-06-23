package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
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
 * 
 */
public class SignUp{
    
    JTextField Username;
    JPasswordField Password;
    JTextField Email;
    GridBagConstraints c;
    JLabel UTitle;
    JLabel PTitle;
    JLabel Title;
    JLabel ETitle;
    JButton Signupbtn;
    JButton toLogin;
    
    public SignUp(MainClass main){
        Username = new JTextField("", 15);
        Password = new JPasswordField("", 15);
        Email = new JTextField("",15);
        c = new GridBagConstraints();
        UTitle = new JLabel("Name:");
        PTitle = new JLabel("Password:");
        ETitle = new JLabel("Email:");
        Title = new JLabel("Make an Account");
        Signupbtn = new JButton("Sign Up");
        toLogin = new JButton("Login");
        Signupbtn.addActionListener(main);
        toLogin.addActionListener(main);
    }
    
    public void display(JFrame frame){
        
        Color textCol = MainClass.getBare(frame);
        UTitle.setForeground(textCol);
        PTitle.setForeground(textCol);
        ETitle.setForeground(textCol);
        Title.setForeground(textCol);
        
        Font titleFont = new Font("Arial", 200, 50);
        Font btnfont = new Font("Arial", 10, 15);
        Font font = new Font("Chiller", 200, 50);

        Username.setFont(font);
        Password.setFont(font);
        Email.setFont(font);
        UTitle.setFont(font);
        PTitle.setFont(font);
        ETitle.setFont(font);
        Title.setFont(titleFont);
        Signupbtn.setFont(btnfont);
        toLogin.setFont(btnfont);

        c.ipady = 30;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 3;
        frame.add(Username, c);

        c.gridx = 0;
        frame.add(UTitle, c);

        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 4;
        frame.add(Password, c);

        c.gridx = 0;
        frame.add(PTitle, c);
        
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 1;
        c.gridy = 1;
        frame.add(Email, c);

        c.gridx = 0;
        frame.add(ETitle, c);
        
        c.gridy = 0;
        c.gridx = 1;
        c.anchor = GridBagConstraints.NORTH;
        frame.add(Title, c);
        
        c.gridy = 8;
        c.gridx = 1;
        c.gridheight = 5;
        c.anchor = GridBagConstraints.SOUTH;
        frame.add(Signupbtn, c);
        
        //c.anchor = GridBagConstraints.SOUTHEAST;
        //frame.add(toLogin, c);
        
        frame.revalidate();
        frame.repaint();
    }
    
}
