package me.algorithm.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,2,3,6,9,8,7,4,5] Example 2:
 * <p>
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length n == matrix[i].length 1 <= m, n <= 10 -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;
    List<Integer> result = new ArrayList<>();

    spiral(matrix, 0, 0, n - 1, m - 1, result);
    return result;

  }

  private void spiral(int[][] matrix, int left, int top, int right, int bottom,
      List<Integer> result) {
    // edge case is only 1 row or col remaining, just return it
    // right -> down -> left -> up
    // (left=1,top=1,right=2,bottom=1)
    if (left > right || top > bottom) {
      return;
    }

    if (left == right) {
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][left]);
      }
      return;
    }

    if (top == bottom) {

      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      return;
    }

    for (int i = left; i <= right; i++) { // i: [1..2] top=1 result.add(6,7)
      result.add(matrix[top][i]);
    }

    for (int i = top + 1; i <= bottom; i++) { // i:[2..1] right=2
      result.add(matrix[i][right]);
    }

    for (int i = right - 1; i >= left; i--) { // i:[1..1] bottom=1 result.add(6)
      result.add(matrix[bottom][i]);
    }

    for (int i = bottom - 1; i >= top + 1; i--) { // i: [1..1] left=0
      result.add(matrix[i][left]);
    }

    spiral(matrix, left + 1, top + 1, right - 1, bottom - 1,
        result);
  }
}
