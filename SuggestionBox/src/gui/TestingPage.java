
package gui;

import java.awt.Color;
import java.awt.Dimension;
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
public class TestingPage{
    
    JScrollPane policies;
    JPanel panel = new JPanel();
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
        policies = new JScrollPane(new ScrollableImage(new ImageIcon("policies.png"), 1));
        policies.setPreferredSize(new Dimension(1140, 740));
        policies.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
        policies.setVisible(true);
    }
    
    
    public void display(JFrame frame){
        Color textCol = MainClass.getBare(frame);   
        
        c.gridx = 0;
        c.gridy = 1;
        
        frame.add(policies);
        System.out.println("Checkpoint");
        
        frame.revalidate();
        frame.repaint();
    }
 
    private JPanel getPanel(){
        JPanel ret = new JPanel(new GridBagLayout());
        ret.setPreferredSize(new Dimension(2000, 2000));
        
        c.gridy = 0;
        c.gridx = 1;
        //ret.add(Title);
        
        c.gridx = 2;
        ret.add(new JLabel(new ImageIcon("policies.png")));
        
        //c.gridx = 3;
        //ret.add(agree);
        //c.gridy  = 3;
        //ret.add(disagree);
        
        return ret;
    }
    
}
