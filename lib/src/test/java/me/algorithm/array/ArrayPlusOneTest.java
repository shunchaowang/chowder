package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ArrayPlusOneTest {

  private final Logger logger = LoggerFactory.getLogger(ArrayPlusOneTest.class);
  private final ArrayPlusOne arrayPlusOne = new ArrayPlusOne();

  @Test
  @DisplayName("Test {1, 2, 3, 4}")
  void testCommonCase() {
    int[] target = {1, 2, 3, 4};
    int[] expected = {1, 2, 3, 5};
    logger.info("{} + 1 becomes {}", Arrays.toString(target), Arrays.toString(expected));
    assertArrayEquals(arrayPlusOne.plusOne(target), expected);
  }

  @Test
  @DisplayName("Test { 1, 2, 9, 9 }")
  void testCarryInMiddle() {
    int[] target = {1, 2, 9, 9};
    int[] expected = {1, 3, 0, 0};
    assertArrayEquals(arrayPlusOne.plusOne(target), expected);
  }

  @Test
  @DisplayName("Test { 9, 9, 9, 9 }")
  void testCarryLeading() {
    int[] target = {9, 9, 9, 9};
    int[] expected = {1, 0, 0, 0, 0};
    assertArrayEquals(arrayPlusOne.plusOne(target), expected);
  }
}
