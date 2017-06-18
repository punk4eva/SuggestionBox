
package exceptions;

/**
 *
 * @author Adam Whittaker
 * 
 * This Exception is to pick up any duplicate usernames.
 */
public class UserAlreadyExistsException extends Exception {

    /**
     * Creates a new instance of UserAlreadyExistsException without
     * detail message.
     */
    public UserAlreadyExistsException() {
    }

    /**
     * Constructs an instance of UserAlreadyExistsException with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
