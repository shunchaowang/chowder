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

  public static double findMedian(final int[] nums1, final int[] nums2) {

    // if any is empty
//    if (nums1.length == 0 && nums2.length == 0) {
//      return 0.0;
//    }
//    if (nums1.length == 0) {
//      if (nums2.length % 2 == 0) {
//        return (double) (nums2[(nums2.length - 1) / 2] + nums2[(nums2.length - 1) / 2 + 1]) / 2;
//      } else {
//        return nums2[(nums2.length - 1) / 2];
//      }
//    }
//    if (nums2.length == 0) {
//      if (nums1.length % 2 == 0) {
//        return (double) (nums1[(nums1.length - 1) / 2] + nums1[(nums1.length - 1) / 2 + 1]) / 2;
//      } else {
//        return nums1[(nums1.length - 1) / 2];
//      }
//    }
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
    while (l <= r) {
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

    // it means all items in A are not less than any items in B, median is in B from the start
    if (r < 0) {
      if (total % 2 == 0) {
        return (double) (b[total / 2 - 1] + b[total / 2]) / 2;
      } else {
        return b[total / 2];
      }
    }

    // it means all items in A are not larger than any items in B, median is in B from start to total / 2 - a.length
    if (l >= a.length) {
      if (total % 2 == 0) {
        return (double) (b[total / 2 - a.length] + b[total / 2 - a.length - 1]) / 2;
      } else {
        return b[total / 2 - a.length];
      }
    }

    return 0.0;
  }
}
