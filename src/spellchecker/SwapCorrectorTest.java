/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;

import java.io.IOException;
import java.util.Enumeration;

/**
 *
 * @author simo
 */
public class SwapCorrectorTest {
    
    
    public static void main(String[] args){
        try {      
            
           Dictionary test = new Dictionary("/home/simo/NetBeansProjects/SpellChecker/src/spellchecker/smallDictionary.txt");
            
            System.out.println(test.getNumWords());
            
            SwapCorrector f = new SwapCorrector(test);
           
            Enumeration e = f.getCorrections("Bye").elements();
            while(e.hasMoreElements()){                
                System.out.println(e.nextElement());
            }
            
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    
    }
}
