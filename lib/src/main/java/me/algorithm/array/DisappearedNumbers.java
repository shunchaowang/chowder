package me.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

  /**
   * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all
   * the integers in the range [1, n] that do not appear in nums.
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [4,3,2,7,8,2,3,1] Output: [5,6] Example 2:
   * <p>
   * Input: nums = [1,1] Output: [2]
   * <p>
   * Constraints:
   * <p>
   * n == nums.length 1 <= n <= 105 1 <= nums[i] <= n
   * <p>
   * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned
   * list does not count as extra space.
   *
   * @param nums
   * @return
   */
  public static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> results = new ArrayList<>();
    // use the array as the container, iterate the array, if the element at i is
    // seen,
    // set the nums[i-1] to be negative value, once all elements have been visited,
    // the elements missing will have a positive value at the index
    for (int i = 0; i < nums.length; i++) {
      int idx = Math.abs(nums[i]) - 1;
      if (nums[idx] > 0) {
        nums[idx] *= -1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        results.add(i + 1);
      }
    }
    return results;
  }

  /**
   * Given an array arr of positive integers sorted in a strictly increasing order, and an integer
   * k.
   * <p>
   * Find the kth positive integer that is missing from this array.
   * <p>
   * Example 1:
   * <p>
   * Input: arr = [2,3,4,7,11], k = 5 Output: 9 Explanation: The missing positive integers are
   * [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9. Example 2:
   * <p>
   * Input: arr = [1,2,3,4], k = 2 Output: 6 Explanation: The missing positive integers are
   * [5,6,7,...]. The 2nd missing positive integer is 6.
   * <p>
   * Constraints:
   * <p>
   * 1 <= arr.length <= 1000 1 <= arr[i] <= 1000 1 <= k <= 1000 arr[i] < arr[j] for 1 <= i < j <=
   * arr.length
   *
   * @param arr the array containing positives
   * @param k
   * @return
   */
  public static int findKthMissingPositive(int[] arr, int k) {
    if (arr == null || arr.length == 0 || arr[0] > k) {
      return k;
    }
    // the position and the number should be different of 1 if on number is missing
    // we iterate the number if the arr[i] - i > k, the missing is must be before
    // that
    int i = 0;
    int d = 1;
    while ((i < arr.length) && (arr[i] - (i + 1) < k)) {
      i++;
    }

    d = arr[i - 1] - (i);
    return arr[i - 1] + (k - d);
  }

}
