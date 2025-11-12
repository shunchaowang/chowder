package me.algorithm.dp.knapsack;


/**
 * There is a group of n members, and a list of various crimes they could commit. The ith crime
 * generates a profit[i] and requires group[i] members to participate in it. If a member
 * participates in one crime, that member can't participate in another crime.
 * <p>
 * Let's call a profitable scheme any subset of these crimes that generates at least minProfit
 * profit, and the total number of members participating in that subset of crimes is at most n.
 * <p>
 * Return the number of schemes that can be chosen. Since the answer may be very large, return it
 * modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3] Output: 2 Explanation: To make a
 * profit of at least 3, the group could either commit crimes 0 and 1, or just crime 1. In total,
 * there are 2 schemes. Example 2:
 * <p>
 * Input: n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8] Output: 7 Explanation: To make a
 * profit of at least 5, the group could commit any crimes, as long as they commit one. There are 7
 * possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 100 0 <= minProfit <= 100 1 <= group.length <= 100 1 <= group[i] <= 100 profit.length
 * == group.length 0 <= profit[i] <= 100
 */
public class ProfitableScheme {


  /**
   * @param n         the available member we have
   * @param minProfit the profit we need to gain at least
   * @param group     the member needed for each crime
   * @param profit    the profit gained for each crime
   * @return the number of the profitable scheme, modulo of 10e9+7 we can create a 3-dimensional
   * arrays of length, profit and member. Starting at the [index] with the profit of [p] and
   * [member] required the total profitable schemes is stored in dp[index][profit][member]. The
   * final result will be dp[0][0[0].
   */
  public int findProfitableSchemes(int n, int minProfit, int[] group, int[] profit) {

    int length = group.length;
    int mod = (int) 1e9 + 7;
    int[][][] dp = new int[length + 1][minProfit + 1][n + 1];
    // we all crimes are visited, every node with minProfit met should be a profitable scheme
    for (int i = 0; i <= n; i++) {
      dp[length][minProfit][i] = 1;
    }

    for (int i = length - 1; i >= 0; i--) {
      for (int p = 0; p <= minProfit; p++) {
        for (int m = 0; m <= n; m++) {
          // skip this crime
          dp[i][p][m] = dp[i + 1][p][m] % mod;
          // execute this crime
          if (group[i] + m <= n) {
            dp[i][p][m]=(dp[i][p][m] + dp[i + 1][Math.min(minProfit, p + profit[i])][m + group[i]]) % mod;
          }
        }
      }
    }
    return dp[0][0][0];
  }
}
