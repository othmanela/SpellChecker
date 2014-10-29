/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simo
 */
public class TokenScannerTest {
    
    
    public static void main(String[] args){
        try {
            Reader reader = new FileReader("/home/simo/NetBeansProjects/SpellChecker/src/spellchecker/smallFile.txt");

            TokenScanner t = new TokenScanner(reader);
           
            while(t.hasNext()){
                System.out.println(t.next());
               // t = new TokenScanner(reader);
            }
            
           
         
            
             
        } catch (IOException ex) {
            Logger.getLogger(TokenScannerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
        
    
}
