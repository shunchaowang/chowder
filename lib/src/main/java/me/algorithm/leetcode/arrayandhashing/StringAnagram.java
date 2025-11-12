package me.algorithm.leetcode.arrayandhashing;

import static java.lang.System.out;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or
 * phrase, typically using all the original letters exactly once.
 *
 * <p>Example 1: Input: s = "anagram", t = "nagaram" Output: true
 *
 * <p>Example 2: Input: s = "rat", t = "car" Output: false
 */
public final class StringAnagram {

  public static boolean isAnagram(String s, String t) {
    return false;
  }

  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    out.printf("String %s and String %s is %b\n", s, t, isAnagram(s, t));
  }
}
