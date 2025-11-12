package me.algorithm.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PerfectSquaresTest {

  @Test
  @DisplayName("13's perfect squares result should be 2. 13=4+9")
  void test13() {

    var perfectSquares = new PerfectSquares();

    assertEquals(2, perfectSquares.perfectSquares(13));
  }

  @Test
  @DisplayName("10000 should return 2, 10000=100*100")
  void test10000() {

    var perfectSquares = new PerfectSquares();
    assertEquals(1, perfectSquares.perfectSquares(10000));
  }

  @Test
  @DisplayName("5360 should have 4")
  void test5360() {

    var perfectSquares = new PerfectSquares();
    assertEquals(4, perfectSquares.perfectSquares(5360));

  }
}