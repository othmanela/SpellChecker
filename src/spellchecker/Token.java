package spellchecker;

/**
 * A piece of text from a document.
 * <p>
 *  A token is either:
 *  <ul>
 *  <li> a word, made up of letters and the apostrophe ' character
 *  <li> a non-word, made of whitespace and other punctuation
 *  </ul>
 * <p>
 * Word tokens are spellchecked, but non-word tokens will be copied directly
 * from the input file into the output file when correcting a document.
 *
 * @see TokenScanner
 */
public class Token {
  private boolean isWord;
  private String tok;

  public Token(boolean initIsWord, String initTok) {
    isWord = initIsWord;
    tok = initTok;
  }

  /**
   *
   * @return true if the token is a word, false if it a non-word
   */
  public boolean isWord() {
    return isWord;
  }

  /**
   *
   * @return the word or non-word String for this token
   */
  public String toString() {
    return tok;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (isWord ? 1231 : 1237);
    result = prime * result + ((tok == null) ? 0 : tok.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Token other = (Token) obj;
    if (isWord != other.isWord)
      return false;
    if (tok == null) {
      if (other.tok != null)
        return false;
    } else if (!tok.equals(other.tok))
      return false;
    return true;
  }

}
