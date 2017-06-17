
package exceptions;

/**
 *
 * @author Adam Whittaker
 *
 * This is an Exception for picking up missing passwords/users.
 */
public class PasswordNotFoundException extends Exception{

    /**
     * Creates a PasswordNotFoundException without a detail message.
     */
    public PasswordNotFoundException(){}

    /**
     * Constructs a PasswordNotFoundException with the specified 
     * detail message.
     * @param msg the detail message.
     */
    public PasswordNotFoundException(String msg){
        super(msg);
    }
}
