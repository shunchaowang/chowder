package me.algorithm.prefixsum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers and an integer target, find a subarray that sums to target and return
 * the start and end indices of the subarray.
 * <p>
 * Input: arr: 1 -20 -3 30 5 4 target: 7
 * <p>
 * Output: 1 4
 * <p>
 * Explanation: -20 - 3 + 30 = 7. The indices for subarray [-20,-3,30] is 1 and 4 (right
 * exclusive).
 */
public class SubarraySum {

  public List<Integer> subarraySum(List<Integer> arr, int target) {

    Map<Integer, Integer> prefixes = new HashMap<>();
    // empty array only have a 0->0
    // edge case is the first element is the target, so the ans is [0,1]
    // prefixes 1-> is all elements' sum before the ith element
    // eg prefixes[1] will the arr[0], prefixes[2] will be arr[0]+arr[1]
    // prefixes has 1 more element than the arr, it's arr.size()+1
    // so the answer will be (arr[i]-target,i+1)
    prefixes.put(0, 0);
    int curSum = 0;
    for (int i = 0; i < arr.size(); i++) {
      curSum += arr.get(i);
      int remaining = curSum - target;
      if (prefixes.containsKey(remaining)) {
        return List.of(prefixes.get(remaining), i + 1);
      }

      prefixes.put(curSum, i + 1);
    }
    return null;
  }
}
