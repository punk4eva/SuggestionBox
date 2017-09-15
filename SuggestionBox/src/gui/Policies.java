
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Adam Whittaker
 * @author Charlie Hands
 */
public class Policies{
    
    JScrollPane policies;
    JLabel Title;
    JButton Agree;
    JButton Disagree;
    JButton back;
    GridBagConstraints c;
    
    public Policies(MainClass main){
        Title = new JLabel("SUGGESTION SYSTEM POLICIES:");
        Agree = new JButton("Agree");
        Disagree = new JButton("Disagree");
        Agree.addActionListener(main);
        Disagree.addActionListener(main);
        back = new JButton("Back");
        back.addActionListener(main);
        c = new GridBagConstraints();
        policies = new JScrollPane(new ScrollableImage(
                new ImageIcon("images/policies.png"), 5));
        policies.setPreferredSize(new Dimension(1140, 740));
        policies.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
        policies.setVisible(true);
    }
    
    
    public void display(JFrame frame){
        MainClass.getBare(frame);   
        Font btnfont = new Font("Arial", 10, 15);
        
        Agree.setFont(btnfont);
        Disagree.setFont(btnfont);
        
        frame.add(policies);
        
        //This will set the Agree and Disagree buttons the the right of the screen
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        
        //These will set the buttons to the bottom of the screen: Just add ",c" 
        //to the frame.add
        //c.gridx = 0;
        //c.gridy = 1;
        //c.anchor = GridBagConstraints.SOUTHWEST;
        if(!MainClass.loggedIn){
            frame.add(Agree);
            //c.anchor = GridBagConstraints.SOUTHEAST;
            frame.add(Disagree);
        }
        else frame.add(back);
        
        frame.revalidate();
        frame.repaint();
    }
    
}
