
package logic;

import exceptions.UnsanitaryEntryException;

/**
 *
 * @author Adam Whittaker
 * 
 * This class handles input sanitation and prevents inputs that could corrupt 
 * data.
 */
public class Sanitiser{
    
    
    public static void sanitiseUser(String concat) throws UnsanitaryEntryException{
        if(concat.contains("<username>")||concat.contains("</username>")||
                concat.contains("<pass>")||concat.contains("</pass>")||
                concat.contains("<status>")||concat.contains("</status>")||
                concat.contains("<email>")||concat.contains("</email>")||
                concat.contains("<desc>")||concat.contains("</desc>")||
                concat.contains("/EndOfEntry")) throw new
            UnsanitaryEntryException("Your profile could corrupt the storage of"
                    + " users.");
    }
    
    public static void sanitiseSuggestion(String concat) throws UnsanitaryEntryException{
        if(concat.contains("<suggestion>")||concat.contains("</suggestion>")||
                concat.contains("<author>")||concat.contains("</author>")||
                concat.contains("<votes>")||concat.contains("</votes>")||
                concat.contains("/EndOfEntry")) throw new
            UnsanitaryEntryException("Your profile could corrupt the storage of"
                    + " suggestions.");
    }
            
}
