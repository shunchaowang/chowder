package me.algorithm.array.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameOfLifeTest {

  GameOfLife gameOfLife;

  @BeforeEach
  void setUp() {
    gameOfLife = new GameOfLife();
  }

  @Test
  void test1() {
    int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
    int[][] expected = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};

    gameOfLife.gameOfLife(board);

    assertArrayEquals(expected, board);
  }
}