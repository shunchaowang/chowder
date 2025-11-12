package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RotateArrayTest {

  RotateArray rotateArray;

  @BeforeEach
  void setup() {
    rotateArray = new RotateArray();
  }

  @Test
  @DisplayName("[1,2,3,4,5,6,7] rotates 3 should have [5,6,7,1,2,3,4]")
  void test1() {

    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    int[] expected = {5, 6, 7, 1, 2, 3, 4};

    rotateArray.rotate(nums, k);

    assertArrayEquals(expected, nums);
  }

}