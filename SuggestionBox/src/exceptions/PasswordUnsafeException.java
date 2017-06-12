
package exceptions;

/**
 *
 * @author Adam Whittaker
 */
public class PasswordUnsafeException extends Exception{

    /**
     * Creates a new instance of <code>PasswordUnsafeException</code> without
     * detail message.
     */
    public PasswordUnsafeException(){}

    /**
     * Constructs an instance of <code>PasswordUnsafeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordUnsafeException(String msg){
        super(msg);
    }
}
