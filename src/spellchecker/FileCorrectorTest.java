/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simo
 */
public class FileCorrectorTest {
    
    
      public static void main(String[] args){
        try {      
            
           
            FileCorrector f = new FileCorrector("/home/simo/NetBeansProjects/SpellChecker/src/spellchecker/smallMisspellings.txt");
           
            Enumeration e = f.getCorrections("Lyon").elements();
            while(e.hasMoreElements()){                
                System.out.println(e.nextElement());
            }
            
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
      
      
  }
    
}
