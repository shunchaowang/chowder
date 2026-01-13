package me.algorithm.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthLargestInArrayTest {

  @Test
  void case1() {
    int[] nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    int expected = 5;
    int actual = KthLargestInArray.findKthLargest(nums, k);
    assertEquals(expected, actual);
  }
}