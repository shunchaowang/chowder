package me.algorithm.array;

public class ArrayUtils {

  private ArrayUtils() {
  }

  public static int[] mergeTwoSortedArray(int[] nums1, int[] nums2) {

    int[] result = new int[nums1.length + nums2.length];
    int index1 = 0;
    int index2 = 0;
    int i = 0;
    while (index1 < nums1.length && index2 < nums2.length) {
      if (nums1[index1] < nums2[index2]) {
        result[i++] = nums1[index1++];
      } else {
        result[i++] = nums2[index2++];
      }
    }

    // copy the rest of nums1 or nums2 into the rest of result
    while (index1 < nums1.length) {
      result[i++] = nums1[index1++];
    }
    while (index2 < nums2.length) {
      result[i++] = nums2[index2++];
    }
    return result;
  }
}
