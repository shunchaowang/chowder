package me.algorithm.array;

/**
 * leetcode
 *
 * <p>Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should be
 * kept the same.
 *
 * <p>Since it is impossible to change the length of the array in some languages, you must instead
 * have the result be placed in the first part of the array nums. More formally, if there are k
 * elements after removing the duplicates, then the first k elements of nums should hold the final
 * result. It does not matter what you leave beyond the first k elements.
 *
 * <p>Return k after placing the final result in the first k slots of nums.
 *
 * <p>Do not allocate extra space for another array. You must do this by modifying the input array
 * in-place with O(1) extra memory. Examples:
 *
 * <ul>
 *   <li>Input: nums = [1,1,2] Output: 2, nums = [1,2,_] Explanation: Your function should return k
 *       = 2, with the first two elements of nums being 1 and 2 respectively. It does not matter
 *       what you leave beyond the returned k (hence they are underscores).
 *   <li>Input: nums = [0,0,1,1,1,2,2,3,3,4] Output: 5, nums = [0,1,2,3,4,_,_,_,_,_] Explanation:
 *       Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3,
 *       and 4 respectively. It does not matter what you leave beyond the returned k (hence they are
 *       underscores).
 * </ul>
 */
public class RemoveDuplicatesFromSortedArray {

  private RemoveDuplicatesFromSortedArray() {
  }

  /**
   * @param arr
   * @return int
   */
  public static int removeDuplicates(int[] arr) {
    if (arr == null) {
      return 0;
    }
    if (arr.length < 2) {
      return arr.length;
    }
    // 1 3 3 3 4 4 6 -> 1 3 4 6
    int slowIndex = 0;
    for (int fastIndex = slowIndex + 1; fastIndex < arr.length; fastIndex++) {
      if (arr[fastIndex] != arr[slowIndex]) {
        arr[++slowIndex] = arr[fastIndex];
      }
      if (fastIndex != slowIndex) {
        arr[fastIndex] = '_';
      }
    }
    return slowIndex + 1;
  }
}
