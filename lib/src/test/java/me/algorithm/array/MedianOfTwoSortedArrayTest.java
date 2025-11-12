package me.algorithm.array;

import static me.algorithm.array.MedianOfTwoSortedArray.findMedianByCount;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MedianOfTwoSortedArrayTest {

  private Logger logger = LoggerFactory.getLogger(MedianOfTwoSortedArrayTest.class);

  @Test
  void testCommonCase1() {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};

    double expected = 2.0;
    double actual = MedianOfTwoSortedArray.findMedian(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testCommonCase2() {
    int[] nums1 = {1, 2};
    int[] nums2 = {3, 4};

    double expected = 2.5;
    double actual = MedianOfTwoSortedArray.findMedian(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testAllZeros() {
    int[] nums1 = {0, 0};
    int[] nums2 = {0, 0};

    double expected = 0;
    double actual = MedianOfTwoSortedArray.findMedian(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testOneEmptyArray() {
    int[] nums1 = {2};
    int[] nums2 = new int[0];

    double expected = 2;
    double actual = MedianOfTwoSortedArray.findMedian(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testCommonCase1ByCount() {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};

    double expected = 2.0;
    double actual = findMedianByCount(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }

  @Test
  void testCommonCase2ByCount() {
    int[] nums1 = {1, 2};
    int[] nums2 = {3, 4};

    double expected = 2.5;
    double actual = findMedianByCount(nums1, nums2);
    logger.info("Median of {} and {} is {}", nums1, nums2, actual);

    assertEquals(expected, actual);
  }
}
