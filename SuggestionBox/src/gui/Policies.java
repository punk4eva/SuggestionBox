
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Adam Whittaker
 */
public class Policies{
    
    JScrollPane policies;
    JLabel Title;
    JButton agree;
    JButton disagree;
    GridBagConstraints c;
    
    public Policies(MainClass main){
        Title = new JLabel("SUGGESTION SYSTEM POLICIES:");
        agree = new JButton("Agree");
        disagree = new JButton("Disagree");
        agree.addActionListener(main);
        disagree.addActionListener(main);
        c = new GridBagConstraints();
        policies = new JScrollPane(new ScrollableImage(
                new ImageIcon("policies.png"), 5));
        policies.setPreferredSize(new Dimension(1140, 740));
        policies.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
        policies.setVisible(true);
    }
    
    
    public void display(JFrame frame){
        Color textCol = MainClass.getBare(frame);   
        Font btnfont = new Font("Arial", 10, 15);
        
        agree.setFont(btnfont);
        disagree.setFont(btnfont);
        
        frame.add(policies);
        
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        frame.add(agree);

        frame.add(disagree);
        
        frame.revalidate();
        frame.repaint();
    }
    
}
