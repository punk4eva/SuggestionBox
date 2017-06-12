
package logic;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.Animation.Status;

/**
 *
 * @author Adam Whittaker
 */
public class User{
    
    
    protected String username;
    protected String hashedPassword;
    protected String emailAddress;
    protected int userNum;
    protected Status statMessage = Status.OK;
    protected String description = "";
    protected ArrayList<Integer> suggestionsList;
    
    protected enum Status{
        HAPPY, OK, SAD, STRESSED, BORED, ANGRY
    }
    
    
    public User(int num, String un, String pw, String email, String desc){
        userNum = num;
        username = un;
        try {
            hashedPassword = PasswordHolder.hash(pw);
        }catch(UnsupportedEncodingException | NoSuchAlgorithmException ignore){}
        emailAddress = email;
        description = desc;
    }
    
    public User(int num, String un, String pw, String email){
        userNum = num;
        username = un;
        try {
            hashedPassword = PasswordHolder.hash(pw);
        }catch(UnsupportedEncodingException | NoSuchAlgorithmException ignore){}
        emailAddress = email;
    }
    
    
    protected void print(){
        System.out.print("User: " + username + "\nEmail: " + emailAddress);
    }
    protected void println(){
        System.out.println("User: " + username +"\nEmail: " + emailAddress);
    }
    protected void printexd(){
        println();
        System.out.println("User Number: " + userNum + "\nDescription: " 
                + description);
    }
    
    protected void changeStatus(String s){
        statMessage = Status.valueOf(s.toUpperCase());
    }
    
    protected void changeDesc(String d){
        description = d;
    }
    
    protected void changeEmail(String e){
        emailAddress = e;
        validateEmail();
    }
    
    //unfinished
    protected void validateEmail(){
        while(true){
            Random r = new Random();
            ArrayList<String> to = new ArrayList<>();
            to.add(emailAddress);
            String a = Integer.toHexString(r.nextInt(256));
            String b = Integer.toHexString(r.nextInt(256));
            String c = Integer.toHexString(r.nextInt(256));
            if(a.length()<2) a = "0"+a;
            if(b.length()<2) b = "0"+b;
            if(c.length()<2) c = "0"+c;
            String code = a + b + c;
            MailManager.send("SuggestionBox Email Validation",
                    "Please validate your email, the code is " + code,
                    "suggestionbox31@gmail.com", to);
            /**
            String input = SomeJFrameClass.inputCode();
            if(input==code) break;
            (ask whether to resend email) MailManager.send("SuggestionBox Email Validation",
                    "Please validate your email, the code is " + code,
                    "suggestionbox31@gmail.com", to);
            etc.
            **/
        }
    }
    
}
