package me.algorithm.slidingwindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length
 * of a subarray whose sum is greater than or equal to target. If there is no such subarray, return
 * 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: The subarray [4,3] has the minimal
 * length under the problem constraint. Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4] Output: 1 Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 109 1 <= nums.length <= 105 1 <= nums[i] <= 104
 */
public class MinimumSizeSubarraySum {

  public int minSubArrayLen(int target, int[] nums) {
    // two pointers
    int l = nums.length;
    int left = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int r = 0; r < l; r++) {
      sum += nums[r];

      // when we get a sum less than the target, it's not necessary to shift the left pointer to the right at all
      // since all numbers are positive
      while (sum >= target) {
        min = Math.min(min, r - left + 1);
        sum -= nums[left++];
      }
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
