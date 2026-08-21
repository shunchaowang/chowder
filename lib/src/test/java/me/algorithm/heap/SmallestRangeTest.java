package me.algorithm.heap;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SmallestRangeTest {

  @Test
  @DisplayName("[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]] should return [20,24]")
  void test1() {
    List<List<Integer>> nums = List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20),
        List.of(5, 18, 22, 30));
    SmallestRange smallestRange = new SmallestRange();
    int[] expected = new int[]{20, 24};
    int[] actual = smallestRange.smallestRange(nums);
    Assertions.assertArrayEquals(expected, actual);
  }
}