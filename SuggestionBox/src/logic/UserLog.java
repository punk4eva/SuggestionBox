
package logic;

import exceptions.PasswordUnsafeException;
import exceptions.UnsanitaryEntryException;
import exceptions.UserAlreadyExistsException;
import exceptions.EmailNotEnteredException;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Adam Whittaker
 * 
 * This class handles the storage, addition and deletion of user profiles.
 * @unfinished
 * @untested
 */
public class UserLog implements Serializable{
    
    private static final long serialVersionUID = 0;
    
    //Variable declaration
    public List<User> userList = new ArrayList<>();
    
    //Interface allows lambda expressions to be given as parameters.
    protected interface Sort{
        boolean select(User user);
    }
    
    
    private UserLog(){}
    
    
    //Methods
    
    /**
     * Checks whether the given username exists.
     * @param start Recursive counter always initialized at zero.
     * @param un The username to be checked.
     * @return true if the user exists and false otherwise.
     */
    public boolean containsUsername(int start /**Always at 0*/, String un){
        int uComp = userList.get(start).username.compareTo(un);
        if(uComp==0) return true;
        else if(start == userList.size()-1||uComp<0) return false;
        return containsUsername(start+1, un);
    }
    
    /**
     * Gets the User with the given username.
     * @param usnm The username.
     * @return The user.
     * @throws Exception If the username doesn't exist.
     */
    public User get(String usnm) throws Exception{
        for(User user : userList){
            if(usnm.equals(user.username)) return user;
        }
        throw new Exception("User "+usnm+" not found.");
    }
    
    
    
    /**
     * Serializes this object.
     */
    public void serialize(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("users.ser")))){
            out.writeObject(this);
        }catch(IOException e){
            e.printStackTrace(System.err);
        }
    }
    
    /**
     * Deserializes this Object.
     * @return The Object.
     */
    public static UserLog getInstance(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("users.ser")))){
            return (UserLog) in.readObject();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    /**
     * Adds the given User to the userList.
     * @param user The user to be added.
     */
    protected void add(User user){
        userList.add(user);
    }
    
    /**
     * Adds a new user to the userList.
     * @param un The username of the user.
     * @param pass The password of the user.
     * @param em The user's email.
     * @throws exceptions.UserAlreadyExistsException If the username already exists.
     * @throws exceptions.PasswordUnsafeException  If the password is easily breakable.
     * @throws exceptions.UnsanitaryEntryException If the profile contains dangerous text.
     * @throws exceptions.EmailNotEnteredException If at Email is not entered.
     */
    public void newUser(String un, String pass, String em) throws UserAlreadyExistsException, PasswordUnsafeException, UnsanitaryEntryException, EmailNotEnteredException{
        if(em.equals("")) throw new EmailNotEnteredException("Please enter your email.");
        PasswordHolder.sanitise(pass);
        for(User user : userList) if(user.username.equals(un)) throw new
            UserAlreadyExistsException("User " + un + " already exists.");
        add(new User(un, PasswordHolder.hash(pass), em));
    }
    
    /**
     * Displays all Users in the UserLog where the given expression returns 
     * true.
     * @param sort The lambda expression to be evaluated for each user.
     */
    public void displayAll(Sort sort){
        userList.stream().filter(user -> sort.select(user)).map(user -> {
            user.println();
            return user;
        }).forEach(ignore -> {
            System.out.println();
        });
    }
    
    /**
     * Displays all Users in userList.
     */
    public void displayAll(){
        userList.stream().map(user -> {
            user.println();
            return user;
        }).forEach(ignore -> {
            System.out.println();
        });
    }
    
    /**
     * Displays all User's extended profiles where the given expression returns 
     * true.
     * @param sort The lambda expression to be evaluated.
     */
    public void displayAllExd(Sort sort){
        userList.stream().filter(user -> sort.select(user)).map(user -> {
            user.printexd();
            return user;
        }).forEach(ignore -> {
            System.out.println();
        });
    }
    
    /**
     * Displays all User's extended profiles.
     */
    public void displayAllExd(){
        userList.stream().map(user -> {
            user.printexd();
            return user;
        }).forEach(ignore -> {
            System.out.println();
        });
    }
    
}
