package me.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Merge Intervals</h2>
 * <h3>Leetcode</h3>
 * <h3>Medium</h3>
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] =
 * [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint
 * and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * <p>
 * The intersection of two closed intervals is a set of real numbers that are either empty or
 * represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 * <p>
 * Example 1:
 * <p>
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]] Example 2:
 * <p>
 * Input: firstList = [[1,3],[5,9]], secondList = [] Output: []
 * <p>
 * Constraints:
 * <p>
 * 0 <= firstList.length, secondList.length <= 1000 firstList.length + secondList.length >= 1 0 <=
 * starti < endi <= 109 endi < starti+1 0 <= startj < endj <= 109 endj < startj+1
 */
public class IntervalIntersection {

  /**
   * compare two pairs of int array s and t
   *
   * @param s the source pair, eg [1,5]
   * @param t the target pair, eg [0,2]
   * @return Overlap if overlapping, Less if s is on the left of t, greater if s is on the right of
   * t
   */
  private PairComparator comparePair(int[] s, int[] t) {
    if (s[1] >= t[0] && s[0] <= t[1]) {
      return PairComparator.Overlap;
    }
    if (s[1] < t[1]) {
      return PairComparator.Less;
    }
    if (s[0] > t[1]) {
      return PairComparator.Greater;
    }
    return PairComparator.Overlap;
  }

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

    if (firstList == null || secondList == null || firstList.length == 0
        || secondList.length == 0) {
      return new int[0][];
    }

    List<int[]> intersections = new ArrayList<>();
    int firstIndex = 0;
    int secondIndex = 0;
    while (firstIndex < firstList.length && secondIndex < secondList.length) {
      int[] firstPair = firstList[firstIndex];
      int[] secondPair = secondList[secondIndex];

      // compare two pairs, add to results if overlapping, shift the index with the
      // smaller bigger value
      // if firstPair < secondPair, shift firstIndex
      // if firstPair > secondPair, shift secondIndex
      PairComparator comparator = comparePair(firstPair, secondPair);
      switch (comparator) {
        case Overlap:
          int[] pair = {Math.max(firstPair[0], secondPair[0]),
              Math.min(firstPair[1], secondPair[1])};
          intersections.add(pair);
          if (secondPair[1] < firstPair[1]) {
            secondIndex++;
          } else {
            firstIndex++;
          }
          break;
        case Less:
          firstIndex++;
          break;
        case Greater:
          secondIndex++;
          break;
      }
    }
    return intersections.toArray(new int[0][0]);
  }

  public enum PairComparator {
    Overlap,
    Less,
    Greater
  }
}
