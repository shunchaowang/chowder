package me.algorithm.divideconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * <headings>
 * Count of Smaller Numbers after Self | Number of Swaps to Sort | Algorithm Swap
 * </headings>
 * You are given an integer array nums and you have to return a new counts array. The count array
 * has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Examples: Example 1: Input: [5,2,6,1]
 * <p>
 * Output: [2,1,1,0]
 * <p>
 * Explanation:
 * <p>
 * For the number 5, there are 2 numbers smaller than it after. (2 and 1)
 * <p>
 * For the number 2, there is 1 number smaller than it after. (1)
 * <p>
 * For the number 6, there is also 1 number smaller than it after. (1)
 * <p>
 * For the number 1, there are no numbers smaller than it after.
 * <p>
 * Hence, we have [2, 1, 1, 0].
 * <p>
 * Number of swaps to sort Another version of the question is:
 * <p>
 * If we sort the nums array by finding the smallest pair i, j where i < j and nums[i] > nums[j],
 * how many swaps are needed?
 * <p>
 * To answer that question, we just have to sum up the numbers in the above output array: 2 + 1 + 1
 * = 4 swaps.
 */
public class AlgorithmSwap {

  private record Element(int index, int value) {

  }

  private final List<Integer> smallerArr = new ArrayList<>();

  /*
   * we can borrow the idea of the mrege sort, but we don't partition the nums based on value,
   * we partition them by index, this will retain the position of the arrays.
   */

  private List<Element> mergeSort(List<Element> nums) {

    int l = nums.size();
    if (l <= 1) {
      return nums;
    }

    List<Element> leftNums = new ArrayList<>();
    List<Element> rightNums = new ArrayList<>();

    for (int i = 0; i < l; i++) {
      if (i < l / 2) {
        leftNums.add(nums.get(i));
      } else {
        rightNums.add(nums.get(i));
      }
    }

    List<Element> leftElements = mergeSort(leftNums);
    List<Element> rightElements = mergeSort(rightNums);

    return merge(leftElements, rightElements);

  }

  private List<Element> merge(List<Element> left, List<Element> right) {
    List<Element> result = new ArrayList<>();

    int l = 0, r = 0;

    while (l < left.size() && r < right.size()) {
      if (left.get(l).value <= right.get(r).value) {
        smallerArr.set(left.get(l).index, smallerArr.get(left.get(l).index) + r);
        result.add(left.get(l));
        l++;
      } else {
        result.add(right.get(r));
        r++;
      }
    }

    while (l < left.size()) {
      smallerArr.set(left.get(l).index, smallerArr.get(left.get(l).index) + r);
      result.add(left.get(l));
      l++;
    }

    while (r < right.size()) {
      result.add(right.get(r));
      r++;
    }

    return result;
  }

  public List<Integer> count(List<Integer> nums) {
    if (nums == null || nums.isEmpty()) {
      return List.of();
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
      int count = 0;
      for (int j = i + 1; j < nums.size(); j++) {
        if (nums.get(j) < nums.get(i)) {
          count++;
        }
      }
      result.add(count);
    }

    return result;
  }

  public List<Integer> countSmaller(List<Integer> nums) {
    // WRITE YOUR BRILLIANT CODE HERE
    for (int i = 0; i < nums.size(); i++) {
      smallerArr.add(0);
    }
    List<Element> elements = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
      elements.add(new Element(i, nums.get(i)));
    }
    mergeSort(elements);
    return smallerArr;
  }

}
