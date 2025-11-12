package me.algorithm.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NQueenIITest {

  @Test
  @DisplayName("4X4 should have 2 ways to place the 4 queens")
  void case1() {
    NQueenII nq = new NQueenII();
    assertEquals(2, nq.totalNQueens(4));
  }

  @Test
  @DisplayName("4X4 should have 2 ways to place the 4 queens")
  void case2() {
    NQueenII nq = new NQueenII();
    assertEquals(10, nq.totalNQueens(5));
  }
}