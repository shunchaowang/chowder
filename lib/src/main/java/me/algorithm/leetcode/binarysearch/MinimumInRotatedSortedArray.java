package me.algorithm.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Medium
 * <p>
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For
 * example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated 7 times. Notice that
 * rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0],
 * a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this
 * array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2] Output: 1 Explanation: The original array was [1,2,3,4,5] rotated 3
 * times. Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2] Output: 0 Explanation: The original array was [0,1,2,4,5,6,7] and
 * it was rotated 4 times. Example 3:
 * <p>
 * Input: nums = [11,13,15,17] Output: 11 Explanation: The original array was [11,13,15,17] and it
 * was rotated 4 times.
 * <p>
 * Constraints:
 * <p>
 * n == nums.length 1 <= n <= 5000 -5000 <= nums[i] <= 5000 All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */
public final class MinimumInRotatedSortedArray {

  // 0 1 2 4 5 6 7
  // 4 5 6 7 0 1 2
  // 5 6 7 0 1 2 4
  // 6 7 0 1 2 4 5
  // binary search,
  // compare the middle a[m] with m -1 and m +1
  // if a[m] < a[m - 1] and a[m] < a[m+1], a[m] is the result.
  // otherrise compare it with start and end:
  // 1. a[m] < a[e], the min is a[s, m - 1]
  // 2. a[m] > a[e], the min is in [m+1, e]
  public static int findMin(int[] nums) {

    if (nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }

    int s = 0;
    int e = nums.length - 1;
    while (s <= e) {
      int m = (s + e) / 2;
      int leftBoundary = (m - 1) >= s ? nums[m - 1] : Integer.MAX_VALUE;
      int rightBoundary = (m + 1) <= e ? nums[m + 1] : Integer.MAX_VALUE;
      if (nums[m] < rightBoundary && nums[m] < leftBoundary) {
        return nums[m];
      }

      if (nums[m] < nums[e]) {
        e = m - 1;
      } else {
        s = m + 1;
      }
    }
    return 0;

  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 8, 1, 2};
    System.out.printf("the min of array %s is %d\n", Arrays.toString(nums), findMin(nums));
  }

}
