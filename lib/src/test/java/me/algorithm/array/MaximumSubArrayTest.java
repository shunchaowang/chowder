package me.algorithm.array;

import static me.algorithm.array.MaximumSubArray.maxByPrefix;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MaximumSubArrayTest {

  private final Logger logger = LoggerFactory.getLogger(MaximumSubArrayTest.class);

  int[] target = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
  int expected = 6;
  int[] case2 = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
  int expected2 = -1;

  @Test
  @DisplayName("test brute force")
  void testCommonCaseBruteForce() {
    logger.info("array {} should return {}", target, expected);
    logger.info("test starting...");
    int actual = maxByPrefix(target);
    logger.info("actual result {}", actual);
    assertSame(actual, expected);
  }

  @Test
  @DisplayName("test slide window")
  void testCommonCase() {
    logger.info("array {} should return {}", target, expected);
    logger.info("test starting...");
    int actual = maxByPrefix(target);
    logger.info("actual result {}", actual);
    assertSame(actual, expected);
  }

  @Test
  void testSingleNegative() {
    int[] target = {-1};
    int expected = -1;
    logger.info("array {} should return -1", target);
    int actual = maxByPrefix(target);
    logger.info("the actual return is {}", actual);
    assertSame(expected, actual);
  }

  @Test
  @DisplayName("test all negatives {-2, -1, -3, -4, -1, -2, -1, -5, -4 }")
  void testAllNegatives() {
    int actual = maxByPrefix(case2);
    assertSame(-1, actual);
  }
}
