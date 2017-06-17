
package logic;

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
    protected ArrayList<User> userList;
    protected File storageFile;
    
    
    //Constructor
    
    /**
     * @param f The File that stores the user profiles.
     */
    public UserLog(File f){
        storageFile = f;
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
     */
    protected void pull(){
    
    }
    
    /**
     * Writes user profiles from ArrayList to File.
     */
    protected void push(){
    
    }
    
}
