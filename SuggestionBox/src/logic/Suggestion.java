
package logic;

import java.io.Serializable;

/**
 *
 * @author Adam Whittaker
 * 
 * This class handles the storage, addition and deletion of suggestions.
 */
public class Suggestion implements Serializable{
    
    private static final long serialVersionUID = 3;
    
    //Variable declaration
    protected String suggestion;
    protected String author;
    protected int upvotes = 0;
    
    
    //Constructors
    
    public Suggestion(String sugg, String auth, int vot){
        suggestion = sugg;
        author = auth;
        upvotes = vot;
    }
    
    public Suggestion(String sugg, String auth){
        suggestion = sugg;
        author = auth;
    }
    
    
    //Methods
    
    /**
     * Prints the suggestion and a new line.
     */
    public void println(){
        System.out.println(author + " suggested: " + suggestion);
    }

    /**
     * Prints the suggestion.
     */
    public void print(){
        System.out.print(author + " suggested: " + suggestion);
    }
    
    /**
     * Increments the upvote counter.
     */
    public void upvote(){
        upvotes++;
    }
    
}
