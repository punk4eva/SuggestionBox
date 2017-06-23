package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Charlie Hands
 * 
 * Shows the policies
 */
public class Policies {
    JScrollPane policies;
    JLabel Title;
    JButton agree;
    JButton disagree;
    GridBagConstraints c;
    public Policies(MainClass main){
        policies = new JScrollPane();
        Title = new JLabel("Policies:");
        agree = new JButton("Agree");
        disagree = new JButton("Disagree");
        agree.addActionListener(main);
        disagree.addActionListener(main);
        c = new GridBagConstraints();
    }
    public void display(JFrame frame){
        Color textCol = MainClass.getBare(frame);
        policies.setForeground(textCol);
        Title.setForeground(textCol);
        
        Font titleFont = new Font("Arial", 200, 50);
        Font btnFont = new Font("Arial", 10, 15);
        Font font = new Font("Arial", 200, 50);
        
        policies.setFont(font);
        Title.setFont(titleFont);
        agree.setFont(btnFont);
        disagree.setFont(btnFont);
       
        c.gridx = 0;
        frame.add(policies);
        
    }
}
