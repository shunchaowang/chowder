package me.algorithm.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MinimumSizeSubarraySumTest {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  void testCase1() {
    int[] nums = {2, 3, 1, 2, 4, 3};
    int target = 7;

    int expected = 2;

    int actual = new MinimumSizeSubarraySum().minSubArrayLen(target, nums);
    Assertions.assertEquals(expected, actual);
  }

}