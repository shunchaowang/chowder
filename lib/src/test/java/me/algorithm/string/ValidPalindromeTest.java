package me.algorithm.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidPalindromeTest {

  ValidPalindrome validPalindrome = new ValidPalindrome();

  @Test
  void isPalindromeTest1() {

    String s = "Do geese see God";
    assertTrue(validPalindrome.isPalindrome(s));
  }

  @Test
  void isPalindromeTest2() {
    String s = "Was it a car or a cat I saw?";
    assertTrue(validPalindrome.isPalindrome(s));
  }

  @Test
  void isPalindromeTest3() {
    String s = "A brown fox jumping over";
    assertFalse(validPalindrome.isPalindrome(s));
  }
}