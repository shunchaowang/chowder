package me.algorithm.dp.knapsack;

import java.util.List;

/**
 * You and a friend are playing a game with n coins arranged in a straight line, where each coin has
 * a distinct value given by coins[i]. Starting with you, both players take turns, picking one coin
 * from either end of the line and adding its value to their individual scores. Once a coin is
 * picked up, it's removed from the line.
 * <p>
 * Given that your friend plays optimally to achieve the highest score, determine your maximum
 * possible score.
 * <p>
 * Input
 * <p>
 * coins: A list of the coins. Output
 * <p>
 * Your maximum possible score, provided that you go first and your friend plays perfectly.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * coins = [4, 4, 9, 4] Output: 13
 * <p>
 * Explanation:
 * <p>
 * The coins start like this:
 * <p>
 * 4, 4, 9, 4
 * <p>
 * You always go first, so you take the 4 from the left side:
 * <p>
 * 4, 9, 4
 * <p>
 * Your friend takes any of the 4s (it doesn't matter)
 * <p>
 * 9, 4
 * <p>
 * Now you take the 9, and your friend takes the remaining 4.
 * <p>
 * Your score in this case, is 4 + 9 = 13.
 * <p>
 * Constraints
 * <p>
 * 1 <= len(coins) <= 1000 1 <= coins[i] <= 5 * 10^5
 */
public class CoinGame {

  // l and r are inclusive
  private int maxScore(List<Integer> coins, int l, int r, int[] sums) {
    if (l == r) {
      return coins.get(l);
    }

    // i can pick left or right, then he will pick the remaining
    // with the same strategy
    // i want to make sure i pick from the side will give him
    // the min values
    // sum up all the values

    // get the sum of [l,r] from prefix sums
    int sum = sums[r + 1] - sums[l];

    // if i pick from the left, [l+1,r] is the remaining
    int leftPick = maxScore(coins, l + 1, r, sums);
    // if i pick from the right, [l,r-1] is the remaining
    int rightPick = maxScore(coins, l, r - 1, sums);

    return sum - Math.min(leftPick, rightPick);
  }

  private int dp(List<Integer> coins) {

    // create a prefix list for the sum
    // prefix[i] means the sum elements from [0..i-1]
    // prefix[i] is the sum of the fist ith element
    // prefix[0] is for an empty list
    // prefix[1] is for coins[0]
    // prefix[l] =sum of [0,l-1]
    // prefix[r]=sum of [0,r-1]
    int size = coins.size();

    int[] sums = new int[coins.size() + 1];
    sums[0] = 0;

    for (int i = 1; i <= coins.size(); i++) {
      sums[i] = sums[i - 1] + coins.get(i - 1);
    }

    int[][] dp = new int[size][size];

    for (int interval = 0; interval < size; ++interval) {
      for (int l = 0; l + interval < size; ++l) {

        int r = l + interval;
        if (l == r) {
          dp[l][r] = sums[r + 1] - sums[l];
        } else {
          dp[l][r] = sums[r + 1] - sums[l] - Math.min(dp[l + 1][r], dp[l][r - 1]);
        }


      }
    }

    return dp[0][size - 1];
  }

  public int coinGame(List<Integer> coins) {
    if (coins == null || coins.isEmpty()) {
      return 0;
    }

    return dp(coins);
  }
}
