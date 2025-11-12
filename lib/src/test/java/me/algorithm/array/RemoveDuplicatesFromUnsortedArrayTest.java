package me.algorithm.array;

import static me.algorithm.array.RemoveDuplicatesFromUnsortedArray.removeByMap;
import static me.algorithm.array.RemoveDuplicatesFromUnsortedArray.removeBySet;
import static me.algorithm.array.RemoveDuplicatesFromUnsortedArray.removeBySorting;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given an unsorted array of integers, print the array after removing the duplicate elements from
 * it. We need to print distinct array elements according to their first occurrence. Examples:
 *
 * <p>Input : arr[] = { 1, 2, 5, 1, 7, 2, 4, 2} Output : 1 2 5 7 4 Explanation : {1, 2} appear more
 * than one time.
 */
class RemoveDuplicatesFromUnsortedArrayTest {

  final Logger logger = LoggerFactory.getLogger(RemoveDuplicatesFromUnsortedArrayTest.class);
  int[] target = {};
  int[] expected = {};

  @Test
  @DisplayName("Empty array should return an empty array")
  void testEmptyArrayBySorting() {
    logger.info("test empty array {} to return empty array {}", target, expected);
    assertTrue(Arrays.equals(expected, removeBySorting(target)));
  }

  @Test
  @DisplayName("{2} should return {2}")
  void testArrayOfSingleElementBySorting() {
    target = new int[]{2};
    expected = new int[]{2};
    logger.info("test single element array {} to return the same {}", target, expected);
    assertTrue(Arrays.equals(expected, removeBySorting(target)));
  }

  // todo test

  @Test
  @DisplayName("{ 1, 2, 5, 1, 7, 2, 4, 2} should become 1 2 4 5 7")
  void testCommonArrayBySorting() {
    target = new int[]{1, 2, 5, 1, 7, 2, 4, 2};
    expected = new int[]{1, 2, 4, 5, 7};
    logger.info("test common array {} to return {}", target, expected);
    assertTrue(Arrays.equals(expected, removeBySorting(target)));
  }

  @Test
  @DisplayName("{ 1, 2, 5, 1, 7, 2, 4, 2} should become 1 2 5 7 4")
  void testCommonArrayByMap() {
    target = new int[]{1, 2, 5, 1, 7, 2, 4, 2};
    expected = new int[]{1, 2, 5, 7, 4};
    logger.info("test common array {} to return {} by map", target, expected);
    int[] actual = removeByMap(target);
    logger.info("remove duplicates from {} to become {} by map", target, actual);
    assertTrue(Arrays.equals(expected, actual));
  }

  @Test
  @DisplayName("{ 1, 2, 5, 1, 7, 2, 4, 2} should become 1 2 5 7 4")
  void testCommonArrayBySet() {
    target = new int[]{1, 2, 5, 1, 7, 2, 4, 2};
    expected = new int[]{1, 2, 5, 7, 4};
    logger.info("test common array {} to return {} by set", target, expected);
    int[] actual = removeBySet(target);
    logger.info("remove duplicates from {} to become {} by set", target, actual);
    assertTrue(Arrays.equals(expected, actual));
  }
}
