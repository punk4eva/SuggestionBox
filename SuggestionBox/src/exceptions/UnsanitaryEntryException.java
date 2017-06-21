
package exceptions;

/**
 *
 * @author Adam Whittaker
 * 
 * This exception is for picking up potentially dangerous user input.
 */
public class UnsanitaryEntryException extends Exception{

    /**
     * Creates a new instance of UnsanitaryEntryException without
     * detail message.
     */
    public UnsanitaryEntryException(){
    }

    /**
     * Constructs an instance of UnsanitaryEntryException with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnsanitaryEntryException(String msg){
        super(msg);
    }
}
