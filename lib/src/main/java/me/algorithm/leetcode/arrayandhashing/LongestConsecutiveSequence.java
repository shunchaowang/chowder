package me.algorithm.leetcode.arrayandhashing;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Medium
 *
 * <p>Given an unsorted array of integers nums, return the length of the longest consecutive
 * elements sequence.
 *
 * <p>You must write an algorithm that runs in O(n) time.
 *
 * <p>Example 1: Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest consecutive
 * elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * <p>Example 2: Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9
 */
public final class LongestConsecutiveSequence {

  public static int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // running in O(n), so sorting is not an option
    // using HashSet, iterate the array to put the elements into the set
    // then for each element to calculate the longest consecutive
    // eg [100, 4, 200, 1 ,3 ,2], we need to check if the current element is the smallest, we only
    // count
    // when the current element is the smallest.
    // proof is that like 2 3 4 is shorter than 1 2 3 4 if 1 also exists
    int max = 0; // cannot be shorter than 0
    Set<Integer> set = new HashSet<>(); // use hash set to get instant query time not logn
    for (int i : nums) {
      set.add(i);
    }

    // to find the longest consecutive sequence
    for (int i : nums) {
      // only count once there is no i - 1
      if (!set.contains(i - 1)) {
        int l = 1;
        int curr = i;
        while (set.contains(curr + 1)) {
          l++;
          curr++;
        }
        max = Math.max(max, l);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {100, 4, 200, 1, 3, 2};
    out.printf(
        "The longest consecutive in array %s is %d\n",
        Arrays.toString(nums), longestConsecutive(nums));
  }
}
