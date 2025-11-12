package me.algorithm.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Find2ndLargestItemInArrayTest {

  private final Logger logger = LoggerFactory.getLogger(Find2ndLargestItemInArrayTest.class);
  private final int[] commonCase = {3, 4, 2, 1, 8, 9};
  private final int[] arrayOfSingleElements = {3};
  private final int[] arrayOfSameElements = {3, 3, 3};

  @DisplayName("2nd largest element in {3, 4, 2, 1, 8, 9} should be 8")
  @Test
  void testCommon() {
    int actual = Find2ndLargestItemInArray.find(commonCase);
    assertEquals(8, actual);
  }

  @DisplayName("Single array {3} should not have 2nd largest element")
  @Test
  void testSingleArray() {
    assertEquals(Integer.MIN_VALUE, Find2ndLargestItemInArray.find(arrayOfSingleElements));
  }

  @DisplayName("array {3,3} should not have 2nd largest element")
  @Test
  void testArrayOfSameElements() {
    assertEquals(Integer.MIN_VALUE, Find2ndLargestItemInArray.find(arrayOfSingleElements));
  }
}
