package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxSumCircularArrayTest {

  @Test
  @DisplayName("[2,-2,2,7,8,0] should have max of 19")
  void case1() {
    int[] nums = new int[]{2, -2, 2, 7, 8, 0};
    MaxSumCircularArray maxSumCircularArray = new MaxSumCircularArray();
    assertEquals(19, maxSumCircularArray.maxSubarraySumCircular(nums));
  }
}