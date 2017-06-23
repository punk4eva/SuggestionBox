package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import logic.PolicyText;

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
        //We should use a JPanel or something to store both policies and buttons.
        policies = new JScrollPane(new JLabel(new PolicyText().text));
        Title = new JLabel("SUGGESTION SYSTEM POLICIES:");
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
        
        Font btnFont = new Font("Arial", 10, 15);
        
        agree.setFont(btnFont);
        disagree.setFont(btnFont);
       
        c.gridx = 0;
        frame.add(policies);
        
        frame.revalidate();
        frame.repaint();
    }
    
}
