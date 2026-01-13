package me.algorithm.heap;


/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Can you solve it without sorting?
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2 Output: 5 Example 2:
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4 Output: 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 105 -104 <= nums[i] <= 104
 */
public class KthLargestInArray {

  public static int findKthLargest(int[] nums, int k) {

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int partition = partition(nums, left, right);
      if (partition == nums.length - k) {
        return nums[partition];
      }
      if (partition < nums.length - k) {

        // the target is on the right, we need to shift left
        left = partition + 1;
      } else {
        // the target is on the left, we need to shift right
        right = partition - 1;
      }
    }
    return 0;
  }

  // we partition the nums using the last element as the pivot from non-descending order
  // return the index of the pivot position
  private static int partition(int[] nums, int lo, int hi) {

    if (lo == hi) {
      return lo;
    }
    int pivot = nums[hi];

    int i = lo;

    for (int j = lo; j < hi; j++) {
      if (nums[j] < pivot) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i++] = temp;
      }
    }

    int temp = nums[i];
    nums[i] = pivot;
    nums[hi] = temp;
    return i;
  }
}
