
package logic;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adam Whittaker
 * 
 * This class stores user data.
 * @unfinished
 * @untested
 */
public class User{
    
    
    //Variable declaration
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
    
    
    //Constructors

    /**
     * @param num The address of the user.
     * @param un The user's username.
     * @param pw The user's password.
     * @param email The user's email.
     * @param desc the user's description.
     */
    public User(int num, String un, String pw, String email, String desc){
        userNum = num;
        username = un;
        try {
            hashedPassword = PasswordHolder.hash(pw);
        }catch(UnsupportedEncodingException | NoSuchAlgorithmException ignore){}
        emailAddress = email;
        description = desc;
    }
    
    /**
     * @param num The address of the user.
     * @param un The user's username.
     * @param pw The user's password.
     * @param email The user's email.
     */
    public User(int num, String un, String pw, String email){
        userNum = num;
        username = un;
        try {
            hashedPassword = PasswordHolder.hash(pw);
        }catch(UnsupportedEncodingException | NoSuchAlgorithmException ignore){}
        emailAddress = email;
    }
    
    
    //Methods
    
    /**
     * Prints the user's basic information.
     */
    protected void print(){
        System.out.print("User: " + username + "\nEmail: " + emailAddress);
    }
    
    /**
     * Prints the user's basic information and a newline.
     */
    protected void println(){
        System.out.println("User: " + username +"\nEmail: " + emailAddress);
    }
    
    /**
     * Prints the user's extended information.
     */
    protected void printexd(){
        println();
        System.out.println("User Number: " + userNum + "\nDescription: " 
                + description);
    }
    
    /**
     * Changes the user's Status.
     * @param s The user's new status.
     */
    protected void changeStatus(String s){
        statMessage = Status.valueOf(s.toUpperCase());
    }
    
    /**
     * Changes the user's description.
     * @param d The user's new description.
     */
    protected void changeDesc(String d){
        description = d;
    }
    
    /**
     * Changes and validates the user's email.
     * @param e The user's new email.
     */
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
                    "Please validate your email, the code is " + code +
                    ", suggestionbox31@gmail.com", to);
            etc.
            **/
        }
    }
    
}
