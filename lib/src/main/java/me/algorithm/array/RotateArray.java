package me.algorithm.array;


import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate 1 steps to the
 * right: [7,1,2,3,4,5,6] rotate 2 steps to the right: [6,7,1,2,3,4,5] rotate 3 steps to the right:
 * [5,6,7,1,2,3,4] Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100] Explanation: rotate 1 steps to the
 * right: [99,-1,-100,3] rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105 -231 <= nums[i] <= 231 - 1 0 <= k <= 105
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Try to come up with as many solutions as you can. There are at least three different ways to
 * solve this problem. Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

  /**
   * 1 2 3 4 5 6 7 k =3 if we want to use contant space, we can go with k loops to rotate the array
   * 1 a time. if we want to solve this problem with 1 loop, we can have a k size array as the
   * buffer
   */
  public void rotate(int[] nums, int k) {
    rotate1(nums, k);
  }

  // this is in place with O(1) space
  private void rotate1(int[] nums, int k) {
    int l = nums.length;
    k %= l;

    if (k == 0) {
      return; // rotate multi of l, means no rotation
    }

    int[] t = Arrays.copyOfRange(nums, l - k, l);
    for (int i = l - 1; i >= k; i -= k) {
      for (int j = 0; j < k; j++) {
        if (i - j - k < 0) {
          break;
        }
        nums[i - j] = nums[i - j - k];
      }
    }
    System.arraycopy(t, 0, nums, 0, k);
  }
}
