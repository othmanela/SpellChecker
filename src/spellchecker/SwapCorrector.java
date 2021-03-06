package spellchecker;


import java.util.Set;
import java.util.Vector;
/**
 * A Corrector whose spelling suggestions come from "swapped letter" typos.
 * <p>
 * A common misspelling is accidentally swapping two adjacent letters, e.g.
 * "with" -> "wiht". This Corrector is given a Dictionary of valid words and
 * proposes corrections that are precisely one "swap" away from the incorrect
 * word.
 * <p>
 * For example, if the incorrect word is "haet", then this Corrector might
 * suggest "heat" and "hate", provided that both of these words occur in the
 * dictionary.
 * <p>
 * Only swaps between adjacent letters are considered by this corrector.
 */
public class SwapCorrector extends Corrector {
    private final Dictionary dict;

  /**
   * Constructs a SwapCorrector instance using the given Dictionary.
   * Should throw an <code>IllegalArgumentException</code> if the Dictionary
   * provided is null.
   *
   * @param dict the reference dictionary to use to look for
   *   corrections arising from letter swaps
   */
  public SwapCorrector(Dictionary dict) {
        if(dict==null)
            throw new IllegalArgumentException("Dictionary is null");
        this.dict = dict;
  }

  /**
   * Suggests as corrections any words in the Dictionary (provided when the
   * object is constructed) that are one swap away from the input word. A swap
   * is defined as two adjacent letters exchanging positions.
   * <p>
   * For example, if the dictionary contains the word "heat" and "hate", then
   * both should be returned if the input word is "haet".
   * <p>
   * The input word (regardless of whether it itself is in the Dictionary or
   * not) should never appear in the result set.
   * <p>
   * See superclass documentation for more information.
   *
   * @param wrong the input word
   */
  public Vector<String> getCorrections(String wrong) {
      
      Vector<String> wrong_corrections = new Vector<String>();
      
      for(int i = 0; i < wrong.toCharArray().length - 1; i++){
          char[] tab = wrong.toCharArray();
          char tmp  = tab[i];
          tab[i]    = tab[i+1];
          tab[i+1]  = tmp;
          String test = "";
          for(int j=0; j < tab.length; j++) {
              test+=tab[j];
          }
          if(this.dict.isWord(test)){
              wrong_corrections.addElement(test);
          }
      }
      
    return this.matchCase(wrong, wrong_corrections);
  }
}
