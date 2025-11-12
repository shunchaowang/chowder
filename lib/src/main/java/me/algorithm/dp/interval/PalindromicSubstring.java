package me.algorithm.dp.interval;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * <p>
 * A string is a palindrome when it reads the same backward as forward.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc" Output: 3 Explanation: Three palindromic strings: "a", "b", "c". Example 2:
 * <p>
 * Input: s = "aaa" Output: 6 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa",
 * "aaa".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000 s consists of lowercase English letters.
 */
public class PalindromicSubstring {

  /**
   * We need a helper to check if a string is palindrome, then for each char, we get all the
   * substrings starting it, increment if encountering a palindromic string.
   *
   * @param s
   * @return
   */
  public int dfs(String s) {

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        if (isPalindrome(s.substring(i, j))) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean isPalindrome(String s) {

    if (s == null || s.isEmpty()) {
      return false;
    }

    int l = 0, r = s.length() - 1;
    while (l <= r) {
      if (s.charAt(l++) != s.charAt(r--)) {
        return false;
      }
    }
    return true;
  }

  /*
   * Consider to check the palindrome based on the length of the strings.
   * */
  public int dp(String s) {
    int l = s.length();
    // dp[i][j] means starting at i, j prefix of array starting i
    // dp[l-1][l] is the last char substring
    boolean[][] dp = new boolean[l][l + 1];
    int count = 0;
    for (int i = 1; i <= l; i++) {
      for (int j = 0; j < l - i + 1; j++) {
        dp[j][j + i] = (i <= 2 || dp[j + 1][j + i - 1]) &&
            (s.charAt(j) == s.charAt(j + i - 1));

        if (dp[j][j + i]) {
          count++;
        }
      }
    }

    return count;
  }
}
