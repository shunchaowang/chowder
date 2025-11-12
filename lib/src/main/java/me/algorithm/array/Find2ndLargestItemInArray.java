package me.algorithm.array;

class Find2ndLargestItemInArray {

  /**
   * array [3, 4, 2, 1, 8, 9]
   *
   * @param arr
   * @return
   */
  public static int find(final int[] arr) {
    if (arr == null || arr.length < 2) {
      return Integer.MIN_VALUE;
    }
    // two elements to store the largest and 2nd largest
    int largest = Integer.MIN_VALUE;
    int largest2nd = Integer.MIN_VALUE;

    // 3 -> l = 3
    // 4 -> l = 4, l2=min
    // 2 ->
    for (int i : arr) {
      if (i > largest) {
        largest2nd = largest;
        largest = i;
      }
    }

    return largest2nd;
  }
}
