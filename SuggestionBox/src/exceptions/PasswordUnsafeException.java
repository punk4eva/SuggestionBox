
package exceptions;

/**
 *
 * @author Adam Whittaker
 *
 * This Exception is for picking up unsafe passwords.
 */
public class PasswordUnsafeException extends Exception{

    /**
     * Creates a PasswordUnsafeException without a detail message.
     */
    public PasswordUnsafeException(){}

    /**
     * Constructs a PasswordUnsafeException with the specified
     * detail message.
     * @param msg the detail message.
     */
    public PasswordUnsafeException(String msg){
        super(msg);
    }
}
