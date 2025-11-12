package me.algorithm.array;

/**
 * Leetcode
 *
 * <p>Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum. A subarray is a contiguous part of an array.
 *
 * <p>
 *
 * <ul>
 *   <li>Example 1
 *       <p>Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has the largest
 *       sum = 6.
 *   <li>Example 2
 *       <p>Input: nums = [1] Output: 1
 *   <li>Example 3
 *       <p>Input: nums = [5,4,-1,7,8] Output: 23
 * </ul>
 */
public class MaximumSubArray {

  private MaximumSubArray() {
  }

  public static int maxByPrefix(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return Integer.MIN_VALUE;
    }

    var maxSum = nums[0];
    var sum = 0;
    var minSum = 0;
    for (var num : nums) {
      sum += num;
      maxSum = Math.max(maxSum, sum - minSum);
      minSum = Math.min(minSum, sum);
    }
    return maxSum;
  }
}
