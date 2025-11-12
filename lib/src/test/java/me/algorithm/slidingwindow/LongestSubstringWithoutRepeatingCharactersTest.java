package me.algorithm.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharactersTest {

  @Test
  void testCase1() {
    assertEquals(3,
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    assertEquals(3,
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1,
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
  }
}