
package logic;

import exceptions.UnsanitaryEntryException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam Whittaker
 * 
 * This class stores suggestion data.
 */
public class SuggestionLog implements Serializable{
    
    private static final long serialVersionUID = 2;
    
    //Variable declaration
    public List<Suggestion> suggestionList = new ArrayList<>();
    
    //Interface allows lambda expressions to be given as parameters.
    protected interface Sort{
        boolean select(Suggestion sug);
    }
    
    
    //Methods

    /**
     * Serializes this object.
     */
    public void serialize(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("suggestions.ser")))){
            out.writeObject(this);
        }catch(IOException e){
            e.printStackTrace(System.err);
        }
    }
    
    /**
     * Deserializes this Object.
     * @return The Object.
     */
    public static SuggestionLog getInstance(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("suggestions.ser")))){
            return (SuggestionLog) in.readObject();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    /**
     * Adds the given Suggestion to the suggestionList.
     * @param sug The suggestion to be added.
     * @throws exceptions.UnsanitaryEntryException If input could be dangerous.
     */
    protected void add(Suggestion sug) throws UnsanitaryEntryException{
        suggestionList.add(sug);
    }
    
    /**
     * Removes the given Suggestion from the suggestionList.
     * @param sug The Suggestion to be removed.
     */
    protected void remove(Suggestion sug){
        suggestionList.remove(sug);
    }
    
    /**
     * Displays all Suggestions in suggestionList where the given expression 
     * returns true.
     * @param sort The lambda expression to be evaluated for each suggestion.
     */
    public void displayAll(Sort sort){
        suggestionList.stream().filter(sug -> sort.select(sug)).map(sug -> {
            sug.println();
            return sug;
        }).forEach(ignore -> {
            System.out.println();
        });
    }
    
    /**
     * Displays all Suggestions in suggestionList.
     */
    public void displayAll(){
        suggestionList.stream().map(sug -> {
            sug.println();
            return sug;
        }).forEach(ignore -> {
            System.out.println();
        });
    }
    
}
