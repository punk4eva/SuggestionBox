
package logic;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Whittaker
 * 
 * This class handles reading and writing from files.
 * @optimisable
 */
public class ReadWrite{
    
    
    //Variable declaration
    private static FileReader read;
    private static FileWriter write;
    private File file;
    
    
    //Constructors
    
    /**
     * @param f The name of the text file to read/write to.
     */
    public ReadWrite(String f){
        if(!f.endsWith(".txt")) file = new File(f+".txt");
        else file = new File(f);
    }
    
    /**
     * @param f The file to read/write to.
     */
    public ReadWrite(File f){
        file = f;
    }
    
    
    //Methods
    
    /**
     * Creates the file that is stored in the instance of ReadWrite.
     */
    protected void create(){
        try{
	    if(file.createNewFile()) System.out.println("File is created!");
            else System.out.println("File already exists.");
    	}catch(IOException e){
            System.out.println("Error creating file.");
	}
    }
    
    /**
     * Reads the file.
     * @return The text file as a String.
     */
    protected String read(){
        String store = "";
        try{
            read = new FileReader(file);
            while(read.ready()) store += (char) read.read();
            read.close();
        }catch(IOException ex){
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return store;
    }
    
    /**
     * Writes the given String to the file.
     * @param str The String to write.
     */
    protected void write(String str){
        try{
            String s = read();
            write = new FileWriter(file);
            write.append(s);
            write.append(str+"\n");
            write.flush();
            write.close();
        }catch(IOException e){
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Clears the file.
     */
    protected void clear(){
        try{
            write = new FileWriter(file);
            write.close();
        }catch(IOException e){
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
