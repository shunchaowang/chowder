package me.algorithm.array;

/**
 * leetcode
 *
 * <p>Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of
 * the two sorted arrays.
 *
 * <p>The overall run time complexity should be <b>O(log (m+n)).
 *
 * <p>
 *
 * <ul>
 *   <li>Example 1
 *       <p>Input: nums1 = [1,3], nums2 = [2]
 *       <p>Output: 2.00000
 *       <p>Explanation: merged array = [1,2,3] and median is 2.
 *   <li>Example 2
 *       <p>Input: nums1 = [1,2], nums2 = [3,4]
 *       <p>Output: 2.50000
 *       <p>Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *   <li>Example 3
 *       <p>Input: nums1 = [0,0], nums2 = [0,0]
 *       <p>Output: 0.00000
 *   <li>Example 4
 *       <p>Input: nums1 = [], nums2 = [1]
 *       <p>Output: 1.00000
 *   <li>Example 5
 *       <p>Input: nums1 = [2], nums2 = []
 *       <p>Output: 2.00000
 */
public final class MedianOfTwoSortedArray {

  private MedianOfTwoSortedArray() {
  }

  /**
   * This is the brute force approach, we merge the two arrays, then calculate the median.
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedian(int[] nums1, int[] nums2) {

    double median;
    int[] merged = ArrayUtils.mergeTwoSortedArray(nums1, nums2);
    if (merged.length % 2 == 0) {
      median = ((double) merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2;
    } else {
      median = merged[merged.length / 2];
    }
    return median;
  }

  /**
   * Coming from the merge approach, we only need 1 item (arr[length/2]) for odd number merged
   * array, and 2 items for even number merged array. (arr[length/2-1], and arr[length/2]).
   *
   * <p>we can borrow the idea from the merging approach, but to remember the counts instead of the
   * elements.
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianByCount(int[] nums1, int[] nums2) {

    int length = nums1.length + nums2.length;
    int i = 0;
    int j = 0;
    int k = 0;

    // count till length /2 -1, then we should reach the elements we need
    float m1 = 0;
    float m2 = 0;
    while (i < nums1.length && j < nums2.length && k <= length / 2) {
      m1 = m2;
      if (nums1[i] < nums2[j]) {
        m2 = nums1[i++];
      } else {
        m2 = nums2[j++];
      }
      k++;
    }

    // nums1 still has element and we are not reaching the half length
    while (k <= length / 2 && i < nums1.length) {
      m1 = m2;
      k++;
      m2 = nums1[i++];
    }
    // nums2 still has element and we are not reaching the half length
    while (k <= length / 2 && j < nums2.length) {
      m1 = m2;
      k++;
      m2 = nums2[j];
    }
    if (length % 2 == 0) {
      return (m1 + m2) / 2;
    }

    return m2;
  }

  public static double findMedianByBinarySearch(final int[] nums1, final int[] nums2) {

    // if any is empty
    if (nums1.length == 0 && nums2.length == 0)
      return 0.0;
    if (nums1.length == 0) {
      if (nums2.length % 2 == 0) {
        return (double) (nums2[(nums2.length - 1) / 2] + nums2[(nums2.length - 1) / 2 + 1]) / 2;
      } else {
        return nums2[(nums2.length - 1) / 2];
      }
    }
    if (nums2.length == 0) {
      if (nums1.length % 2 == 0) {
        return (double) (nums1[(nums1.length - 1) / 2] + nums1[(nums1.length - 1) / 2 + 1]) / 2;
      } else {
        return nums1[(nums1.length - 1) / 2];
      }
    }
    // if total is odd, the ans is the min of next index from nums1 and nums2
    // if total is even, the ans is (max(index1,index2)+min(index1+1,index2+1))/2

    int[] a = nums1, b = nums2;
    int total = a.length + b.length;
    int half = total / 2;
    if (b.length < a.length) {
      a = nums2;
      b = nums1;
    }

    int l = 0, r = a.length - 1;
    while (true) {
      // index1, index2
      // next1, next2
      // num1Index, num2Index
      int i = (l + r) / 2; // count of number is index1+1
      int j = half - i - 2; // count of number is index2+1
      int aLeft = Integer.MIN_VALUE;
      if (i >= 0) {
        aLeft = nums1[i];
      }
      int bLeft = Integer.MIN_VALUE;
      if (j >= 0) {
        bLeft = nums2[j];
      }
      int aRight = Integer.MAX_VALUE;
      if (i + 1 < a.length) {
        aRight = nums1[i + 1];
      }
      int bRight = Integer.MAX_VALUE;
      if (j + 1 < b.length) {
        bRight = nums2[j + 1];
      }

      if (aLeft <= bRight && bLeft <= aRight) { // we've found the position
        // if total is odd, the ans the min of both next
        // if total is even, the ans is max(index1,index2)+min(nex1,next2)/2
        if (total % 2 == 0) {
          return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
        } else {
          return Math.min(aRight, bRight);
        }
      }

      if (aLeft > bRight) { // we need to shift index1 to the left
        r = i - 1;
      }

      if (bLeft > aRight) { // we need to shift index1 to the right
        l = i + 1;
      }
    }
  }
}
