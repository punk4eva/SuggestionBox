
package logic;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Adam Whittaker
 * 
 * This class stores suggestion data.
 */
public class SuggestionLog{
    
    
    //Variable declaration
    public ArrayList<Suggestion> suggestionList = new ArrayList<>();
    private final File storageFile = new File("suggestions.txt");
    
    //Interface allows lambda expressions to be given as parameters.
    protected interface Sort{
        boolean select(Suggestion sug);
    }
    
    
    //Constructor
    
    /**
     * Creates a new instance of UserLog.
     */
    public SuggestionLog(){
        pull();
    }
    
    
    //Methods
    
    /**
     * Pulls suggestions from storage.
     * @potentiallyUnfinishedAlthoughICantFindAnyErrors
     */
    private void pull(){
        String[] segments = 
                new ReadWrite(storageFile).read().split("/EndOfEntry");
        try{
            for(String seg : segments){
                String sugg = seg.substring(
                        seg.indexOf("<suggestion>")+12, seg.indexOf("</suggestion>"));
                String auth = seg.substring(
                        seg.indexOf("<author>")+8, seg.indexOf("</author>"));
                int votes = Integer.parseInt(seg.substring(
                        seg.indexOf("<votes>")+7, seg.indexOf("</votes>")));
                add(new Suggestion(sugg, auth, votes));
            }
        }catch(StringIndexOutOfBoundsException e){
            //The exception is thrown at the end of the for-loop as the last
            //'/EndOfEntry' tag creates an empty String.
        }
    }
    
    /**
     * Writes suggestions from ArrayList to File.
     */
    public void push(){
        ReadWrite rw = new ReadWrite(storageFile);
        rw.clear();
        suggestionList.stream().map(s -> {
            rw.write("<suggestion>"+s.suggestion+"</suggestion><author>"+
                    s.author+"</author><votes>"+s.upvotes+
                    "</votes>");
            return s;
        }).forEach(ignore -> {
            rw.write("/EndOfEntry");
        });
    }
    
    /**
     * Adds the given Suggestion to the suggestionList.
     * @param sug The suggestion to be added.
     */
    protected void add(Suggestion sug){
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
