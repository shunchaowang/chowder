package me.algorithm.dp.grid;

/**
 * You are given an array of binary strings strs and two integers m and n.
 * <p>
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the
 * subset.
 * <p>
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3 Output: 4 Explanation: The largest
 * subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4. Other valid
 * but smaller subsets include {"0001", "1"} and {"10", "1", "0"}. {"111001"} is an invalid subset
 * because it contains 4 1's, greater than the maximum of 3. Example 2:
 * <p>
 * Input: strs = ["10","0","1"], m = 1, n = 1 Output: 2 Explanation: The largest subset is {"0",
 * "1"}, so the answer is 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 600 1 <= strs[i].length <= 100 strs[i] consists only of digits '0' and '1'. 1
 * <= m, n <= 100
 */
public class OnesAndZeroes {

  /**
   * this problem is to find all the substrings of the string m 0s and n 1s. eg if m=5, n=3, its to
   * find all the substrings of "00000111"
   */
  public int findMaxForm(String[] strs, int m, int n) {
    int length = strs.length;
    int[][][] dp = new int[m + 1][n + 1][length];

    return max(strs, m, n, 0, dp);

  }

  private int max(String[] strs, int m, int n, int index, int[][][] dp) {
    // for each str, either including in the subset or not including, we need the max length

    if (index == strs.length) {
      return 0;
    }

    if (dp[m][n][index] != 0) {
      return dp[m][n][index];
    }

    // don't include this string
    dp[m][n][index] = max(strs, m, n, index + 1, dp);

    // include this string
    Count count = countOnesZeroes(strs[index]);
    if (count.zeroes() <= m && count.ones() <= n) {
      dp[m][n][index] = Math.max(dp[m][n][index],
          1 + max(strs, m - count.zeroes(), n - count.ones(), index + 1, dp));
    }

    return dp[m][n][index];
  }

  private Count countOnesZeroes(String s) {
    if (s == null || s.isEmpty()) {
      return new Count(0, 0);
    }

    char[] chars = s.toCharArray();
    int ones = 0, zeroes = 0;
    for (char c : chars) {
      switch (c) {
        case '0':
          zeroes++;
          break;
        case '1':
          ones++;
          break;
        default:
          break;
      }
    }
    return new Count(zeroes, ones);
  }

  record Count(int zeroes, int ones) {

  }
}
