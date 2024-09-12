package edu.grinnell.csc207.main;
import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/** 
 * Cipher is the base class in this file. 
 * It parses commandline input and uses it to properly encode and decode what it is given by calling methods in CipherUtils.
 */
public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int stringIndex = -1;
    int keyIndex = -1;
    String action = "";
    String cipher = "";
    int loopCounter = 0;

    // Check if we have the right number of arguments
    if (args.length != 4){
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } // end if 

    // Find the string
    for (; loopCounter < 4; loopCounter++) {
      if (CipherUtils.strScrub(args[loopCounter])) {
        stringIndex = loopCounter;
        loopCounter++;
        break;
      } // end if
    } // end for
    if (stringIndex == -1) {
      System.err.println("Error: String contains characters other than lowercase letters.");
      return;
    }


    // Find the Key
    for (; loopCounter < 4; loopCounter++) {
      if (CipherUtils.strScrub(args[loopCounter])) {
        keyIndex = loopCounter;
        break;
      }
    }
    if (keyIndex == -1) {
      System.err.println("Error: Key of only lowercase letter not found.");
      return;
    }


    // find the action
    for (int i = 0; i < 4; i++) {
      if (args[i].equals("-encode") || args[i].equals("-decode")) {
        action = args[i];
        break;
      }
    }
    if (action.equals("")) {
      System.err.println("Error: Invalid action given. Only -encode and -deconde accepted.");
      return;
    }

    // find the cipher
    for (int i = 0; i < 4; i++) {
      if (args[i].equals("-caesar") || args[i].equals("-vigenere")) {
        cipher = args[i];
        if (cipher.equals("-caesar") && (args[keyIndex].length() > 1)) {
          System.err.println("Error: The key for a caesar cipher must be 1 char long."); // Check if ceasar has been inputted witha string as the key
          return;
        } // end if 
        break;
      }
    }
    if (cipher.equals("")) {
      System.err.println("Error: Invalid cipher given. Only -vigenere and -caesar accepted.");
      return;
    }


    // run body
    if (action.equals("-encode")){
      if (cipher.equals("-caeser")) {
        pen.printf(CipherUtils.caesarEncrypt(args[stringIndex], args[keyIndex].charAt(0)));
      } // end if
      else {
        pen.printf(CipherUtils.vigenereEncrypt(args[stringIndex], args[keyIndex]));
      } // end else
    } // end if
    else if (cipher.equals("-caeser")) {
      pen.printf(CipherUtils.caesarDecrypt(args[stringIndex], args[keyIndex].charAt(0)));
    }
    else {
      pen.printf(CipherUtils.vigenereDecrypt(args[stringIndex], args[keyIndex]));
    }
  } // end method
} // end class