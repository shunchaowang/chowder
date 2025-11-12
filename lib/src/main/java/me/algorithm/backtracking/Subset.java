package me.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example 1: Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class Subset {

  private List<List<Integer>> dfs(List<Integer> nums, int start) {

    if (start == nums.size()) {
      return List.of(List.of());
    }

    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> rem = dfs(nums, start + 1);

    res.addAll(rem);
    res.addAll(rem.stream().map(l -> {

      List<Integer> ll = new ArrayList<>();

      ll.add(nums.get(start));
      ll.addAll(l);
      return ll;
    }).toList());

    return res;
  }

  public List<List<Integer>> subsets(List<Integer> nums) {
    if (nums == null || nums.isEmpty()) {
      return List.of();
    }
    return dfs(nums, 0);
  }
}
