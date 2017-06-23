
package logic;

import java.io.File;

/**
 *
 * @author Adam Whittaker
 * 
 * Stores user policies.
 * @seemsToWork
 */
public class PolicyText{
    
    //Variable declaration
    private final File file = new File("policies.txt");
    public String text;
    
    
    //Constructor
    
    /**
     * Creates a new instance of PolicyText.
     */
    public PolicyText(){
        text = interpret(new ReadWrite(file).read());
    }
    
    /**
     * Converts the policy text to a ready-readable format.
     * @return A ready-to-read String.
     * @param txt The text to be interpreted.
     */
    private static String interpret(String txt){
        String mainPolicy = "", line = "", ret = "<html>";
        char[] ary = txt.toCharArray();
        boolean policyMode = true;
        for(char c : ary){
            if(c=='<'){
                ret += "<h6 style="+'"'+"font-face:Times New Roman"+'"'+ ">" + 
                        line + "<h6><br><br>";
                line = "";
                policyMode = true;
            }else if(c=='>'){
                policyMode = false;
                ret += "<h3><u><b>" + mainPolicy + "</b></u></h3><br>";
                mainPolicy = "";
            }else if(Character.isDigit(c)){
                ret += "<h6 style="+'"'+"font-face:Times New Roman"+'"'+">"+line
                        + "<h6><br>";
                line = "";
            }else if(policyMode){
                mainPolicy += c;
            }else{
                line += c;
            }
        }
        return ret;
    }
    
    public static void main(String[] args){
        System.out.println(new PolicyText().text);
    }
    
}
