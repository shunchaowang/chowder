package me.algorithm.array;

public class ArrayUtils {

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

  public void sort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  // in place quick sort
  private void quickSort(int[] nums, int s, int e) {
    if (s < e) {
      int partition = partition(nums, s, e);
      quickSort(nums, s, partition - 1);
      quickSort(nums, partition, e);
    }
  }

  // we partition the nums from s to e
  private int partition(int[] nums, int s, int e) {

    int m = (s + e) / 2;
    int pivot = nums[m];

    int l = s, r = e;

    while (l <= r) {
      while (nums[l] < pivot) {
        l++;
      }
      while (nums[r] > pivot) {
        r--;
      }
      if (l <= r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
        l++;
        r--;
      }
    }
    return l;
  }
}
