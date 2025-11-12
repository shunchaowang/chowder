package me.algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
 * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation: nums[0] + nums[1] +
 * nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0. nums[0] + nums[3] +
 * nums[4] = (-1) + 2 + (-1) = 0. The distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the
 * order of the output and the order of the triplets does not matter. Example 2:
 * <p>
 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000 -105 <= nums[i] <= 105
 */
public class ThreeSum {

  /**
   * sort the array, use binary search approach, since the order doesn't matter
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> result = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      Set<List<Integer>> pairs = twoSum(nums, i + 1, -num);
      if (!pairs.isEmpty()) {
        for (List<Integer> l : pairs) {
          List<Integer> li = new ArrayList<>(l);
          li.add(num);
          result.add(li);
        }
      }
    }

    return new ArrayList<>(result);
  }

  /**
   * start the start index of the numbers, find all pairs adding up to target
   */
  private Set<List<Integer>> twoSum(int[] nums, int start, int target) {
    Set<List<Integer>> result = new HashSet<>();
    int l = start, r = nums.length - 1;
    while (l < r) {
      int sum = nums[l] + nums[r];
      if (sum == target) {
        List<Integer> list = List.of(nums[l], nums[r]);
        result.add(list);
        l++;
        r--;
      } else if (sum > target) {
        r--;
      } else {
        l++;
      }
    }

    return result;
  }
}
