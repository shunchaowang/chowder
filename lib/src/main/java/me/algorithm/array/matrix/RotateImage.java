package me.algorithm.array.matrix;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees
 * (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix
 * directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[7,4,1],[8,5,2],[9,6,3]] Example 2:
 * <p>
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] Output:
 * [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * Constraints:
 * <p>
 * n == matrix.length == matrix[i].length 1 <= n <= 20 -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {

  public void rotate(int[][] matrix) {

    // we can rotate the loops until reaching to the core of the matrix

    int n = matrix.length;
    for (int j = 0; j < n / 2; j++) {
      // the shrinking on both sides are i/2
      // save the first row to temp, then do the following
      // 1. copy 1st column to the first row
      // 2. copy the bottom row to the 1st column
      // 3. copy the last column to the bottom row
      // 4. copy the temp to the last column

//      int leftIndex = j; // top is the same
      int rightIndex = n - j - 1; // bottom is the same

      for (int i = 0; i < n - j * 2 - 1; i++) {
        int temp = matrix[j][rightIndex - i];
        // left to top m[i:l..r][leftIndex]=>m[leftIndex][rightIndex - i]
        matrix[j][rightIndex - i] = matrix[j + i][j];
        // bottom to left m[rightIndex][i:l..r] => m[leftIndex][i:l..r]
        matrix[j + i][j] = matrix[rightIndex][j + i];
        // right to bottom m[i:l..r][rightIndex] => m[rightIndex][rightIndex - i]
        matrix[rightIndex][j + i] = matrix[rightIndex - i][rightIndex];
//        m[rightIndex - i][rightIndex] = m[leftIndex][rightIndex - i]; // top to right
        matrix[rightIndex - i][rightIndex] = temp;
      }
    }
  }
}
