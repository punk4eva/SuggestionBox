
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import logic.PolicyText;

/**
 *
 * @author Adam Whittaker
 */
public class TestingPage{
    
    JScrollPane policies;
    JPanel panel;
    JLabel Title;
    JButton agree;
    JButton disagree;
    GridBagConstraints c;
    
    public TestingPage(MainClass main){
        
        Title = new JLabel("SUGGESTION SYSTEM POLICIES:");
        agree = new JButton("Agree");
        disagree = new JButton("Disagree");
        agree.addActionListener(main);
        disagree.addActionListener(main);
        c = new GridBagConstraints();
        
    }
    
    
    public void display(JFrame frame){
        Color textCol = MainClass.getBare(frame);
        
        policies = new JScrollPane(new JLabel(new PolicyText().text));
        //policies.setPreferredSize(new Dimension(MainClass.WIDTH, MainClass.HEIGHT));
        
        c.gridx = 0;
        c.gridy = 1;
        frame.add(policies);
        
        frame.revalidate();
        frame.repaint();
    }
}
