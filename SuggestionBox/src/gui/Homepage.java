
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Charlie Hands
 */
public class Homepage{
    
    GridBagConstraints c;
    JButton editProfile = new JButton(new ImageIcon("images/fullFace256.png"));
    JButton submitSuggestion = new JButton(new ImageIcon("images/streak256.png"));
    JButton viewSuggestions = new JButton(new ImageIcon("images/tie256.png"));
    JButton viewPolicy = new JButton(new ImageIcon("images/book256.png"));
    JButton viewNews = new JButton(new ImageIcon("images/eye256.png"));
    JButton logOut = new JButton(new ImageIcon("images/intellectualFace256.png"));
    JLabel profTitle = new JLabel("View Profile");;
    JLabel subTitle = new JLabel("View Policies");
    JLabel viewTitle = new JLabel("View News");;
    JLabel polTitle = new JLabel("Submit a Suggestion"); 
    JLabel newsTitle = new JLabel("Log out");;
    JLabel outTitle = new JLabel("View Suggestions");   
    
    /**
     * Initializes all the components.
     * @param main The MainClass whose ActionListener to add.
     * @unfinished
     */
    public Homepage(MainClass main){
        editProfile.setOpaque(false);
        editProfile.setContentAreaFilled(false);
        editProfile.setBorderPainted(false);
        editProfile.setActionCommand("Edit Profile");
        editProfile.setVisible(true);
        submitSuggestion.setOpaque(false);
        submitSuggestion.setContentAreaFilled(false);
        submitSuggestion.setBorderPainted(false);
        submitSuggestion.setActionCommand("Submit Suggestion");
        viewSuggestions.setOpaque(false);
        viewSuggestions.setContentAreaFilled(false);
        viewSuggestions.setBorderPainted(false);
        viewSuggestions.setActionCommand("View Suggestions");
        viewPolicy.setOpaque(false);
        viewPolicy.setContentAreaFilled(false);
        viewPolicy.setBorderPainted(false);
        viewPolicy.setActionCommand("View Policy");
        viewNews.setOpaque(false);
        viewNews.setContentAreaFilled(false);
        viewNews.setBorderPainted(false);
        viewNews.setActionCommand("View News");
        logOut.setOpaque(false);
        logOut.setContentAreaFilled(false);
        logOut.setBorderPainted(false);
        logOut.setActionCommand("Log Out");
        c = new GridBagConstraints();
        editProfile.addActionListener(main);
        logOut.addActionListener(main);
        viewNews.addActionListener(main);
        viewPolicy.addActionListener(main);
        viewSuggestions.addActionListener(main);
        submitSuggestion.addActionListener(main);
    }
    
    public void display(JFrame frame){
        Color textCol = MainClass.getBare(frame);
        
        Font font = new Font("Arial", 10, 30);
         
        profTitle.setForeground(textCol);
        polTitle.setForeground(textCol);
        newsTitle.setForeground(textCol);
        subTitle.setForeground(textCol);
        outTitle.setForeground(textCol);
        viewTitle.setForeground(textCol);
         
        profTitle.setFont(font);
        polTitle.setFont(font);
        newsTitle.setFont(font);
        subTitle.setFont(font);
        outTitle.setFont(font);
        viewTitle.setFont(font);
        
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 10;
        frame.add(viewSuggestions, c);
        c.gridy = 0;
        frame.add(viewTitle, c);
        
        c.gridy = 3;
        frame.add(viewNews, c);
        c.gridy = 2;
        frame.add(newsTitle, c);
        
        c.gridx = 1;
        c.gridy = 1;
        frame.add(submitSuggestion, c);
        c.gridy = 0;
        frame.add(subTitle, c);
        
        c.gridy = 3;
        frame.add(viewPolicy, c);
        c.gridy = 2;
        frame.add(polTitle, c);
        
        c.gridx = 2;
        c.gridy = 1;
        frame.add(editProfile, c);
        c.gridy = 0;
        frame.add(profTitle, c);
        
        c.gridy = 3;
        frame.add(logOut, c);
        c.gridy = 2;
        frame.add(outTitle, c);
        
    }
    
}
