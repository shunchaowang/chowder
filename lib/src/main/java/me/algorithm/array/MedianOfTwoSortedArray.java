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
    // we compare the median of the 2 arrays, based on the comparison to eliminate
    // the elements
    // 1st array is m length, 2nd array is n length, image we merge 2 arrays, total
    // length is m+n
    // if m+n is odd, the (m+n)/2+1 is the median; else we need elements of (m+n)/2
    // and (m+n)/2+1
    // * example {2, 4, 6}(m =3) and {1, 3, 5, 7}(n=4), the merge is
    // {1,2,3,4,5,6,7},
    // m+n=7, (m+n)/2=3, we need element 4, the index is (m+n)/2
    // * example {2, 4, 6}(m =3) and {1, 3, 5}(n=3), the merge is {1,2,3,4,5,6},
    // m+n=6, we need element at index 2 and 3, they are (m+n)/2-1 and (m+n)/2.
    // m+n=7, (m+n)/2=3, we need element 4, the index is (m+n)/2
    // image the arrays are merge, when comparing m1 and m2, there are 3 cases:
    // 1. m1==m2, {1,4,5} and {2,4,6} -> {1,2,4,4,5,6}, the merged is
    // {...,m1,m2...}},
    // m1 and m2 are adjacent since the
    // array is sorted,
    // the left side has m/2+n/2, total is (m+n)/2 elements, so the m1 and m2 are
    // the elements we are looking for;
    // 2. m1<m2
    // 3. m1>m2
    return 0.0;
  }
}
