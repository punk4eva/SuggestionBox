package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
* @author Charlie Hands
* 
* This is the login page
*/
public class Login {
	
	JTextField Username;
	JPasswordField Password;
	GridBagConstraints c;
	JLabel UTitle;
	JLabel PTitle;
	JLabel Title;
	JLabel Message;
	JButton Loginbtn;
	/*
	* Initialises all the components
	*/
	public Login(){
		this.Username = new JTextField("", 15);
		this.Password = new JPasswordField("", 15);
		this.c = new GridBagConstraints();
		this.UTitle = new JLabel("Username:");
		this.PTitle = new JLabel("Password:");
		this.Title = new JLabel("WHSB Suggestion System");
		this.Message = new JLabel("Sign in with your Username and Password.");
		this.Loginbtn = new JButton("Login");
		
	}
	
	/*
	* Displays all the components to the JFrame
	*
	* @param frame The JFrame from MainClass
	*/
	public void display(JFrame frame){
		Font font = new Font("Arial", 10,30);
		Font titleFont = new Font("Arial", 200, 50);
		
		Username.setFont(font);
		Password.setFont(font);
		UTitle.setFont(font);
		PTitle.setFont(font);
		Title.setFont(titleFont);
		Message.setFont(font);
		
		c.ipady = 30;
		c.weightx = 0.0;
		c.gridx = 1;
		c.gridy = 3;
		frame.add(Username,c);
		
		c.gridx = 0;
		frame.add(UTitle, c);
		
		c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 6;
		frame.add(Password,c);
		
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
	}
	
}
