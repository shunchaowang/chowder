package me.algorithm.leetcode.slidingwindow;

import static java.lang.System.out;

import java.util.Arrays;

/**
 * Easy
 *
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * <p>You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * <p>Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 *
 * <p>Example 1: Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and
 * sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is
 * not allowed because you must buy before you sell.
 *
 * <p>Example 2: Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no transactions
 * are done and the max profit = 0.
 */
public final class TimeToBuySellStock {

  public static int maxProfit(int[] prices) {
    // iterate the array, assume we sell the stock at current day, the max profit would be current
    // price
    // minus the min price so far.
    // when we iterate the array, we keep updating the min price and calculate the max profit
    int minPrice = Integer.MAX_VALUE;
    // if we don't buy or sell, we get 0 profit
    int maxProfit = 0;

    for (int price : prices) {
      maxProfit = Math.max(maxProfit, price - minPrice);
      minPrice = Math.min(minPrice, price);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    out.printf("The max profit of prices %s is %d\n", Arrays.toString(prices), maxProfit(prices));
  }
}
