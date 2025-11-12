package me.algorithm.dp;

import java.util.Arrays;

/**
 * Given a number that is less than 10^5, determine the smallest amount of perfect squares needed to
 * sum to a particular number. The same number can be used multiple times.
 * <p>
 * A perfect square is an integer p that can be represented as q^2 for some other integer q. For
 * example, 9 is a perfect square since 9 = 3^2. However, 8 isn't a perfect square.
 * <p>
 * Examples
 * <p>
 * Example 1:
 * <p>
 * Input: 12
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * 12 = 4 + 4 + 4
 * <p>
 * Example 2:
 * <p>
 * Input: 13
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * 13 = 4 + 9
 */
public class PerfectSquares {

  private int squareSum(int target, int sqrt, int[] memo) {

    if (memo[target] != -1) {
      return memo[target];
    }
    if (target == 0) {
      return 0;
    }
    if (sqrt == 1) {
      return target;
    }

    int rem = target - sqrt * sqrt;
    int newSqrt = (int) Math.floor(Math.sqrt(rem));

    // include the sqrt
    int num1 = 1 + squareSum(rem, newSqrt, memo);
    // no sqrt
    int num2 = squareSum(target, sqrt - 1, memo);

    int ans = Math.min(num1, num2);
    memo[target] = ans;

    return ans;
  }

  public int perfectSquares(int n) {
    if (n == 0) {
      return 0;
    }

    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);

    return squareSum(n, (int) Math.floor(Math.sqrt(n)), memo);
  }
}
