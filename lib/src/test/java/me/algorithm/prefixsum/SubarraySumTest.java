package me.algorithm.prefixsum;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SubarraySumTest {

  @Test
  void subarraySumTest() {

    var nums = List.of(1, 3, -3, 8, 5, 7);
    var target = 5;

    var subarraySum = new SubarraySum();

    List<Integer> actual = subarraySum.subarraySum(nums, target);
    assertIterableEquals(List.of(2, 4), actual);
  }

}