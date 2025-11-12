package me.algorithm.array;

/**
 * leetcode
 *
 * <p>Given an array which represents a number, add 1 to the array.
 *
 * <p>Suppose an array contain elements [1, 2, 3, 4] then the array represents decimal number 1234
 * and hence adding 1 to this would result 1235. So new array will be [1, 2, 3, 5].
 *
 * <p>Examples:
 *
 * <ul>
 *   <li>Input : [1, 2, 3, 4] Output : [1, 2, 3, 5]
 *   <li>Input : [1, 2, 9, 9] Output : [1, 3, 0, 0]
 *   <li>Input: [9, 9, 9, 9] Output: [1, 0, 0, 0, 0]
 * </ul>
 */
public class ArrayPlusOne {

  public void recursivePlusOne(int[] digits, int n) {
    int i = n;

    if (digits[i] < 9) {
      digits[i] = digits[i] + 1;
      return;
    }

    // if i == 0 it means one more element needs to be added
    // and i == 0 is the exit condition for the recursion
    if (i == 0) {
      // copy the array to a new array of length + 1
      digits = addLeading0ToArray(digits);
      i++;
    }
    digits[i] = 0;
    i--;

    // if i > 0,
    recursivePlusOne(digits, i);
  }

  public int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) {
      return new int[0];
    }

    int i = digits.length - 1;

    while (i >= 0) {
      if (digits[i] != 9) {
        digits[i] = digits[i] + 1;
        return digits;
      }

      digits[i] = 0;
      i--;
    }

    int[] res = addLeading0ToArray(digits);
    res[0] = 1;
    return res;
  }

  private int[] addLeading0ToArray(int[] arr) {
    int[] newArr = new int[arr.length + 1];
    newArr[0] = 0;
    System.arraycopy(arr, 0, newArr, 1, arr.length);
    return newArr;
  }
}
