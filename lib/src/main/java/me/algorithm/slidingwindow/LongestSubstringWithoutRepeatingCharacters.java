package me.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example
 * 2:
 * <p>
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 * <p>
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice that
 * the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104 s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

  // use set and 2 pointers
  public int lengthOfLongestSubstring(String s) {

    Set<Character> set = new HashSet<>();
    int maxLength = 0;
    int l = s.length();

    int left = 0;

    for (int right = 0; right < l; right++) {
      if (!set.contains(s.charAt(right))) {
        maxLength = Math.max(maxLength, right - left + 1);
      }

      while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      }

      set.add(s.charAt(right));
    }

    return maxLength;
  }

}
