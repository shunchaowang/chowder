package me.algorithm.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of
 * s such that every character in t (including duplicates) is included in the window. If there is no
 * such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The minimum window substring
 * "BANC" includes 'A', 'B', and 'C' from string t. Example 2:
 * <p>
 * Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length n == t.length 1 <= m, n <= 105 s and t consist of uppercase and lowercase English
 * letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinWindowSubstring {

  /**
   * start from 0, keep moving to the right until all t included in the s, calculate the min length
   * then keep moving the left to the righ and calculate the min length until there is t not
   * included in s
   * <p>
   * abcde  de <=sl - wl
   */
  public String minWindow(String s, String t) {
    int sl = s.length();
    int tl = t.length();
    int ansLeft = 0, ansRight = 0; // the answer should be s.substring(ansLeft, ansRight)

    int minLength = Integer.MAX_VALUE;

    if (sl < tl) {
      return "";
    }

    Map<Character, Integer> charFreq = new HashMap<>();
    for (char c : t.toCharArray()) {
      charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);

    }

    Map<Character, Integer> currFreq = new HashMap<>();
    int charMatch = 0;

    int i = 0;
    while (i <= sl - tl) {
      for (int right = i; right < sl; right++) {
        char c = s.charAt(right);
        if (charFreq.containsKey(c)) {
          currFreq.put(c, currFreq.getOrDefault(c, 0) + 1);
          charMatch++;

          while (currFreq.get(c) > charFreq.get(c)) {
            char leftChar = s.charAt(i);

            if (currFreq.containsKey(leftChar)) {
              currFreq.put(leftChar, currFreq.get(leftChar) - 1);
              charMatch--;
            }
            i++;
          }

          if (charMatch == tl) { // we found one

            while (!charFreq.containsKey(s.charAt(i))) {
              i++;
            }
            if (right - i < minLength) {
              minLength = right - i + 1;
              ansLeft = i;
              ansRight = right + 1;
            }

            currFreq.put(s.charAt(i), currFreq.get(s.charAt(i)) - 1);
            charMatch--;
            i++;

          }
        }
      }
      i++;
    }

    return s.substring(ansLeft, ansRight);
  }
}
