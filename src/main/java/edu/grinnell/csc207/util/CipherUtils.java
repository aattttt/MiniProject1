package edu.grinnell.csc207.util;


/**
 * This class contains all of the functions that get used
 * more than once by Cipher.java and ChipherUtils.java.
 */
public class CipherUtils {

/**
 * This function takes a char named letter and returns that chars corrisponding number.
 * @param letter Any lowercase letter.
 * @return This is a number corrisponding to the letters value in the alphebet.
 */
  public static int letter2int(char letter) {
    int base = (int) 'a';
    return ((int) letter - base);
  } // end method

  /**
   * This takes a string named str and returns true if it contains only lower case letters.
   * @param str any string.
   * @return True or False.
   */
  public static boolean strScrub(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (letter2int(str.charAt(i)) < 0 || letter2int(str.charAt(i)) > letter2int('z')) {
        return false;
      } // end if
    } //end forloop
    return true;
  } // end method

  /**
   * This corrects an int to be properly indexed to the alphabet.
   * When used in tandem with (char) it produces a lower case letter.
   * @param i non negative int.
   * @return i an int indexed to the alphabet.
   */
  public static int int2letter(int i) {
    int base = (int) 'a';
    i += base;
    return i;
  } // end method

  private static char singleLetterEncrypt(char letter, int key) {
    int numLetter = letter2int(letter);
    numLetter += key;
    if (numLetter < 0) {
      numLetter += 26;
    } // end if
    numLetter = numLetter % 26;
    int encyptedLetter = int2letter(numLetter);
    return (char) encyptedLetter;
  } // end method

  /**
   * This encrpyts a given string towith the given char asits key.
   * @param str a string of only lowercase letters.
   * @param letter a lowercase letter that will be used as the key.
   * @return the ecripted string.
   */
  public static String caesarEncrypt(String str, char letter) {
    int key = letter2int(letter); // Set the key equal to the letter given
    char[] mutable = str.toCharArray(); // Make a char array sketch of the returned string
    for (int i = 0; i < str.length(); i++) {  // loop through the string
      mutable[i] = singleLetterEncrypt(mutable[i], key);
    } // end forloop
    String encrypt = new String(mutable);
    return encrypt;
  } // end method

  /**
   * This decrpyts a given string with the given char as its key.
   * @param str a string of only lowercase letters.
   * @param letter a lowercase letter that will be used as the key.
   * @return the decripted string.
   */
  public static String caesarDecrypt(String str, char letter) {
    int key = (-1 * letter2int(letter)); // Set the key equal to the letter given
    char[] mutable = str.toCharArray(); // Make a char array sketch of the returned string
    for (int i = 0; i < str.length(); i++) {  // loop through the string
      mutable[i] = singleLetterEncrypt(mutable[i], key);
    } // end forloop
    String decrypt = new String(mutable);
    return decrypt;
  } // end method

  /**
   * This encrpyts a given string with the given string as its key.
   * @param str a string of only lowercase letters that will be encrypted.
   * @param key a string of only lowercase letters that will be used as the key.
   * @return the encripted string.
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] mutable = str.toCharArray(); // Make a char array sketch of the returned string
    for (int i = 0; i < str.length(); i++) {  // loop through the string
      int index = i % key.length();
      mutable[i] = singleLetterEncrypt(mutable[i], letter2int(key.charAt(index)));
    } // end forloop
    String encrypt = new String(mutable);
    return encrypt;
  } // end method

  /**
   * This decrpyts a given string with the given string as its key.
   * @param str a string of only lowercase letters that will be decrypted.
   * @param key a string of only lowercase letters that will be used as the key.
   * @return the decripted string.
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] mutable = str.toCharArray(); // Make a char arraysketch of the returned string
    for (int i = 0; i < str.length(); i++) {  // loop through the string
      int index = i % key.length();
      mutable[i] = singleLetterEncrypt(mutable[i], (-1 * letter2int(key.charAt(index))));
    } // end forloop
    String encrypt = new String(mutable);
    return encrypt;
  } // end method
} // end method




