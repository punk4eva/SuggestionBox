
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Charlie Hands
 */
public class Homepage{
    
    GridBagConstraints c;
    JButton editProfile;
    JButton submitSuggestion;
    JButton viewSuggestions;
    JButton viewPolicy;
    JButton viewNews;
    JButton logOut;
    JLabel profTitle;
    JLabel subTitle;
    JLabel viewTitle;
    JLabel polTitle;
    JLabel newsTitle;
    JLabel outTitle;
    
    /**
     * Initializes all the components.
     * @param main The MainClass whose ActionListener to add.
     * @unfinished
     */
    public Homepage(MainClass main){
        editProfile = new JButton(new ImageIcon()); //TO COMPLETE
        editProfile.setOpaque(false);
        editProfile.setContentAreaFilled(false);
        editProfile.setBorderPainted(false);
        editProfile.setActionCommand("Edit Profile");
        editProfile.setVisible(true);
        submitSuggestion = new JButton(new ImageIcon()); //TO COMPLETE
        submitSuggestion.setOpaque(false);
        submitSuggestion.setContentAreaFilled(false);
        submitSuggestion.setBorderPainted(false);
        submitSuggestion.setActionCommand("Submit Suggestion");
        viewSuggestions = new JButton(new ImageIcon()); //TO COMPLETE
        viewSuggestions.setOpaque(false);
        viewSuggestions.setContentAreaFilled(false);
        viewSuggestions.setBorderPainted(false);
        viewSuggestions.setActionCommand("View Suggestions"); //TO COMPLETE
        viewPolicy = new JButton(new ImageIcon());
        viewPolicy.setOpaque(false);
        viewPolicy.setContentAreaFilled(false);
        viewPolicy.setBorderPainted(false);
        viewPolicy.setActionCommand("View Policy");
        viewNews = new JButton(new ImageIcon()); //TO COMPLETE
        viewNews.setOpaque(false);
        viewNews.setContentAreaFilled(false);
        viewNews.setBorderPainted(false);
        viewNews.setActionCommand("View News");
        logOut = new JButton(new ImageIcon("images/intellectualFace.png"));
        logOut.setOpaque(false);
        logOut.setContentAreaFilled(false);
        logOut.setBorderPainted(false);
        logOut.setActionCommand("Log Out");
        c = new GridBagConstraints();
        profTitle = new JLabel("View Profile");
        polTitle = new JLabel("View Policies");
        newsTitle = new JLabel("View News");
        subTitle = new JLabel("Submit a Suggestion");
        outTitle = new JLabel("Log out");
        viewTitle = new JLabel("View Suggestions");
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
        c.gridwidth = GridBagConstraints.RELATIVE;
        frame.add(logOut, c);
        
        c.gridy = 0;
        frame.add(outTitle,c);
    }
}
