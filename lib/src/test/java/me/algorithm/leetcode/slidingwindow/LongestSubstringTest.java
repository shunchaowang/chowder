package me.algorithm.leetcode.slidingwindow;

import static me.algorithm.leetcode.slidingwindow.LongestSubstring.longestSubstringOfUniqueCharacter;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestSubstringTest {

  @Test
  void testFindLongestSubstringOfUniqueCharacter() {
    String s1 = "aabbcc";
    int k1 = 2;
    String expected1 = "aabb";
    String actual1 = longestSubstringOfUniqueCharacter(s1, k1);
    assertEquals(expected1, actual1);
  }

}
