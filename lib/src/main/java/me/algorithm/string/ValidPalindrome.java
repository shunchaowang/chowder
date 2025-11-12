package me.algorithm.string;

public class ValidPalindrome {

  /**
   * Determine whether a string is a palindrome, ignoring non-alphanumeric characters and case.
   * Examples:
   * <p>
   * Input: Do geese see God? Output: True
   * <p>
   * Input: Was it a car or a cat I saw? Output: True
   * <p>
   * Input: A brown fox jumping over Output: False
   *
   * @param s
   * @return
   */
  public boolean isPalindrome(String s) {
    String str = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
    char[] chars = str.toCharArray();
    int l = 0, r = chars.length - 1;
    while (l < r) {
      if (chars[l++] != chars[r--]) {
        return false;
      }
    }
    return true;

  }
}
