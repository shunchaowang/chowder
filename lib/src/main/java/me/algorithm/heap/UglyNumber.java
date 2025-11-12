package me.algorithm.heap;

/**
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example 1:
 * <p>
 * Input:n = 10
 * <p>
 * Output: 12
 * <p>
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p>
 * Note:
 * <p>
 * 1 is typically treated as an ugly number. n does not exceed 1690.
 */
public class UglyNumber {

  public int nthUglyNumber(int n) {
    int[] uglyNumbers = new int[n];
    uglyNumbers[0] = 1;//uglyNumbers[n-1] is the result

    int pt2 = 0, pt3 = 0, pt5 = 0;
    int numberPt2, numberPt3, numberPt5;

    for (int i = 1; i < n; ++i) {
      numberPt2 = uglyNumbers[pt2] * 2;
      numberPt3 = uglyNumbers[pt3] * 3;
      numberPt5 = uglyNumbers[pt5] * 5;
      int uglyNumber = Math.min(Math.min(numberPt2, numberPt3), numberPt5);
      uglyNumbers[i] = uglyNumber;

      // increase the pointer
      if (uglyNumber == numberPt2) {
        ++pt2;
      }
      if (uglyNumber == numberPt3) {
        ++pt3;
      }
      if (uglyNumber == numberPt5) {
        ++pt5;
      }

    }

    return uglyNumbers[n - 1];
  }
}
