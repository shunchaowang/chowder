package me.algorithm.priorityqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReorganizeStringTest {

  @Test
  void testCase1() {
    String s = "aab";
    var res = new ReorganizeString();
    String ans = res.reorganize(s);
    assertEquals("aba", ans);
  }
}