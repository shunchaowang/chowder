package me.algorithm.dp.grid;

import java.util.List;

/**
 * Given a binary matrix, find out the largest size square sub-matrix with all 1's and return its
 * area.
 * <p>
 * Input
 * <p>
 * matrix: a binary matrix Output
 * <p>
 * the area of the largest square in the input matrix
 * <p>
 * Examples
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * matrix = [[1, 0, 1, 0, 0], [1, 0, 1, 1, 1], [1, 1, 1, 1, 0], [1, 0, 0, 1, 0]] Output: 4
 * <p>
 * Explanation:
 * <p>
 * The largest square is of size 2x2 and area 4.
 */
public class MaximalSquare {

  // top left is (0,0), we need to initialize (0,0),(0,1),(1,0)
  // dp[i][j]=1+min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) when
  // matrix[i][j] is 1

  private int dp(int[][] m) {
    int row = m.length;
    int col = m[0].length;
    // set up the 1st row and columns
    int[][] dp = new int[row][col];
    int best = 0;

    for (int i = 0; i < col; ++i) {
      dp[0][i] = m[0][i];
      best = Math.max(best, dp[0][i]);
    }

    for (int i = 0; i < row; ++i) {
      dp[i][0] = m[i][0];
      best = Math.max(best, dp[i][0]);
    }

    for (int i = 1; i < row; ++i) {
      for (int j = 1; j < col; ++j) {
        if (m[i][j] == 0) {
          continue;
        }
        dp[i][j] = 1
            + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
        best = Math.max(best, dp[i][j]);
      }
    }
    return best * best;
  }

  public int maximalSquare(List<List<Integer>> matrix) {

    if (matrix == null || matrix.isEmpty()) {
      return 0;
    }
    if (matrix.size() == 1) {
      return matrix.getFirst().getFirst();
    }

    // create the matrix
    int row = matrix.size();
    int col = matrix.getFirst().size();

    int[][] m = new int[row][col];

    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        m[i][j] = matrix.get(i).get(j);
      }
    }

    return dp(m);
  }
}
