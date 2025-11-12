package me.algorithm.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.algorithm.dp.grid.OnesAndZeroes;
import org.junit.jupiter.api.Test;

class OnesAndZeroesTest {

  OnesAndZeroes onesAndZeros = new OnesAndZeroes();

  @Test
  void testCase1() {
    var strings = new String[]{"10", "0001", "111001", "1", "0"};
    int m = 5, n = 3, expected = 4;

    assertEquals(expected, onesAndZeros.findMaxForm(strings, m, n));
  }

  @Test
  void testCase2() {
    var strings = new String[]{"10", "0", "1"};
    int m = 1, n = 1, expected = 2;

    assertEquals(expected, onesAndZeros.findMaxForm(strings, m, n));
  }

}