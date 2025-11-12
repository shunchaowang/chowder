package me.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * <p>Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 *
 * <p>Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice
 * that the answer must be a substring, "pwke" is a subsequence and not a substring. Example 4:
 *
 * <p>Input: s = "" Output: 0
 */
public class LongestUniqueSubstring {

  // use slide windows
  private static int lengthOfLongestSubstring(String s) {
    int start = 0;
    int end = 0;
    int max = 0;
    Set<Character> set = new HashSet<>();

    while (end < s.length()) {
      if (!set.contains(s.charAt(end))) {
        set.add(s.charAt(end++));
        max = Math.max(max, set.size());
      } else {
        set.remove(s.charAt(start++));
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String s = "abcbdeb";
    System.out.printf("Longest of %s is %d%n", s, lengthOfLongestSubstring(s));
  }
}
