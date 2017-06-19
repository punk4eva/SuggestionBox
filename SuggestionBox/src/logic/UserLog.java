
package logic;

import exceptions.PasswordNotFoundException;
import exceptions.PasswordUnsafeException;
import exceptions.UserAlreadyExistsException;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Whittaker
 * 
 * This class handles the storage, addition and deletion of user profiles.
 * @unfinished
 * @untested
 */
public class UserLog{
    
    
    //Variable declaration
    protected ArrayList<User> userList;
    protected final File storageFile = new File("users.txt");
    
    //Interface allows lambda expressions to be given as parameters.
    protected interface Sort{
        boolean select(User user);
    }
    
    
    //Constructor
    
    /**
     * Creates a new instance of UserLog.
     */
    public UserLog(){
        pull();
    }
    
    
    //Methods
    
    /**
     * Checks whether the given username exists.
     * @param start Recursive counter always initialized at zero.
     * @param un The username to be checked.
     * @return true if the user exists and false otherwise.
     */
    protected boolean containsUsername(int start /**Always at 0*/, String un){
        int uComp = userList.get(start).username.compareTo(un);
        if(uComp==0) return true;
        else if(start == userList.size()-1||uComp<0) return false;
        return containsUsername(start+1, un);
    }
    
    /**
     * Pulls user profiles from storage.
     * @unfinished
     */
    protected void pull(){
        String[] segments = 
                new ReadWrite(storageFile).read().split("/EndOfEntry");
        for(String seg : segments){
            int num = Integer.parseInt(seg.substring(
                    seg.indexOf("<userNum>")+9, seg.indexOf("</userNum>")));
            String name = seg.substring(
                    seg.indexOf("<username>")+10, seg.indexOf("</username>"));
            String hPass = seg.substring(
                    seg.indexOf("<pass>")+6, seg.indexOf("</pass>"));
            String email = seg.substring(
                    seg.indexOf("<email>")+7, seg.indexOf("</email>"));
            String desc = seg.substring(
                    seg.indexOf("<desc>")+7, seg.indexOf("</desc>"));
            add(new User(num, name, hPass, email, desc));
        }
    }
    
    /**
     * Writes user profiles from ArrayList to File.
     */
    protected void push(){
        ReadWrite rw = new ReadWrite(storageFile);
        rw.clear();
        userList.stream().map(u -> {
            rw.write("<userNum>"+u.userNum+"</userNum>");
            return u;
        }).map(u -> {
            rw.write("<username>"+u.username+"</username>");
            return u;
        }).map(u -> {
            rw.write("<pass>"+u.hashedPassword+"</pass>");
            return u;
        }).map(u -> {
            rw.write("<status>"+u.statMessage.toString()+"</status>");
            return u;
        }).map(u -> {
            rw.write("<desc>"+u.description+"</desc>");
            return u;
        }).map(u -> {
            rw.write("<email>"+u.emailAddress+"</email>");
            return u;
        }).forEach(ignore -> {
            rw.write("/EndOfEntry\n");
        });
    }
    
    /**
     * Adds the given User to the userList.
     * @param user The user to be added.
     */
    protected void add(User user){
        userList.add(user);
    }
    
    //UNFINISHED
    /**
     * Adds a new user to the userList.
     * @param un The username of the user.
     * @param pass The password of the user.
     * @param em The user's email.
     */
    protected void newUser(String un, String pass, String em){
        try{
            PasswordHolder.sanitise(pass);
            for(User user : userList) if(user.username.equals(un)) throw new
                UserAlreadyExistsException("User " + un + "already exists.");
            User newUser = new User(-1/**UNFINISHED*/,
                    un, PasswordHolder.hash(pass), em);
            add(newUser);
        }catch(PasswordUnsafeException | UserAlreadyExistsException ex){
            String errorMessage = ex.getMessage();
            //@charlie display errorMessage and get them to retry.
        }
    }
    
    /**
     * Next time:
     * 1. Add displayAll() methods.
     */
    
}
