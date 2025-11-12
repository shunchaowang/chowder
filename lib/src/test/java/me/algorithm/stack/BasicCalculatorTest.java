package me.algorithm.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BasicCalculatorTest {

  @Test
  void test1() {
    var s = "(1+(4+5+2)-3)+(6+8)";
    int expected = 23;

    assertEquals(expected, new BasicCalculator().calculate(s));
  }

  @Test
  void test2() {
    var s = " -2 +1 ";
    int expected = -1;

    assertEquals(expected, new BasicCalculator().calculate(s));
  }

}