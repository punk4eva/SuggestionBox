package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

/*
* @author Charlie Hands
*
* This is the main class that sets the JFrame and will run any different pages
*/
public class MainClass{

	public static final int WIDTH = 1024, HEIGHT = WIDTH /12*9;
	
	private Login login = new Login();
	
	/*
	* Initialises the frame.
	*/
	public MainClass(){
		JFrame frame = new JFrame("WHSB Suggestion System");
		
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new GridBagLayout());
		frame.getContentPane().setBackground(new Color(230,240,250));
		
		display(frame);
	}
	/*
	* @param The JFrame from the initialiser
	*
	* This will choose what to display and display it
	*/
	public void display(JFrame frame){
		login.display(frame);
	}
	
	public static void main(String[] args){
		new MainClass();
	}

}
