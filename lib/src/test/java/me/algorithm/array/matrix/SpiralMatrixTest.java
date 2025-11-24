package me.algorithm.array.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SpiralMatrixTest {

  private final Logger log = LoggerFactory.getLogger(SpiralMatrixTest.class);
  SpiralMatrix spiralMatrix;

  @BeforeEach
  void setUp() {
    spiralMatrix = new SpiralMatrix();
  }

  @Test
  void test1() {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> actual = spiralMatrix.spiralOrder(matrix);
    log.info("actual={}", actual);
    assertEquals(actual, Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
  }

}