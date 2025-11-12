package me.algorithm.array;

import static me.algorithm.array.RemoveDuplicatesFromSortedArray.removeDuplicates;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RemoveDuplicatesFromSortedArrayTest {

  private static Logger logger = LoggerFactory.getLogger(RemoveDuplicatesFromSortedArrayTest.class);
  private int[] case1 = {1, 3, 3, 3, 4, 4, 6};

  @BeforeAll
  static void setup() {
    logger.info("setup for the tests goes here");
  }

  @Test
  void testUniqueArray() {
    assertTrue(Stream.of(1, 2, 3).mapToInt(i -> i).sum() > 5, () -> "Sum should be greater than 5");
  }

  @Test
  @DisplayName("Test the common case of {1, 3, 3, 3, 4, 4, 6}")
  void testCommonCase() {
    int l = removeDuplicates(case1);
    int[] expected = {1, 3, 4, 6, '_', '_', '_'};
    assertEquals(4, l);
    assertTrue(
        Arrays.equals(expected, case1), "{ 1, 3, 3, 3, 4, 4, 6 } should become {1, 3, 4 ,6}");
  }

  @Test
  @DisplayName("Test the empty array")
  void testEmptyArray() {
    int[] target = {};
    assertEquals(0, removeDuplicates(target), "Empty array should return empty");
  }

  @Test
  @DisplayName("Test the array of single element")
  void testsingleElementArray() {
    int[] target = {2};
    assertEquals(1, removeDuplicates(target));
  }
}
