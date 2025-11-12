package me.playground.encoding;


/**
 * Play how to convert the char into ascii and Unicode, also compare the Unicode with ascii.
 */
public class CharConversion {

  public static int convertCharToAscii(char c) {
    return (int) c;
  }

  public static char convertAsciiToChar(int ascii) {
    return (char) ascii;
  }

  public static int convertCharToUnicode(char c) {
    return Character.getNumericValue(c); // this will return 10-25 for A or a to Z or z
  }

  public static char convertUnicodeToChar(int unicode) {
    return (char) unicode;
  }
}
