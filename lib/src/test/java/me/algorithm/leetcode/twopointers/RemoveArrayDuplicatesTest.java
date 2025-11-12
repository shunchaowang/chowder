package me.algorithm.leetcode.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RemoveArrayDuplicatesTest {

  @Test
  void removeArrayDuplicates() {
    int[] nums = {2, 3, 3, 3, 6, 9, 9};
    int expected = 4;
    assertEquals(expected, RemoveArrayDuplicates.removeArrayDuplicates(nums));
  }
}
