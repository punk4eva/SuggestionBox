
package logic;

import exceptions.PasswordUnsafeException;
import exceptions.UnsanitaryEntryException;
import exceptions.UserAlreadyExistsException;
import exceptions.EmailNotEnteredException;
import java.io.File;
import java.util.ArrayList;

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
    public ArrayList<User> userList = new ArrayList<>();
    private final File storageFile = new File("users.txt");
    
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
    public boolean containsUsername(int start /**Always at 0*/, String un){
        int uComp = userList.get(start).username.compareTo(un);
        if(uComp==0) return true;
        else if(start == userList.size()-1||uComp<0) return false;
        return containsUsername(start+1, un);
    }
    
    public User get(String usnm) throws Exception{
        for(User user : userList){
            if(usnm.equals(user.username)) return user;
        }
        throw new Exception("User "+usnm+" not found.");
    }
    
    /**
     * Pulls user profiles from storage.
     * @potentiallyUnfinishedAlthoughICantFindAnyErrors
     */
    private void pull(){
        String[] segments = 
                new ReadWrite(storageFile).read().split("/EndOfEntry");
        try{
            for(String seg : segments){
                String name = seg.substring(
                        seg.indexOf("<username>")+10, seg.indexOf("</username>"));
                String hPass = seg.substring(
                        seg.indexOf("<pass>")+6, seg.indexOf("</pass>"));
                String email = seg.substring(
                        seg.indexOf("<email>")+7, seg.indexOf("</email>"));
                String desc = seg.substring(
                        seg.indexOf("<desc>")+6, seg.indexOf("</desc>"));
                String stat = seg.substring(
                        seg.indexOf("<status>")+8, seg.indexOf("</status>"));
                String type = seg.substring(
                        seg.indexOf("<type>")+6, seg.indexOf("</type>"));
                User user = new User(name, hPass, email, desc, 
                        User.AccountType.valueOf(type));
                user.changeStatus(stat);
                add(user);
            }
        }catch(StringIndexOutOfBoundsException e){
            //The exception is thrown at the end of the for-loop as the last
            //'/EndOfEntry' tag creates an empty String.
        }
    }
    
    /**
     * Writes user profiles from ArrayList to File.
     */
    public void push(){
        ReadWrite rw = new ReadWrite(storageFile);
        rw.clear();
        userList.stream().map(u -> {
            rw.write("<username>"+u.username+"</username><pass>"+
                    u.hashedPassword+"</pass><status>"+u.statMessage.toString()+
                    "</status><desc>"+u.description+"</desc><email>"+
                    u.emailAddress+"</email><type>"+u.accountType.toString()+
                    "</type>");
            return u;
        }).forEach(ignore -> {
            rw.write("/EndOfEntry");
        });
    }
    
    /**
     * Adds the given User to the userList.
     * @param user The user to be added.
     */
    protected void add(User user){
        userList.add(user);
        push();
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
        Sanitiser.sanitiseUser(un+pass+em);
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
