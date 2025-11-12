package me.algorithm.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MedianOfStreamTest {

  @Test
  void testCase1() {

    MedianOfStream medianOfStream = new MedianOfStream();

    medianOfStream.addNum(1);
    medianOfStream.addNum(2);
    medianOfStream.addNum(3);

    double m1 = medianOfStream.getMedian();
    assertEquals(2.0, m1);

    medianOfStream.addNum(4);

    double m2 = medianOfStream.getMedian();
    assertEquals(2.5, m2);
  }

}