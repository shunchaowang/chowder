package me.algorithm.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinimalGraphTravelTest {

  @Test
  @DisplayName("""
      Test [
          [0, 100, 100, 1],
          [0, 0, 100, 0],
          [0, 1, 0, 0],
          [0, 20, 1, 0]
        ] should return 3""")
  public void case1() {

    List<Integer> row0 = List.of(0, 100, 100, 1);
    List<Integer> row1 = List.of(0, 0, 100, 0);
    List<Integer> row2 = List.of(0, 1, 0, 0);
    List<Integer> row3 = List.of(0, 20, 1, 0);

    List<List<Integer>> graph = List.of(row0, row1, row2, row3);

    MinimalGraphTravel graphTravel = new MinimalGraphTravel();

    int actual = graphTravel.minCostToVisitEveryNode(graph);

    assertEquals(3, actual);
  }

}