package me.algorithm.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MinWindowSubstringTest {

  @Test
  void testCase1() {
    var original = "cdbaebaecd";
    var check = "abc";

    MinWindowSubstring minWindowSubstring = new MinWindowSubstring();

    var result = minWindowSubstring.getMinimumWindow(original, check);

    assertEquals("baec", result);
  }

}