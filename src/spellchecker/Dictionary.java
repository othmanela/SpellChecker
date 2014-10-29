package spellchecker;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * A dictionary manages a collection of known, correctly-spelled words.
 */
public class Dictionary {

  /**
   * Constructs a dictionary from words contained in a given file.
   * <p>
   * Blank lines or lines containing only whitespace should be
   * ignored. Each (non-blank) line of the file will contain one word.
   * For the dictionary, a word is any sequence of non-whitespace
   * characters.  You should remove any leading or trailing whitespace
   * around the word. (For this last condition, you will want to check
   * the String Javadocs).
   * <p>
   * The constructor should read the file, store the file contents in
   * memory, and then close the file.  It should throw an
   * <code>IllegalArgumentException</code> if the String filename
   * provided is null.
   *
   * @param filename a path of a dictionary file
   * @throws IOException if error reading the file
   */
    
    private Vector<String> words;
    
  public Dictionary(String filename) throws IOException {
  
      if(filename == null) {
          throw new IllegalArgumentException("Filename is null");
      }
      else
      {
            this.words = new Vector<String>();
            String line;
            BufferedReader BR = new BufferedReader(new FileReader(filename));
            while ((line = BR.readLine()) != null){ 
                line=line.trim();
                if(line.compareTo("")!=0 && line.compareTo(" ")!=0 && (!this.words.contains(line.toLowerCase()))){
                    this.words.addElement(line);
                }
            }  
            BR.close(); 
      }
      
        
      
  }

  /**
   * Returns the number of unique words in this dictionary. This count is
   * case insensitive: if both "DOGS" and "dogs" appeared in the file, it
   * should only be counted once in the returned sum.
   * 
   * @return number of unique words in the dictionary
   */
  public int getNumWords() {
  	return this.words.size();
  }

  /**
   * Test whether the input word is present in the Dictionary.
   * <p>
   * This check should be case insensitive.  For example, if the
   * Dictionary contains "dog" or "dOg" then isWord("DOG") should return true.
   * <p>
   * The null string is not in the dictionary.
   * <p>
   * Calling this method should not re-open or re-read the source file.
   *
   * @param word a string token to check. Assume any leading or trailing
   *    whitespace has already been removed.
   * @return whether the word is in the dictionary
   */
  public boolean isWord(String word) {
    return this.words.contains(word.toLowerCase());
  }
}
