package spellchecker;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

/**
 * A Corrector whose spelling suggestions are given in a text file.
 * <p>
 * One way to get corrections for a misspelled word is to consult an external
 * resource. This kind of Corrector uses a file that contains pairs of
 * misspelled and corrected words to generate suggestions.
 */
public class FileCorrector extends Corrector {

  /**
   * Constructs an instance from the text file supplied. Each line of the file
   * should have a single comma that separates two parts in the form:
   * misspelled_word,corrected_version
   * <p>
   * For example:<br>
   * <pre>
   * aligatur,alligator<br>
   * baloon,balloon<br>
   * inspite,in spite<br>
   * who'ev,who've<br>
   * ther,their<br>
   * ther,there<br>
   * </pre>
   * <p>
   * The lines are not case-sensitive, so all of the following lines should
   * function equivalently:<br>
   * <pre>
   * baloon,balloon<br>
   * Baloon,balloon<br>
   * Baloon,Balloon<br>
   * BALOON,balloon<br>
   * bAlOon,BALLOON<br>
   * </pre>
   * <p>
   * You should ignore any leading or trailing whitespace around the
   * misspelled and corrected parts of each line.  Thus, the following
   * lines should all be equivalent in function:<br>
   * <pre>
   * inspite,in spite<br>
   *    inspite,in spite<br>
   * inspite   ,in spite<br>
   *  inspite ,   in spite  <br>
   * </pre>
   * <p>
   * You should throw an IOException if you encounter input that is
   * invalid.  For example, the FileCorrector constructor may throw
   * an IOException if any of these inputs are encountered:<br>
   * <pre>
   * ,correct<br>
   * wrong,<br>
   * wrong correct<br>
   * wrong,correct,<br>
   * </pre>
   * <p>
   * The constructor should throw an
   * <code>IllegalArgumentException</code> if the String filename
   * provided is null. The source file should be read once in this
   * constructor and then closed. Calls to getCorrections should not
   * re-open or re-read the source file.
   * <p>
   * For methods useful in parsing the lines of the File, see the String class
   * documentation in java.lang.String
   *
   * @param file The name of the corrections file.
   * @throws IOException if error reading file, or file has invalid line
   */
    
    private Hashtable<String,Vector<String>> corrections;
  public FileCorrector(String file) throws IOException {

      if(file == null) {
          throw new IllegalArgumentException("FileCorrector's file name is null");
      }
      else
      {
            this.corrections = new Hashtable<String,Vector<String>>();
            Vector<String> vect;
            String line;
            BufferedReader BR = new BufferedReader(new FileReader(file));
            while ((line = BR.readLine()) != null){ 
                line=line.trim();
                String t[] = line.split(",");
                
                if(t.length!=2){
                    throw new IOException("FileCorrector content not valid 1");
                }
                t[0]=t[0].trim().toLowerCase();
                t[1]=t[1].trim().toLowerCase();
                
                if(t[0].trim().compareTo("")==0 || t[1].trim().compareTo("")==0){
                  throw new IOException("FileCorrector content not valid 2");  
                }
                
                
                if(!this.corrections.containsKey(t[0])){
                    vect = new Vector <String> ();
                    vect.addElement(t[1]);
                    this.corrections.put(t[0],vect);
                }
                else{                    
                    vect = this.corrections.get(t[0]);
                    if(!vect.contains(t[1])){
                        
                        vect.addElement(t[1]);
                        
                    }
                    
                }
                     
                
                
            }  
            BR.close(); 
      }
      
  }

  public Vector<String> getCorrections(String wrong) {
  	return this.matchCase(wrong, this.corrections.get(wrong.trim().toLowerCase()));
  }
}
