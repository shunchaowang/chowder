package me.algorithm.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a
 * Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and
 * alternating direction each row.
 * <p>
 * You start on square 1 of the board. In each move, starting from square curr, do the following:
 * <p>
 * Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)]. This
 * choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6
 * destinations, regardless of the size of the board. If next has a snake or ladder, you must move
 * to the destination of that snake or ladder. Otherwise, you move to next. The game ends when you
 * reach the square n2. A board square on row r and column c has a snake or ladder if board[r][c] !=
 * -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting
 * points of any snake or ladder.
 * <p>
 * Note that you only take a snake or ladder at most once per dice roll. If the destination to a
 * snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake
 * or ladder.
 * <p>
 * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square
 * is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4. Return the
 * least number of dice rolls required to reach the square n2. If it is not possible to reach the
 * square, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board =
 * [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
 * Output: 4 Explanation: In the beginning, you start at square 1 (at row 5, column 0). You decide
 * to move to square 2 and must take the ladder to square 15. You then decide to move to square 17
 * and must take the snake to square 13. You then decide to move to square 14 and must take the
 * ladder to square 35. You then decide to move to square 36, ending the game. This is the lowest
 * possible number of moves to reach the last square, so return 4. Example 2:
 * <p>
 * Input: board = [[-1,-1],[-1,3]] Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == board.length == board[i].length 2 <= n <= 20 board[i][j] is either -1 or in the range [1,
 * n2]. The squares labeled 1 and n2 are not the starting points of any snake or ladder.
 */
public class SnakesAndLadders {

  public int snakesAndLadders(int[][] board) {

    // we start from 1, this is dfs, we use the queue to store all the neighbors, until we reach to n^2 or the queue is empty
    // when the queue is empty, means either we hit a cycle or it's impossible to reach to the end.
    int n = board.length;
    int[] minRolls = new int[n * n + 1];
    Arrays.fill(minRolls, -1); // initially no cell is visited
    minRolls[1] = 0; // we start at 1, so 1 is 0 rolls min

    Deque<Integer> queue = new LinkedList<>();
    queue.add(1); // we start at 1

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      // we need to find all the neighbors of cur
      for (int i = cur + 1; i <= Math.min(cur + 6, n * n); i++) {
        // if cur has snake or ladder, jump if can
        // convert cur into the grip coordinates
        int rowBase = (i - 1) / n;
        int row = (n - 1) - rowBase;

        int col = (i - 1) % n; // if this is the even row
        if (rowBase % 2 != 0) {
          col = (n - 1) - col; // this is an odd row
        }

        int y = (board[row][col] == -1 ? i : board[row][col]);
        if (y == n * n) {
          return minRolls[cur] + 1;
        }
        if (minRolls[y] == -1) { // never visited
          minRolls[y] = minRolls[cur] + 1;
          queue.offer(y);
        }
      }
    }

    return -1;
  }
}
