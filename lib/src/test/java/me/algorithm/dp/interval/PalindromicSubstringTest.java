package me.algorithm.dp.interval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PalindromicSubstringTest {

  PalindromicSubstring palindromicSubstring;

  @BeforeEach
  void setup() {
    palindromicSubstring = new PalindromicSubstring();
  }

  @Test
  @DisplayName("abc should have 3 palindromic substrings")
  void testDfs1() {
    assertEquals(3, palindromicSubstring.dfs("abc"));
  }

  @Test
  @DisplayName("aaa should have 6 palindromic substrings")
  void testDfs2() {
    assertEquals(6, palindromicSubstring.dfs("aaa"));
  }

  @Test
  @DisplayName("abc should have 3 palindromic substrings")
  void testDp1() {
    assertEquals(3, palindromicSubstring.dp("abc"));
  }

  @Test
  @DisplayName("aaa should have 6 palindromic substrings")
  void testDp2() {
    assertEquals(6, palindromicSubstring.dp("aaa"));

  }
}