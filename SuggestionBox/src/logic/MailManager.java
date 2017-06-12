
package logic;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Adam Whittaker
 */
public class MailManager{
    
    private static String host/** = something**/;
    
    protected static void send(String subject, 
            String message,
            String fromAddress,
            ArrayList<String> toAddresses){
        
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(prop);
        
        try{
            MimeMessage email = new MimeMessage(session);

            email.setFrom(new InternetAddress(fromAddress));

            for(String to : toAddresses)
                email.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            email.setSubject(subject);

            email.setText(message);
            Transport.send(email);
            System.out.println("Sent message successfully");
        }catch(MessagingException mex){
            mex.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        //Debugging: I have already created an email (suqqestionbox31@gmail.com)
        //for the app to use, however I need the host server, so once we obtain 
        //that (mabye it will work on the school computer) then we can test and
        //delete the main() method.
        ArrayList<String> to = new ArrayList<>();
        to.add("adam271828@gmail.com");
        to.add("13HandsC@whsb.essex.sch.uk");
        to.add("adamdw02@hotmail.co.uk");
        send("SuggestionBox Email",
                "The java email system for the suggestion box works!",
                "suggestionbox31@gmail.com", to);
    }
    
}
