
package logic;

import exceptions.PasswordNotFoundException;
import exceptions.PasswordUnsafeException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 *
 * @author Adam Whittaker
 *
 * this class holds hashed passwords.
 * @unfinished
 * @untested
 */
public class PasswordHolder{
    
    
    //Variable declaration
    protected HashMap<String, String> userHashes = new HashMap<>();
    protected static ReadWrite rw;
    
    //Sorting interface allows lambdas to by given as parameters.
    protected interface Sort{
        //Abstract method. E.g: String -> boolean
        boolean select(String str);
    }
    
    //Constructors
    
    /**
     * @param str The name of the file that contains the user profiles.
     */
    public PasswordHolder(String str){
        rw = new ReadWrite(str);
    }
    
    /**
     * @param f The File that contains the user profiles.
     */
    public PasswordHolder(File f){
        rw = new ReadWrite(f);
    }
    
    
    //Utility Methods
    
    /**
    * Takes passwords stored in a file and puts them in userHashes.
    */
    protected void pull(){
        String saves = rw.read();
        String segments[] = saves.split("/EndOfEntry");
        try{
            for(String seg : segments){
                String user = seg.substring(seg.indexOf("<user>")+6, 
                        seg.indexOf("</user>"));
                String pass = seg.substring(seg.indexOf("<pass>")+6,
                        seg.indexOf("</pass>"));
                userHashes.put(user, pass);
            }
        } catch(StringIndexOutOfBoundsException ignore){}
        //Because the /EndOfEntry tag is written at the end of each entry, the
        //segments array contains an empty String at the last index. This causes
        //the Exception because there are no <user> or <pass> tags.
    }
    
    /**
    * Puts the user passwords stored in userHashes into a file.
    */
    protected void push(){
        userHashes.entrySet().stream().forEach(entry ->{
            String user = entry.getKey();
            String hashpass = entry.getValue();
            rw.write("<user>"+user+"</user>\n<pass>"+hashpass+"</pass>\n"
                    + "/EndOfEntry\n");
        });
    }
    
    /**
    * Checks if the given password is safe.
    * @param p The password to be checked.
    * @throws PasswordUnsafeException to be caught if password is unsafe.
    */
    protected static void sanitise(String p) throws PasswordUnsafeException{
        if(p.length()<8||p.length()>16) throw new PasswordUnsafeException(
                "Password must be between 8 and 16 characters in length.");
        String whitelist = "1234567890qwertyuiopasdfghjklzxcvbnm.<>!{}?-_+ ";
        //whitelist can't be any longer to protect against SQL injections.
        String spec = ".<>!{}?-_+ ";
        boolean containsUpperCase = false, containsNum = false, containsSpec = false;
        for(int n=0;n<p.length();n++){
            if(!whitelist.contains((""+p.charAt(n)).toLowerCase())) throw new PasswordUnsafeException(
                    "Password contains illegal character: " + p.charAt(n));
            if(!containsUpperCase&&Character.isUpperCase(p.charAt(n)))
                containsUpperCase = true;
            if(!containsNum&&Character.isDigit(p.charAt(n)))
                containsNum = true;
            if(!containsSpec&&!spec.contains(""+p.charAt(n)))
                containsSpec = true;
        }
        if(!containsSpec||!containsNum||!containsUpperCase)
            throw new PasswordUnsafeException("Password must contain numbers, "
                    + "uppercase characters and special characters.");
        //Throwing Exceptions instead of returning a boolean allows for custom
        //return messages and exits the method.
    }
    
    
    //Class Methods
    
    /**
    * Hashes password to protect from theft. 
    * @throws UnsupportedEncodingException Never thrown, just required for method.
    * @throws NoSuchAlgorithmException Never thrown, just required for method.
    * @param str The String to be hashed.
    * @return The hashed password.
    */
    protected static String hash(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes("UTF-8"));
        byte[] digest = md.digest();
        return String.format("%064x", new java.math.BigInteger(1, digest));
    }

    /**
     * Checks if the given user has the given password.
     * @param user The user to check the password of.
     * @param password The password entered.
     * @throws exceptions.PasswordNotFoundException If there was is a failure to
     * check the password or it is incorrect.
     */
    protected void passwordValidation(String user, String password) throws PasswordNotFoundException{
        try{
            //Storing the userHashes.get(user) in a temporary String is more
            //efficient because searching a massive HashMap twice is impractical.
            String temp = userHashes.get(user);
            if(temp==null) throw new PasswordNotFoundException("Username " + 
                    user + " does not exist.");
            if(!temp.equals(hash(password))) throw new PasswordNotFoundException(
            "Incorrect password.");
        }catch(UnsupportedEncodingException | NoSuchAlgorithmException ignore){}
        //The method requires a try-catch block to catch the above exceptions
        //but since the hash function is always SHA-256 it will never throw them.
    }
    
    /**
     * Adds a new user.
     * @param userName The username of the user.
     * @param password The password of the user.
     * @throws exceptions.PasswordUnsafeException If the given password is 
     * unsafe.
     */
    protected void newUser(String userName, String password) throws PasswordUnsafeException{
        try {
            sanitise(password);
            userHashes.put(userName, hash(password));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ignore){}
    }
    
    /**
     * Displays all users and their hashed passwords where the given lambda 
     * returns true.
     * @param sort The lambda expression that determines whether to display the
     * password.
     */
    protected void displayAll(Sort sort){
        userHashes.entrySet().stream().forEach(entry -> {
            String user = entry.getKey();
            String hashpass = entry.getValue();
            if(sort.select(user)) System.out.println("Username: " + user + 
                    "\nHashed password: " + hashpass + "\n");
        });
    }
    
    /**
     * Displays all users and their hashed passwords.
     */
    protected void displayAll(){
        userHashes.entrySet().stream().forEach(entry -> {
            String user = entry.getKey();
            String hashpass = entry.getValue();
            System.out.println("Username: " + user + 
                    "\nHashed password: " + hashpass + "\n");
        });
    }
    
    
    //Only debugging
    protected static void main(String args[]) throws NoSuchAlgorithmException, UnsupportedEncodingException, PasswordUnsafeException{
        //System.out.println("Type the file path to get the stored passwords from...");
        //rw = new ReadWrite(scan.nextLine());
        //pull();
        //displayAll();
    }
    
}
