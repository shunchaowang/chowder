package me.algorithm.dp.dualsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistinctSubsequencesTest {

  @Test
  @DisplayName("rabbbit and rabbit should have 3 distinct subsequences")
  void case1() {
    assertEquals(3, new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
  }


  @Test
  @DisplayName("babgbag and bag should have 5 distinct subsequences")
  void case2() {
    assertEquals(5, new DistinctSubsequences().numDistinct("babgbag", "bag"));
  }

}