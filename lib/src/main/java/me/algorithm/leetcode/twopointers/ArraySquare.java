package me.algorithm.leetcode.twopointers;

import java.util.Arrays;

public final class ArraySquare {

  /**
   * Given an integer array nums sorted in non-decreasing order, return an array of the squares of
   * each number sorted in non-decreasing order.
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100] Explanation: After squaring, the array
   * becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100].
   * <p>
   * Example 2:
   * <p>
   * Input: nums = [-7,-3,2,3,11] Output: [4,9,9,49,121]
   * <p>
   * Constraints:
   * <p>
   * 1 <= nums.length <= 104 -104 <= nums[i] <= 104 nums is sorted in non-decreasing order.
   * <p>
   * Follow up: Squaring each element and sorting the new array is very trivial, could you find an
   * O(n) solution using a different approach?
   *
   * @param nums the array to square
   * @return new sorted array with the square of each items
   */
  public static int[] squareSortedArray(int[] nums) {

    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    // instead of sorting, we can use two pointers, the key is the array is sorted
    // we need to find the smallest element then use it as a pivot to move both ways
    // if all are positive, we can just square it
    if (nums[0] >= 0) {
      return Arrays.stream(nums).map(Math::abs).map(e -> e * e).toArray();
    }
    // if all are negative, we can just square it and reverse
    if (nums[nums.length - 1] <= 0) {
      return Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(e -> e * e)
          .toArray();
    }
    // if both positive and negative exist, find the smallest abs
    int i = 0;
    while (i < nums.length && nums[i] < 0) {
      i++;
    }
    // now nums[i] is positive and nums[i-1] is negative
    // the smallest is between them
    int lowestIndex = i;
    if (Math.abs(nums[i - 1]) < Math.abs(nums[i])) {
      lowestIndex = i - 1;
    }

    int[] square = new int[nums.length];
    int leftIndex = lowestIndex - 1;
    int rightIndex = lowestIndex + 1;
    square[0] = nums[lowestIndex] * nums[lowestIndex];
    i = 1;
    while (leftIndex >= 0 || rightIndex <= nums.length - 1) {
      int leftSquare = leftIndex >= 0 ? nums[leftIndex] * nums[leftIndex] : Integer.MAX_VALUE;
      int rightSquare = rightIndex <= nums.length - 1 ? nums[rightIndex] * nums[rightIndex]
          : Integer.MAX_VALUE;
      if (leftSquare < rightSquare) {
        square[i++] = leftSquare;
        leftIndex--;
      } else {
        square[i++] = rightSquare;
        rightIndex++;
      }
    }
    return square;
  }
}
