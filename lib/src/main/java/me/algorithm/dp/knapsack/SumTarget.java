package me.algorithm.dp.knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class SumTarget {

  /**
   * given a target number and an array, test if any numbers can add up to the target all numbers
   * are nonnegative the numbers can be reused
   *
   * @param target the sum
   * @param nums   the array of numbers
   */
  public static boolean canSum(int target, int[] nums) {

    Map<String, Boolean> memo = new HashMap<>();
    // if use dp, consider 1 element in the array, there are 2 options, include it or not
    return sumHelper(target, nums, nums.length - 1, memo);
  }

  /**
   * the helper to test if can sum
   *
   * @param target the sum
   * @param nums   the array
   * @param the    ending elements in the array inclusively, it starts on nums.length - 1
   */
  private static boolean sumHelper(int target, int[] nums, int last, Map<String, Boolean> memo) {

    // check if has calculated before
    String k = target + ", " + last;
    if (memo.containsKey(k)) {
      return memo.get(k);
    }
    // what is the base case? there is 1 element left in the array
    if (last == 0) {
      return target == nums[last];
    }
    // for the element at length - 1, there are 2 options, in or not
    memo.put(k,
        sumHelper(target, nums, last - 1, memo) || sumHelper(target - nums[last], nums, last - 1,
            memo));
    return memo.get(k);
  }

  public static void main(String[] args) {
    int[] case1 = {1, 2, 3, 4, 5};
    int target1 = 8;
    System.out.printf("%s should have sum of %d, the actual is %b\n", Arrays.toString(case1),
        target1, canSum(target1, case1));
    int target2 = 20;
    System.out.printf("%s should not have sum of %d, the actual is %b\n", Arrays.toString(case1),
        target2, canSum(target2, case1));
  }
}
