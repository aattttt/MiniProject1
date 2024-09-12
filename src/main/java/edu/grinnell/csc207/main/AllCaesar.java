package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
    } else if (args[0].equals("encode")) {
      if (CipherUtils.strScrub(args[1])) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(args[1], ch));
        } // end forloop
      } else {
        System.err.println("Error: String contains characters other than lowercase letters.");
      } // end else
    } else if (args[0].equals("decode")){
      if (CipherUtils.strScrub(args[1])) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(args[1], ch));
        } // end forloop
      }
      else {
        System.err.println("Error: String contains characters other than lowercase letters.");
      }// end else
    }  // end if

    else {
      System.err.println("Error: Invalid option: \"booboo\". Valid options are \"encode\" or \"decode\".");
    } // end else
    pen.close();
  } // end main
} // end class

