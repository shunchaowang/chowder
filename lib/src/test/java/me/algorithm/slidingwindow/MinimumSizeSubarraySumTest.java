package me.algorithm.slidingwindow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class MinimumSizeSubarraySumTest {

  @Test
  void testCase1() {
    int[] nums = {2, 3, 1, 2, 4, 3};
    int target = 7;

    int expected = 2;

    int actual = new MinimumSizeSubarraySum().minSubArrayLen(target, nums);
    Assertions.assertEquals(expected, actual);
  }

}