package me.algorithm.array;

/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty
 * subarray of nums. A circular array means the end of the array connects to the beginning of the
 * array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of
 * nums[i] is nums[(i - 1 + n) % n]. A subarray may only include each element of the fixed buffer
 * nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not
 * exist i <= k1, k2 <= j with k1 % n == k2 % n.
 * <p>
 * Example 1: Input: nums = [1,-2,3,-2] Output: 3 Explanation: Subarray [3] has maximum sum 3.
 * Example 2: Input: nums = [5,-3,5] Output: 10 Explanation: Subarray [5,5] has maximum sum 5 + 5 =
 * 10. Example 3: Input: nums = [-3,-2,-3] Output: -2 Explanation: Subarray [-2] has maximum sum -2.
 * Constraints: n == nums.length 1 <= n <= 3 * 104 -3 * 104 <= nums[i] <= 3 * 104
 */
public class MaxSumCircularArray {

  // we can find the min sum of the subarray, then total sum minus it to
  // get the max of circular subarray.
  // time complexity is o(n), and space is o(1)
  public int maxSubarraySumCircular(int[] nums) {
    int totalSum = 0;
    int minToHere = 0;
    int maxToHere = 0;
    int minSum = nums[0];
    int maxSum = nums[0];

    for (int num : nums) {
      totalSum += num;
      minToHere = Math.min(minToHere + num, num);
      minSum = Math.min(minSum, minToHere);
      maxToHere = Math.max(maxToHere + num, num);
      maxSum = Math.max(maxSum, maxToHere);
    }

    // edge case if all nums are negative, but we need to find the unempty subarray
    // with the max sum, we just need to return the max sum (it is also the biggest num)
    if (totalSum == minSum) {
      return maxSum;
    }

    // the max sum could be the subarray of max sum, or the min sum of the subarray minus from the total sum
    // the max sum is the case of the continuous subarray has the max total sum;
    // the other case is we wrap to the head of the array, the min sum is a continuous subarray
    return Math.max(maxSum, totalSum - minSum);

  }
}
