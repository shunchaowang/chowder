package me.algorithm.twopointer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinWindowSubstringTest {

  MinWindowSubstring minWindowSubstring;

  @BeforeEach
  void setup() {
    minWindowSubstring = new MinWindowSubstring();
  }

  @Test
  void test1() {
    String s = "ADOBECODEBANC";
    String t = "ABC";

    assertEquals("BANC", minWindowSubstring.minWindow(s, t));
  }

  @Test
  void test2() {
    String s = "a";
    String t = "b";

    assertEquals("", minWindowSubstring.minWindow(s, t));
  }

  @Test
  void test3() {
    String s = "abc";
    String t = "cba";

    assertEquals("abc", minWindowSubstring.minWindow(s, t));
  }

  @Test
  void test4() {
    String s = "aaaaaaaaaaaabbbbbcdd";
    String t = "abcdd";

    assertEquals("abbbbbcdd", minWindowSubstring.minWindow(s, t));
  }
}