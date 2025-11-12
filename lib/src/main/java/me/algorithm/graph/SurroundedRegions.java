package me.algorithm.graph;

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are
 * surrounded:
 * <p>
 * Connect: A cell is connected to adjacent cells horizontally or vertically. Region: To form a
 * region connect every 'O' cell. Surround: The region is surrounded with 'X' cells if you can
 * connect the region with 'X' cells and none of the region cells are on the edge of the board. To
 * capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You
 * do not need to return anything.
 * <p>
 * Example 1:
 * <p>
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * <p>
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * <p>
 * Explanation:
 * <p>
 * In the above diagram, the bottom region is not captured because it is on the edge of the board
 * and cannot be surrounded.
 * <p>
 * Example 2:
 * <p>
 * Input: board = [["X"]]
 * <p>
 * Output: [["X"]]
 * <p>
 * Constraints:
 * <p>
 * m == board.length n == board[i].length 1 <= m, n <= 200 board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegions {

  public void solve(char[][] board) {
    // find all the islands of 'o' with edges included
    // we need to find all the Os on the edges and connected Os to mark them uncapturable
    int m = board.length;
    int n = board[0].length;

    // first row
    // last row
    // first col
    // last col
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // when we find a O on the edge mark all the connected Os to be U
        if (board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
          dfs(board, i, j); // mark all Os to be Us
        }
      }
    }

    // iterate again to mark all X except U
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'U') {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }

  }

  private void dfs(char[][] board, int i, int j) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
        || board[i][j] != 'O') { // we return if there is no O
      return;
    }

    board[i][j] = 'U';
    // all neighbors
    dfs(board, i, j + 1);
    dfs(board, i + 1, j);
    dfs(board, i, j - 1);
    dfs(board, i - 1, j);
  }
}
