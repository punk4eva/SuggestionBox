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
 * @Unfinished
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
    
    public SignUp(MainClass main){
        Username = new JTextField("", 15);
        Password = new JPasswordField("", 15);
        c = new GridBagConstraints();
        UTitle = new JLabel("Username:");
        PTitle = new JLabel("Password:");
        ETitle = new JLabel("Email:");
        Title = new JLabel("Make an Account");
        Signupbtn = new JButton("Sign Up");
        Signupbtn.addActionListener(main);
    }
    
    public void display(JFrame frame){
        
        Color textCol = MainClass.getBare(frame);
        UTitle.setForeground(textCol);
        PTitle.setForeground(textCol);
        ETitle.setForeground(textCol);
        Title.setForeground(textCol);
        
        Font font = new Font("Arial", 10, 30);
        Font titleFont = new Font("Arial", 200, 50);
        Font btnfont = new Font("Arial", 10, 15);
        Font emlfont = new Font("Chiller", 200, 50);

        Username.setFont(font);
        Password.setFont(font);
        UTitle.setFont(font);
        PTitle.setFont(font);
        ETitle.setFont(emlfont);
        Title.setFont(titleFont);
        Signupbtn.setFont(btnfont);

        c.ipady = 30;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 3;
        frame.add(Username, c);

        c.gridx = 0;
        frame.add(UTitle, c);

        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 6;
        frame.add(Password, c);

        c.gridx = 0;
        frame.add(PTitle, c);
        
        /**@charlie
        c.gridx = 1;
        c.gridy = 6;
        frame.add(Email, c);

        c.gridx = 0;
        frame.add(ETitle, c);
        */
 
        c.ipady = 0;
        c.gridheight = 1;
        c.gridy = 0;
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        frame.add(Title, c);
        
        c.gridy = 8;
        c.gridx = 1;
        c.anchor = GridBagConstraints.SOUTH;
        frame.add(Signupbtn, c);
        
        frame.revalidate();
        frame.repaint();
    }
    
}
