package edu.grinnell.csc207.main;
import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Cipher is the base class in this file.
 * It parses commandline input and uses it to properly encode and decode
 * what it is given by calling methods in CipherUtils.
 */
public class Cipher {

/**
 * This takes 4 strings from the command line. An action (-encode or -decode)
 * a cipher (ceaser or vigenere) a message (string of lower case letters)
 * and a key (string of lower case letters). It uses the given cipher to
 * do the given action to the message using the key.
 * @param args -encode or -decode, ceaser or vigenere, string of
 * lower case letters, string of lower case letters.
 */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int stringIndex = -1;
    int keyIndex = -1;
    String action = "";
    String cipher = "";
    int loopCounter = 0;
    int argMax = 4;
    // Check if we have the right number of arguments
    if (args.length != argMax) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } // end if

    // Find the string
    for (; loopCounter < argMax; loopCounter++) {
      if (CipherUtils.strScrub(args[loopCounter])) {
        stringIndex = loopCounter;
        loopCounter++;
        break;
      } // end if
    } // end for
    if (stringIndex == -1) {
      System.err.println("Error: String contains characters other than lowercase letters.");
      return;
    } //end if


    // Find the Key
    for (; loopCounter < argMax; loopCounter++) {
      if (CipherUtils.strScrub(args[loopCounter])) {
        keyIndex = loopCounter;
        break;
      } //end if
    } // end for
    if (keyIndex == -1) {
      System.err.println("Error: Key of only lowercase letter not found.");
      return;
    } // end if


    // find the action
    for (int i = 0; i < argMax; i++) {
      if (args[i].equals("-encode") || args[i].equals("-decode")) {
        action = args[i];
        break;
      } //end if
    } // end for
    if (action.equals("")) {
      System.err.println("Error: Invalid action given. Only -encode and -deconde accepted.");
      return;
    } // end if

    // find the cipher
    for (int i = 0; i < argMax; i++) {
      if (args[i].equals("-caesar") || args[i].equals("-vigenere")) {
        cipher = args[i];
        if (cipher.equals("-caesar") && (args[keyIndex].length() > 1)) {
          System.err.println("Error: The key for a caesar cipher must be 1 char long.");
          return;
        } // end if
        break;
      } //end if
    } //end for
    if (cipher.equals("")) {
      System.err.println("Error: Invalid cipher given. Only -vigenere and -caesar accepted.");
      return;
    } // end if


    // run body
    if (action.equals("-encode")) {
      if (cipher.equals("-caeser")) {
        pen.printf(CipherUtils.caesarEncrypt(args[stringIndex], args[keyIndex].charAt(0)));
      } else {
        pen.printf(CipherUtils.vigenereEncrypt(args[stringIndex], args[keyIndex]));
      } // end else
    } else if (cipher.equals("-caeser")) {
      pen.printf(CipherUtils.caesarDecrypt(args[stringIndex], args[keyIndex].charAt(0)));
    } else {
      pen.printf(CipherUtils.vigenereDecrypt(args[stringIndex], args[keyIndex]));
    } // end if
  } // end method
} // end class

