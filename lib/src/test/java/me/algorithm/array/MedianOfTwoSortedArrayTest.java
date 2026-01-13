package me.algorithm.array;

import static me.algorithm.array.MedianOfTwoSortedArray.findMedianBs;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MedianOfTwoSortedArrayTest {

  private final Logger logger = LoggerFactory.getLogger(MedianOfTwoSortedArrayTest.class);

  @Test
  void testCommonCase1Bs() {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};

    double expected = 2.0;
    double actual = findMedianBs(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testCommonCase2Bs() {
    int[] nums1 = {1, 2};
    int[] nums2 = {3, 4};

    double expected = 2.5;
    double actual = findMedianBs(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testAllZerosBs() {
    int[] nums1 = {0, 0};
    int[] nums2 = {0, 0};

    double expected = 0;
    double actual = findMedianBs(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testOneEmptyArrayBs() {
    int[] nums1 = {2};
    int[] nums2 = new int[0];

    double expected = 2;
    double actual = findMedianBs(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testCase3Bs() {
    int[] nums1 = {-10, -9, -8};
    int[] nums2 = {1, 2};

    double expected = -8.0;
    double actual = findMedianBs(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }
}
