package me.algorithm.heap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UglyNumberTest {

  @Test
  void testNthUglyNumber() {
    UglyNumber uglyNumber = new UglyNumber();

    int result = uglyNumber.nthUglyNumber(10);

    assertEquals(12, result);
  }
}