
package logic;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Adam Whittaker
 */
public class UserLog{
    
    
    protected ArrayList<User> userList;
    protected File storageFile;
    
    
    public UserLog(File f){
        storageFile = f;
        pull();
    }
    
    
    public boolean containsUsername(int start /**Always at 0*/, String un){
        int uComp = userList.get(start).username.compareTo(un);
        if(uComp==0) return true;
        else if(start == userList.size()-1||uComp<0) return false;
        return containsUsername(start+1, un);
    }
    
    public void pull(){
    
    }
    
    public void push(){
    
    }
    
}
