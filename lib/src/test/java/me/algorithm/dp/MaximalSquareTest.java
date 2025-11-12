package me.algorithm.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import me.algorithm.dp.grid.MaximalSquare;
import org.junit.jupiter.api.Test;

/**
 * This test covers various cases, including:
 * <p>
 * A standard matrix with a mix of 1s and 0s. A small 2x2 matrix with no possible large square. A
 * 2x2 matrix entirely filled with 1s. A matrix with only 0s. A matrix with a single element.
 */
class MaximalSquareTest {

  @Test
  public void testMaximalSquare() {
    MaximalSquare solver = new MaximalSquare();

    List<List<Integer>> matrix1 = Arrays.asList(
        Arrays.asList(1, 0, 1, 0, 0),
        Arrays.asList(1, 0, 1, 1, 1),
        Arrays.asList(1, 1, 1, 1, 1),
        Arrays.asList(1, 0, 0, 1, 0)
    );
    assertEquals(4, solver.maximalSquare(matrix1));

    List<List<Integer>> matrix2 = Arrays.asList(
        Arrays.asList(0, 1),
        Arrays.asList(1, 0)
    );
    assertEquals(1, solver.maximalSquare(matrix2));

    List<List<Integer>> matrix3 = Arrays.asList(
        Arrays.asList(1, 1),
        Arrays.asList(1, 1)
    );
    assertEquals(4, solver.maximalSquare(matrix3));

    List<List<Integer>> matrix4 = Arrays.asList(
        Arrays.asList(0, 0, 0),
        Arrays.asList(0, 0, 0),
        Arrays.asList(0, 0, 0)
    );
    assertEquals(0, solver.maximalSquare(matrix4));

    List<List<Integer>> matrix5 = List.of(
        List.of(1)
    );
    assertEquals(1, solver.maximalSquare(matrix5));
  }

}