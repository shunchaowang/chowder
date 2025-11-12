package me.algorithm.array;

import java.util.HashMap;

/**
 * leetcode Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <p>You can return the answer in any order.
 */
public class TwoSum {

  private TwoSum() {
  }

  public static int[] findSumOfTwo(int[] array, int target) {
    int[] result = new int[2];
    if (array == null) {
      return result;
    }
    // iterate the array and initialize a hash map with the value as the key and
    // index as the value
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i])) {
        return new int[]{map.get(target - array[i]), i};
      }
      map.put(array[i], i);
    }
    return result;
  }
}
