/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Charlie Hands
 */
public class EmailNotEnteredException extends Exception{
    /**
     * Creates a EmailNotEnteredException without a detail message.
     */
    public EmailNotEnteredException(){}
    
     /**
     * Constructs a EmailNotEnteredException with the specified 
     * detail message.
     * @param msg the detail message.
     */
    public EmailNotEnteredException(String msg){
        super(msg);
    }
}
