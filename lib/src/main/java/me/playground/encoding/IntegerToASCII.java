package me.playground.encoding;

public class IntegerToASCII {

  /**
   * convert an integer into a string, we use ascii code to do the conversion, '0' is 48, if we plus
   * the number with '0', we will get the ascii code for that char, then cast the code into char.
   *
   * @param n
   * @return
   */
  private static String integerToString(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      int lastDigit = n % 10;
      char ch = (char) (lastDigit + '0');
      System.out.println(ch);
      sb.insert(0, ch);
      n /= 10;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int number = 120;
    System.out.printf("Convert %d to %s\n", number, integerToString(number));
  }
}
