
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Adam Whittaker
 */
public class Policies{
    
    JScrollPane policies;
    JPanel panel = new JPanel();
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
        policies = new JScrollPane(new ScrollableImage(new ImageIcon("policies.png"), 1));
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
        c.gridx = 0;
        c.gridy = 1;
        frame.add(policies,c);
        
        c.gridy = 2;
        c.anchor = GridBagConstraints.SOUTHWEST;
        frame.add(agree,c);
        c.anchor = GridBagConstraints.SOUTHEAST;
        frame.add(disagree,c);
        
        
        frame.revalidate();
        frame.repaint();
    }
    
}
