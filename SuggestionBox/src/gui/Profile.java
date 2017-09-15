
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Adam Whittaker
 * @author Charlie Hands
 */
public class Profile{

    JLabel username;
    JTextArea description;
    JComboBox status;
    JTextField email;
    JLabel descriptionTitle;
    JLabel statusTitle;
    JLabel emailTitle;
    JButton submit;
    JButton cancel;
    GridBagConstraints c;

    public Profile(MainClass main){
        username = new JLabel(MainClass.Username);
        email = new JTextField(15);
        description = new JTextArea(5, 20);
        description.setMaximumSize(new Dimension(80, 20));
        emailTitle = new JLabel("Email:");
        descriptionTitle = new JLabel("Tell us something about yourself...");
        c = new GridBagConstraints();
    }

    public void display(JFrame frame){
        Color textcol = MainClass.getBare(frame);
        
        Font font = new Font("Arial", 10, 30);
        username.setFont(font);
        username.setForeground(textcol);
        c.ipady = 30;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 30;
        c.weightx = 0.0;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(email, c);
        JScrollPane scrollpane = new JScrollPane(description);
        scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        frame.add(scrollpane, c);

        frame.revalidate();
        frame.repaint();
    }
    
}
