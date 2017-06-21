
package logic;

import exceptions.PasswordNotFoundException;
import exceptions.PasswordUnsafeException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Adam Whittaker
 *
 * This class hashes, sanitizes and compares passwords.
 * @untested
 */
public class PasswordHolder{
    
    //Methods
    
    /**
    * Checks if the given password is safe.
    * @param p The password to be checked.
    * @throws PasswordUnsafeException to be caught if password is unsafe.
    */
    protected static void sanitise(String p) throws PasswordUnsafeException{
        //Lower bound: To make passwords harder to crack.
        //Upper bound: Because it looks cool and professional.
        if(p.length()<8||p.length()>16) throw new PasswordUnsafeException(
                "Password must be between 8 and 16 characters in length.");
        String whitelist = "1234567890qwertyuiopasdfghjklzxcvbnm.<>!{}?-_+ ()^@";
        //whitelist can't be any longer to protect against SQL injections.
        String spec = ".<>!{}?-_+ ()^@";
        boolean containsUpperCase = false, containsNum = false, 
                containsSpec = false;
        for(int n=0;n<p.length();n++){
            if(!whitelist.contains((""+p.charAt(n)).toLowerCase())) throw new 
                PasswordUnsafeException("Password contains illegal character: " 
                        + p.charAt(n));
            if(!containsUpperCase&&Character.isUpperCase(p.charAt(n)))
                containsUpperCase = true;
            else if(!containsNum&&Character.isDigit(p.charAt(n)))
                containsNum = true;
            else if(!containsSpec&&spec.contains(""+p.charAt(n)))
                containsSpec = true;
        }
        int points = 0;
        if(containsUpperCase) points++;
        if(containsNum) points++;
        if(containsSpec) points++;
        if(points<2) throw new PasswordUnsafeException("Password must contain "
                + "numbers, uppercase and special characters.");
        if(p.contains("DELETE")||p.contains("SELECT")||p.contains("INSERT")||
                p.contains("ALTER")||p.contains("CREATE")||p.contains("USE")||
                p.contains("SHOW")) throw new PasswordUnsafeException("Password"
                        + " contains forbidden SQL syntax.");
        //Throwing Exceptions instead of returning a boolean allows for custom
        //return messages and exits the method.
    }
    
    /**
    * Hashes password to protect from theft. 
    * @param str The password to be hashed.
    * @return The hashed password.
    */
    protected static String hash(String str){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return String.format("%064x", new java.math.BigInteger(1, digest));
        }catch(UnsupportedEncodingException | NoSuchAlgorithmException e){
            return "Error in hashing!";
        }
    }

    /**
     * Checks if the given username has the given password.
     * @param usr The username to check the password of.
     * @param password The password entered.
     * @param userlst The list of users
     * @throws exceptions.PasswordNotFoundException If the user doesn't exist or
     * the password is incorrect.
     */
    public static void passwordValidation(String usr, String password,
            ArrayList<User> userlst) throws PasswordNotFoundException{
        boolean unchecked = true;
        for(User user : userlst) if(usr.equals(user.username)){
            if(!user.hashedPassword.equals(hash(password))) throw new
                PasswordNotFoundException("Incorrect password for user " + 
                        user.username + ".");
            unchecked = false;
            break;
        }
        if(unchecked) throw new PasswordNotFoundException(
                "User " + usr + " not found!");
    }

}
