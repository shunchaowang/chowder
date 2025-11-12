package me.algorithm.dp.dualsequence;

import java.util.Arrays;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * <p>
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "rabbbit", t = "rabbit" Output: 3 Explanation: As shown below, there are 3 ways you
 * can generate "rabbit" from s. rabbbit rabbbit rabbbit Example 2:
 * <p>
 * Input: s = "babgbag", t = "bag" Output: 5 Explanation: As shown below, there are 5 ways you can
 * generate "bag" from s. babgbag babgbag babgbag babgbag babgbag
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 1000 s and t consist of English letters.
 */
public class DistinctSubsequences {

  public int numDistinct(String s, String t) {

    int m = s.length(), n = t.length();
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    return dfs(s, t, 0, 0, dp);
  }

  /**
   * start with the 1st character of s, it can be included in the substring or not, the total number
   * of distinct sebsequences is the sub of both. for each character in s, if it equals to the
   * character of the t, we have the choice to add it to the existing and shift both indexes; if it
   * is not equal to t, we skip it. The edge case when we reach to the end of s.
   */
  private int dfs(String s, String t, int i, int j, int[][] dp) {

    if (j == t.length()) {
      return 1;
    }

    if (i == s.length()) {
      return 0;
    }

    if (s.length() - i < t.length() - j) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    // skip this char from the string
    dp[i][j] = dfs(s, t, i + 1, j, dp);
    if (s.charAt(i) == t.charAt(j)) {
      // add this char to the existing, and recursively call to next character
      dp[i][j] += dfs(s, t, i + 1, j + 1, dp);
    }
    return dp[i][j];
  }

}
