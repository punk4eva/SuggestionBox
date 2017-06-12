
package logic;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Whittaker
 */
public class ReadWrite{
    
    public static FileReader read;
    public static FileWriter write;
    private static Scanner scan = new Scanner(System.in);
    public File file;
    
    public ReadWrite(String f){
        if(!f.endsWith(".txt")) file = new File(f+".txt");
        else file = new File(f);
    }
    
    public ReadWrite(File f){
        file = f;
    }
    
    
    public void create(){
        try{
	      if(file.createNewFile()) System.out.println("File is created!");
              else System.out.println("File already exists.");
    	}catch(IOException e){
            System.out.println("Error creating file.");
	}
    }
    
    public String read(){
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
    
    public void write(){
        try{
            String s = read();
            write = new FileWriter(file);
            boolean run = true;
            write.append(s);
            while(run){
                String text = scan.nextLine();
                if(!text.equals("/exit")) write.append(text + "\n");
                else run = false;
            }
            write.flush();
            write.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void write(String str){
        try{
            String s = read();
            write = new FileWriter(file);
            write.append(s);
            write.append(str+"\n");
            write.flush();
            write.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void clear(){
        try {
            write = new FileWriter(file);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String [] args) {
        //debugging
    }
}
