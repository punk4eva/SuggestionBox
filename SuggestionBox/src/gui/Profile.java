
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Adam Whittaker
 * @author Charlie Hands
 */
public class Profile{
        JLabel username;
        JTextField description;
        JComboBox status;
        JTextField email;
        JLabel usernameTitle;
        JLabel descriptionTitle;
        JLabel statusTitle;
        JLabel emailTitle;
        GridBagConstraints c;
    public Profile(MainClass main){
        username = new JLabel(MainClass.Username);
        c = new GridBagConstraints();
    }
    
    public void display(JFrame frame){
        Color textcol = MainClass.getBare(frame);
        System.out.println(MainClass.Username);
         Font font = new Font("Arial", 10, 30);
        username.setFont(font);
        username.setForeground(textcol);
        c.gridx = 1;
        c.gridy = 1;
        frame.add(username, c);
        
        frame.revalidate();
        frame.repaint();
    }
}
