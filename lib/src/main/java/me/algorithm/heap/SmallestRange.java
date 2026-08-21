package me.algorithm.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that
 * includes at least one number from each of the k lists.
 * <p>
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d -
 * c.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]] Output: [20,24] Explanation: List 1: [4,
 * 10, 15, 24,26], 24 is in range [20,24]. List 2: [0, 9, 12, 20], 20 is in range [20,24]. List 3:
 * [5, 18, 22, 30], 22 is in range [20,24]. Example 2:
 * <p>
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]] Output: [1,1]
 * <p>
 * Constraints:
 * <p>
 * nums.length == k 1 <= k <= 3500 1 <= nums[i].length <= 50 -105 <= nums[i][j] <= 105 nums[i] is
 * sorted in non-decreasing order.
 */
public class SmallestRange {

  private record Element(int value, int list, int index) {

  }

  /**
   * consider the edge case of the list of single element, the range is [smallest, largest]. The
   * bottom line is we need to have at least 1 element from the lists to be covered. we have a min
   * queue to track the current smallest element chosen from every list, we also need to track the
   * largest element currently with the numbers in the queue, the current smallest range is [top of
   * queue, largest]. we keep popping out the top the queue and add the next number from the same
   * list to the queue, replace the range when we repeat.
   */
  public int[] smallestRange(List<List<Integer>> nums) {

    PriorityQueue<Element> minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

    int currMax = Integer.MIN_VALUE;

    int[] ans = new int[]{Integer.MAX_VALUE, currMax};

    for (int i = 0; i < nums.size(); i++) {
      currMax = Math.max(currMax, nums.get(i).get(0));
      minQueue.offer(new Element(nums.get(i).get(0), i, 0));
    }

    do {
      Element top = minQueue.poll();
      ans = min(ans, new int[]{top.value, currMax});
      if (top.index == nums.get(top.list).size() - 1) {
        break;
      }
      currMax = Math.max(currMax, nums.get(top.list).get(top.index + 1));
      minQueue.offer(new Element(nums.get(top.list).get(top.index + 1), top.list, top.index + 1));
    } while (true);

    return ans;
  }

  private int[] min(int[] a1, int[] a2) {
    if (a1[0] > a1[1]) {
      return a2;
    }
    if (a1[1] - a1[0] < a2[1] - a2[0]) {
      return a1;
    } else if (a1[1] - a1[0] > a2[1] - a2[0]) {
      return a2;
    } else {
      return a1[0] <= a2[0] ? a1 : a2;
    }
  }
}
