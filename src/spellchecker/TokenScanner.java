package spellchecker;


import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides a Token Iterator for a given Reader.
 * <p>
 * Hint: See the code for the WordScanner from Lecture.
 *
 * @see Token
 */
public class TokenScanner implements Iterator<Token> {
    private Token token;
    private Reader reader;
    private boolean testInit;
    private int restChar ;

  /**
   * Creates a TokenScanner for a given Reader.
   * <p>
   * As an Iterator, the TokenScanner should only read from the Reader as much
   * as is necessary to determine getNext() and next(). The TokenScanner should
   * NOT read the entire stream and compute all of the Tokens in advance.
   * <p>
   * If the provided Reader is null, you may throw an <code>IllegalArgumentException</code>.
   *
   * @param in the source Reader for character data
   * @throws IOException
   */
  public TokenScanner(java.io.Reader in) throws IOException {
      if(in == null){
          throw new IllegalArgumentException("The provided Reader is null");
      }
      this.reader = in;
      testInit = true;
      
      restChar = reader.read();
      
      this.read();
      
    
    
     
  }

  /**
   * Determines whether a given character is a valid word character.
   * <p>
   * Valid word characters are letters (according to
   * Character.isLetter) and single quote '\''.
   *
   * @param c the character to check
   * @return true if the character is a word character
   */
  public boolean isWordCharacter(int c) {
      
      boolean test = Character.isLetter(c);
      
      if(test == false && (((char) c)=='\'')){
          test = true;
      }
      
    return test;
  }

  private void read() throws IOException{
      int data = this.restChar;
      
      if(data == -1) {
          this.token = null;
      }
      else{
          
          String token_string="";
          
          if(!this.isWordCharacter(data)){
              
                while(data != -1 && !this.isWordCharacter(data)){                
                    char dataChar = (char) data;
                    token_string+=dataChar;
                    data = reader.read();
                }
                this.restChar = data;  
                this.token=new Token(false,token_string);
          }
          else{
              
                while(data != -1 && this.isWordCharacter(data)){                
                    char dataChar = (char) data;
                    token_string+=dataChar;
                    data = reader.read();
                }
                this.restChar = data;  
                this.token=new Token(true,token_string);
              
          }
          
            
          
      }
  }
  
  
  /**
   * Determines whether there is another token available.
   */
  public boolean hasNext() {
    return (token!=null) ;
  }

  /**
   * Returns the next token, or throws a NoSuchElementException if none remain.
   */
  public Token next() {
    
      if(this.testInit) {
          this.testInit =false;
          return token;          
      }
      else{
          try {
              this.read();
          } catch (IOException ex) {
              Logger.getLogger(TokenScanner.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    
      return token;
    
  }

  /**
   * We don't support this functionality with TokenScanner, but since
   * the method is required if implementing Iterator, we just
   * <code>throw new UnsupportedOperationException();</code>
   */
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
