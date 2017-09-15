
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
    JLabel descriptionTitle;
    JLabel statusTitle;
    JLabel emailTitle;
    GridBagConstraints c;

    public Profile(MainClass main){
        username = new JLabel(MainClass.Username);
        email = new JTextField("", 15);
        emailTitle = new JLabel("Email:");
        c = new GridBagConstraints();
    }

    public void display(JFrame frame){
        Color textcol = MainClass.getBare(frame);
        
        Font font = new Font("Arial", 10, 30);
        username.setFont(font);
        username.setForeground(textcol);
        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 30;
        c.weightx = 0.0;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(email, c);

        frame.revalidate();
        frame.repaint();
    }
    
}
