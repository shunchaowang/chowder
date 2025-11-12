package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TwoSumTest {

  private final Logger logger = LoggerFactory.getLogger(TwoSumTest.class);
  private int[] nums = {2, 7, 11, 15};

  @Test
  @DisplayName("Test sum of 9")
  void testSum9() {
    int[] expected = {0, 1};
    int target = 9;
    logger.info("Sum {} from array {} is elements {}", 9, nums, expected);
    int[] actual = TwoSum.findSumOfTwo(nums, target);
    logger.info("{} has the elements of {}", nums, actual);
    assertTrue(Arrays.equals(actual, expected));
  }
}
