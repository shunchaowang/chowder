package me.algorithm.array.matrix;

import java.util.Arrays;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular
 * automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live
 * (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors
 * (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * <p>
 * Any live cell with fewer than two live neighbors dies as if caused by under-population. Any live
 * cell with two or three live neighbors lives on to the next generation. Any live cell with more
 * than three live neighbors dies, as if by over-population. Any dead cell with exactly three live
 * neighbors becomes a live cell, as if by reproduction. The next state of the board is determined
 * by applying the above rules simultaneously to every cell in the current state of the m x n grid
 * board. In this process, births and deaths occur simultaneously.
 * <p>
 * Given the current state of the board, update the board to reflect its next state.
 * <p>
 * Note that you do not need to return anything.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]] Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: board = [[1,1],[1,0]] Output: [[1,1],[1,1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length n == board[i].length 1 <= m, n <= 25 board[i][j] is 0 or 1.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You
 * cannot update some cells first and then use their updated values to update other cells. In this
 * question, we represent the board using a 2D array. In principle, the board is infinite, which
 * would cause problems when the active area encroaches upon the border of the array (i.e., live
 * cells reach the border). How would you address these problems?
 */
public class GameOfLife {

  public void gameOfLife(int[][] board) {
    fn1(board);
  }

  /**
   * this can be optimized to use O(n) space complexity, we only need to store the previous row of
   * the original matrix, plus the previous cell to the current cell. as long as we are moving the
   * cell, we keep updating the prev cell, when we shift 1 row, we update the ref to be the prev
   * row.
   */
  private void fn1(int[][] board) {
    int m = board.length, n = board[0].length;

    int[] prevRow = new int[n];

    for (int i = 0; i < m; i++) {
      int[] currRow = Arrays.copyOf(board[i], n);
      int prevCell = 0;
      for (int j = 0; j < n; j++) {
        int liveNeighbors = liveNeighbors(board, i, j, prevRow, prevCell);
        prevCell = board[i][j];

        if (board[i][j] == 1) {
          if (liveNeighbors < 2 || liveNeighbors > 3) {
            board[i][j] = 0;
          }
        } else {
          if (liveNeighbors == 3) {
            board[i][j] = 1;
          }
        }
      }
      prevRow = currRow;
    }
  }

  private int liveNeighbors(int[][] board, int i, int j, int[] prevRow, int prevCell) {
    int sum = 0;
    // get lives for i-1 r, should be prevRow[j-1]+prevRow[j]+prevRow[j+1]
    for (int k = -1; k <= 1; k++) {
      int col = j + k;
      if (col < 0 || col >= prevRow.length) {
        continue;
      }
      sum += prevRow[col];
    }

    // get lives for i row, should prevCell + board[i][j+1]
    sum += prevCell;
    if (j + 1 < prevRow.length) {
      sum += board[i][j + 1];
    }
    // get lives for i+1 row
    if (i + 1 < board.length) {
      for (int k = -1; k <= 1; k++) {
        int col = j + k;
        if (col < 0 || col >= prevRow.length) {
          continue;
        }
        sum += board[i + 1][col];
      }
    }

    return sum;
  }
}
