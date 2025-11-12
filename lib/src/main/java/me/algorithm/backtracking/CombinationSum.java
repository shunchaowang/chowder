package me.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all
 * unique combinations of candidates where the chosen numbers sum to target. You may return the
 * combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are
 * unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150
 * combinations for the given input.
 * <p>
 * Example 1: Input: candidates = [2,3,6,7], target = 7
 * <p>
 * Output: [[2,2,3],[7]]
 * <p>
 * Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * <p>
 * 7 is a candidate, and 7 = 7.
 * <p>
 * These are the only two combinations.
 * <p>
 * Example 2: Input: candidates = [2,3,5], target = 8
 * <p>
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * Example 3: Input: candidates = [2], target = 1
 * <p>
 * Output: []
 * <p>
 * Example 4: Input: candidates = [1], target = 1
 * <p>
 * Output: [[1]]
 * <p>
 * Example 5: Input: candidates = [1], target = 2
 * <p>
 * Output: [[1, 1]]
 * <p>
 * Constrains:
 * <p>
 * 1 <= candidates.length <= 30 1 <= candidates[i] <= 200 All elements of candidates are distinct. 1
 * <= target <= 500
 */
public class CombinationSum {

  private void dfs(List<Integer> candidates, int target, int sum, List<Integer> path,
      List<List<Integer>> res, int start) {
    if (sum == target) {
      res.add(new ArrayList<>(path));
    }
    if (sum > target) {
      return;
    }

    for (int i = start; i < candidates.size(); i++) {
      path.add(candidates.get(i));
      dfs(candidates, target, sum + candidates.get(i), path, res, i);
      path.remove(path.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
    if (candidates == null || candidates.size() == 0) {
      return List.of();
    }

    Collections.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(candidates, target, 0, path, res, 0);
    return res;
  }
}
