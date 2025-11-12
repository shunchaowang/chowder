package me.algorithm.leetcode.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FruitsIntoBasketsTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(FruitsIntoBasketsTest.class);

  @Test
  void findCharFruits() {
    int[] arr = new int[26];
    LOGGER.info("Check int array init {}", Arrays.toString(arr));
    arr['A' - 'A'] = 1;
    LOGGER.info("Check int array index auto conversion {}", Arrays.toString(arr));

    char[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
    assertEquals(5, FruitsIntoBaskets.findCharFruits(fruits));

    char[] fruits2 = {'C', 'C', 'C', 'A', 'B', 'A', 'A', 'B', 'C', 'C', 'D'};
    assertEquals(5, FruitsIntoBaskets.findCharFruits(fruits2));
  }

  @Test
  void findIntFruits() {
    int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
    int expected = 5;
    assertEquals(expected, FruitsIntoBaskets.findIntFruits(fruits));
  }

  @Test
  void findFruitsOptimally() {
    int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
    int expected = 5;
    assertEquals(expected, FruitsIntoBaskets.findFruitsOptimally(fruits));
  }
}
