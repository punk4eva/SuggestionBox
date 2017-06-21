
package logic;

import exceptions.PasswordUnsafeException;
import exceptions.UserAlreadyExistsException;
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
                add(new User(name, hPass, email, desc));
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
                    u.emailAddress+"</email>");
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
    }
    
    //UNFINISHED
    /**
     * Adds a new user to the userList.
     * @param un The username of the user.
     * @param pass The password of the user.
     * @param em The user's email.
     */
    public void newUser(String un, String pass, String em){
        try{
            PasswordHolder.sanitise(pass);
            for(User user : userList) if(user.username.equals(un)) throw new
                UserAlreadyExistsException("User " + un + "already exists.");
            add(new User(un, PasswordHolder.hash(pass), em));
        }catch(PasswordUnsafeException | UserAlreadyExistsException ex){
            String errorMessage = ex.getMessage();
            //@charlie display errorMessage and get them to retry.
        }
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
