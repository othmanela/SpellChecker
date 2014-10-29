package spellchecker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DictionaryTest {

  public static void main(String[] args){
        try {
            Dictionary test = new Dictionary("/home/simo/NetBeansProjects/SpellChecker/src/spellchecker/smallDictionary.txt");
            
            System.out.println(test.getNumWords());
            
            System.out.println(test.isWord("TEN"));
            System.out.println(test.isWord("tEn"));
            System.out.println(test.isWord("TeN"));
            
            
           
            FileCorrector f = new FileCorrector("/home/simo/NetBeansProjects/SpellChecker/src/spellchecker/smallMisspellings.txt");
           
            Enumeration e = f.getCorrections("lyon").elements();
            while(e.hasMoreElements()){                
                System.out.println(e.nextElement());
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(DictionaryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      
      
  }
  
}
