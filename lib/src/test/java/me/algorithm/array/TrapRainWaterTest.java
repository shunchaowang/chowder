package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrapRainWaterTest {

  TrapRainWater trapRainWater;

  @BeforeEach
  void setup() {
    trapRainWater = new TrapRainWater();
  }

  @Test
  @DisplayName("[0,1,0,2,1,0,1,3,2,1,2,1] should have 6")
  void test1() {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int expected = 6;
    assertEquals(expected, trapRainWater.trap(height));
  }

  @Test
  @DisplayName("[4,2,0,3,2,5] should have 9")
  void test2() {
    int[] height = {4, 2, 0, 3, 2, 5};
    int expected = 9;
    assertEquals(expected, trapRainWater.trap(height));
  }

}