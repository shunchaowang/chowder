package me.algorithm.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SkylineTest {

  @Test
  @DisplayName("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]] should have [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]")
  void test1() {

    int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    List<List<Integer>> expected = List.of(
        List.of(2, 10),
        List.of(3, 15),
        List.of(7, 12),
        List.of(12, 0),
        List.of(15, 10),
        List.of(20, 8),
        List.of(24, 0)
    );

    List<List<Integer>> actual = Skyline.getSkyline(buildings);
    assertEquals(expected, actual);

  }
}