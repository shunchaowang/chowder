package me.algorithm.leetcode.twopointers;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra
 * space; after removing the duplicates in-place return the new length of the array.
 *
 * <p>Example 1: Input: [2, 3, 3, 3, 6, 9, 9] Output: 4 Explanation: The first four elements after
 * removing the duplicates will be [2, 3, 6, 9].
 *
 * <p>Example 2: Input: [2, 2, 2, 11] Output: 2 Explanation: The first two elements after removing
 * the duplicates will be [2, 11].
 */
public final class RemoveArrayDuplicates {

  /**
   * @param nums the sorted non-descending array
   * @return the length of the array without duplicates
   */
  public static int removeArrayDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    // [2, 3, 3, 3, 6, 9, 9]
    // [2, 2, 2]
    int slow = 0;
    int fast = slow + 1;
    while (fast < nums.length) {
      if (nums[fast] != nums[slow]) {
        nums[++slow] = nums[fast];
      }
      fast++;
    }
    return slow + 1;
  }
}
