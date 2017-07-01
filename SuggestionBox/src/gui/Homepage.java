
package gui;

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
    
    }
}
