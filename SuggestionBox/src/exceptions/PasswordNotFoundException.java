
package exceptions;

/**
 *
 * @author Adam WHittaker
 */
public class PasswordNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>PasswordNotFoundException</code> without
     * detail message.
     */
    public PasswordNotFoundException(){}

    /**
     * Constructs an instance of <code>PasswordNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordNotFoundException(String msg){
        super(msg);
    }
}
