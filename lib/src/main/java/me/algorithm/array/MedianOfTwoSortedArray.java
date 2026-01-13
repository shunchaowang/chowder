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

  public static double findMedianBs(int[] a, int[] b) {

    // for each array n, n.length/2 is the index number that there are index items to its left

    // we need to find the pivots on both arrays that all the numbers to the left are landed to the left of the merged,
    // for [2,4], m1 is (0+2)/2=1, the pivot is m1-1, total/2 is 2, so the numbers from b is 2-1=1.
    // m=2, n=3, total=2, m1=1, m2=2-1=1=>l1=a[m1-1]=2, r1=a[m1]=4; l2=b[m2-1]=1, r2=b[m2]=3
    // we want to set m is the length of a, n is the length of b.
    // total is m+n divided by 2
    // total=(m+n)/2, m1=(lo+hi)/2, m2=(m+n)/2 - m1
    // l1 = a[m1-1], rl=a[m1], l2=b[m2-1], r2=b[m2]
    /* 1. if the merged array is odd
     * l1<=r2 && l2<=r1, min(r1, r2).
     * 2. if the merged array is even
     * [2,4] and [1,3], the result should be (2+3)/2=2.5.
     * m=2,n=2,total=2 => m1=1, l1=a[m1-1]=2,r1=a[m1]=4;m2=total-m1=1,l2=a[m2-1]=1,r2=a[m2]=3
     * l1<=r2&&l2<=r1 => (max(l1,l2)+min(r1,r2))/2.
     * 3. [1,3] and [2]
     * m=2, n=1
     * lo=0, hi=2, m1=1, m2=0
     * l1=1, r1=3
     * l1=min, r2=2
     * ans=2 which is min(r1, r2)
     *
     * for[2,4] and [1,3,5], the merged is [1,2,3,4,5], the median is 3, index is (0+5)/2=2
     * m=2, n=3, m+n / 2=2
     * lo=0, hi=2, m1=1, m2=1
     * l1=2, r1=4
     * l2=1, r2=3
     * */
    int m = a.length, n = b.length;
    if (n < m) {
      return findMedianBs(b, a);
    }
    int lo = 0, hi = m;
    while (lo <= hi) {
      int m1 = (lo + hi) / 2;
      int m2 = (m + n) / 2 - m1;

      int l1 = (m1 - 1 >= 0) ? a[m1 - 1] : Integer.MIN_VALUE;
      int r1 = (m1 < m) ? a[m1] : Integer.MAX_VALUE;
      int l2 = (m2 - 1 >= 0) ? b[m2 - 1] : Integer.MIN_VALUE;
      int r2 = (m2 < n) ? b[m2] : Integer.MAX_VALUE;

      // found the pivots
      if (l1 <= r2 && l2 <= r1) {
        if ((m + n) % 2 == 0) {
          return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        } else {
          return Math.min(r1, r2);
        }
      }

      // shift high to the left
      if (l1 > r2) {
        hi = m1 - 1;
      } else {
        lo = m1 + 1;
      }

    }
    return 0.0;
  }
}
