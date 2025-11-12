package me.algorithm.backtracking;


/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
 * queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4 Output: 2 Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown. Example 2:
 * <p>
 * Input: n = 1 Output: 1
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 9
 */
public class NQueenII {

  int ans = 0;
  int curr = 0;

  public int totalNQueens(int n) {

    boolean[] cols = new boolean[n];
    boolean[] rightDiagonals = new boolean[2 * n - 1];
    boolean[] leftDiagonals = new boolean[2 * n - 1];
    placeQueens(n, 0, cols, rightDiagonals, leftDiagonals);
    return ans;
  }

  // instead of checking if the position is available to place the queen using the list,
  // we can use 3 arrays:
  // 1 array to store if the col is already ocupied
  // another right diagonal array if the top-left to bottom-right diagonal is occupied
  // another left diagonal array for the top-right to bottom-left diagonal is occupied
  // consider the chessboard is 2 dimensional array, we make the top left corner as the start of [0,0]
  // for each cell [i,j] the cols[j] means if the column is occupied;
  // \ right diagonal to use i-j, since i-j would be from -(n-1) to n-1, we need to add n-1 to avoid negative index;
  // so rightDiagonals[i-j+n-1] indicates if the right diagonal is occupied, should have 2n-1
  //  / left diagonal to use i+j, rightDiagonals[i+j, should have 2n-1
  // time complexity is O(n!), space is reduced to be O(n) + n for the recursion call

  private void placeQueens(int n, int r, boolean[] cols, boolean[] rightDiagonals,
      boolean[] leftDiagonals) {
    for (int i = r; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (cols[j] || rightDiagonals[i - j + n - 1] || leftDiagonals[i + j]) {
          continue;
        }

        curr++;
        if (curr == n) {
          ans++;
          curr--;
          continue;
        }

        cols[j] = true;
        rightDiagonals[i - j + n - 1] = true;
        leftDiagonals[i + j] = true;
        placeQueens(n, i + 1, cols, rightDiagonals, leftDiagonals);

        curr--;
        cols[j] = false;
        rightDiagonals[i - j + n - 1] = false;
        leftDiagonals[i + j] = false;
      }

    }
  }

}
