package me.algorithm.divideconquer;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlgorithmSwapTest {

  private AlgorithmSwap algorithmSwap;

  @BeforeEach
  void setUp() {
    algorithmSwap = new AlgorithmSwap();

  }

  @Test
  void testCase1() {

    List<Integer> nums = List.of(1, 9, 7, 8, 5);
    List<Integer> expected = List.of(0, 3, 1, 1, 0);

    List<Integer> actual = algorithmSwap.countSmaller(nums);

    assertIterableEquals(expected, actual);
  }

}