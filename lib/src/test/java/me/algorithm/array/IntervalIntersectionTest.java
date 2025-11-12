package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class IntervalIntersectionTest {

  private final Logger logger = LoggerFactory.getLogger(IntervalIntersectionTest.class);

  @Test
  void testIntervalIntersection() {
    int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
    int[][] expected = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
    IntervalIntersection intersection = new IntervalIntersection();
    int[][] actual = intersection.intervalIntersection(firstList, secondList);
    logger.info("Actual result is {}", Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }
}
