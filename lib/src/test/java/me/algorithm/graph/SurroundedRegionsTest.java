package me.algorithm.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SurroundedRegionsTest {

  SurroundedRegions surroundedRegions;

  @BeforeEach
  void setUp() {
    surroundedRegions = new SurroundedRegions();
  }

  @Test
  void test1() {
    char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    char[][] expected = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'},
        {'X', 'O', 'X', 'X'}};
    surroundedRegions.solve(board);
    assertArrayEquals(board, expected);
  }

  @Test
  void test2() {
    char[][] board = {{'O', 'O'}, {'O', 'O'}};
    char[][] expected = {{'O', 'O'}, {'O', 'O'}};
    surroundedRegions.solve(board);
    assertArrayEquals(board, expected);
  }

}