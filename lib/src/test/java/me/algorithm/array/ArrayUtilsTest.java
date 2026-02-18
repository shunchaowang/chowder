package me.algorithm.array;

import static me.algorithm.array.ArrayUtils.mergeTwoSortedArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ArrayUtilsTest {

  private final Logger logger = LoggerFactory.getLogger(ArrayUtilsTest.class);

  @Test
  void testMergeTwoSortedArray() {

    int[] nums1 = {7, 8, 9};
    int[] nums2 = {2, 4, 6};
    int[] expected = {2, 4, 6, 7, 8, 9};

    int[] result = mergeTwoSortedArray(nums1, nums2);
    logger.info(Arrays.toString(result));
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testSortArray1() {
    int[] nums = {5, 2, 3, 1};
    ArrayUtils arrayUtils = new ArrayUtils();
    arrayUtils.sort(nums);
    IO.println("nums after sorted " + nums);
    assertArrayEquals(new int[]{1, 2, 3, 5}, nums);
  }

  @Test
  void testSortArray2() {
    int[] nums = {5, 1, 1, 2, 0, 0};
    ArrayUtils arrayUtils = new ArrayUtils();
    arrayUtils.sort(nums);
    assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, nums);
  }
}
