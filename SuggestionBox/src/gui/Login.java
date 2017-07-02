package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
* @author Charlie Hands
* 
* This is the login page
* @Unfinished
*/
public class Login{

    JTextField Username;
    JPasswordField Password;
    GridBagConstraints c;
    JLabel UTitle;
    JLabel PTitle;
    JLabel Title;
    JLabel Message;
    JButton Loginbtn;
    JButton Signupbtn;

    /*
     * Initialises all the components
     */
    public Login(MainClass main){
        Username = new JTextField("", 15);
        Password = new JPasswordField("", 15);
        c = new GridBagConstraints();
        UTitle = new JLabel("Name:");
        PTitle = new JLabel("Password:");
        Title = new JLabel("WHSB Suggestion System");
        Message = new JLabel("Sign in with your Username and Password.");
        Loginbtn = new JButton(new ImageIcon("images/login.png"));
        Loginbtn.setOpaque(false);
        Loginbtn.setContentAreaFilled(false);
        Loginbtn.setBorderPainted(false);
        Loginbtn.setActionCommand("Login");
        Signupbtn = new JButton(new ImageIcon("images/signup.png"));
        Signupbtn.setOpaque(false);
        Signupbtn.setContentAreaFilled(false);
        Signupbtn.setBorderPainted(false);
        Signupbtn.setActionCommand("Sign Up");
        Loginbtn.addActionListener(main);
        Signupbtn.addActionListener(main);
    }

    /**
     * Displays all the components in the JFrame
     * @param frame The JFrame from MainClass
     */
    public void display(JFrame frame){
        
        Color textCol = MainClass.getBare(frame);
	UTitle.setForeground(textCol);
	PTitle.setForeground(textCol);
	Title.setForeground(textCol);
        Message.setForeground(textCol);
        
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

        c.ipady = 30;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(Username, c);

        c.gridx = 0;
        frame.add(UTitle, c);

        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 6;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(Password, c);

        c.gridx = 0;
        frame.add(PTitle, c);

        c.ipady = 0;
        c.gridheight = 1;
        c.gridy = 0;
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        frame.add(Title, c);

        c.gridy = 2;
        frame.add(Message, c);

        c.gridy = 8;
        c.anchor = GridBagConstraints.SOUTH;
        frame.add(Loginbtn, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.SOUTHEAST;
        frame.add(Signupbtn, c);
        
        frame.revalidate();
        frame.repaint();
    }
	
    /**
     * Resets Login fields.
     */
    public void clearFields(){
        Username.setText("");
        Password.setText("");
    }
    
}
