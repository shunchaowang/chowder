package me.algorithm.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnakesAndLaddersTest {

  SnakesAndLadders snakesAndLadders;

  @BeforeEach
  void setUp() {
    snakesAndLadders = new SnakesAndLadders();
  }

  @Test
  void testSnakesAndLadders() {
    int[][] board = new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1},
        {-1, 15, -1, -1, -1, -1}};

    int actual = snakesAndLadders.snakesAndLadders(board);

    assertEquals(4, actual);
  }
}