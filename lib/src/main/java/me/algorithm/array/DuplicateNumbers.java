package me.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class DuplicateNumbers {

  /**
   * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
   * and each integer appears once or twice, return a list of all the integers that appears twice.
   *
   * <p>You must write an algorithm that runs in O(n) time and uses only constant extra space.
   *
   * <p>Example 1: Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
   *
   * <p>Example 2: Input: nums = [1,1,2] Output: [1]
   *
   * <p>Example 3: Input: nums = [1] Output: []
   *
   * <p>Constraints: 1 <= n <= 10000 1 <= nums[i] <= n Each element in nums appears once or twice.
   *
   * @param nums of the array
   * @return the list of duplicate numbers
   */
  public static List<Integer> findDuplicates(int[] nums) {
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int idx = Math.abs(nums[i]);
      if (nums[idx - 1] < 0) {
        results.add(idx);
      } else {
        nums[idx - 1] *= -1;
      }
    }
    return results;
  }
}
