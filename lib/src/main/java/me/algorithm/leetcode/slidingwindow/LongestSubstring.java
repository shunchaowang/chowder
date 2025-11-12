package me.algorithm.leetcode.slidingwindow;

import java.util.HashMap;

public final class LongestSubstring {

  /**
   * Hard
   * <p>
   * Google Interview
   * <p>
   * Given a string you need to print longest possible substring that has exactly M unique
   * characters. If there are more than one substring of longest possible length, then print any one
   * of them.
   * <p>
   * Examples: "aabbcc", k = 1 Max substring can be any one from {"aa" , "bb" , "cc"}.
   * <p>
   * "aabbcc", k = 2 Max substring can be any one from {"aabb" , "bbcc"}.
   * <p>
   * "aabbcc", k = 3 There are substrings with exactly 3 unique characters {"aabbcc" , "abbcc" ,
   * "aabbc" , "abbc" } Max is "aabbcc" with length 6.
   * <p>
   * "aaabbb", k = 3 There are only two unique characters, thus show not existing.
   *
   * @param s the target string
   * @param k unique characters
   * @return the substring with k unique characters
   */
  public static String longestSubstringOfUniqueCharacter(String s, int k) {
    // aabbcc
    if (s == null || s.isEmpty()) {
      return "";
    }
    int maxLength = 0;
    int startIndex = 0;
    int endIndex = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    // create a hash map for all the characters
    HashMap<Character, Integer> charCountMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      charCountMap.put(c, 0);
    }

    // if the unique characters is less than k
    if (charCountMap.keySet().size() < k) {
      return "";
    }

    charCountMap.put(s.charAt(rightIndex), 1);
    for (rightIndex = 1; rightIndex < s.length(); rightIndex++) {
      // keep moving right index if the unique is less than k
      char c = s.charAt(rightIndex);
      charCountMap.put(c, charCountMap.get(c) + 1);

      while (!isValid(charCountMap, k)) {
        charCountMap.put(
            s.charAt(leftIndex),
            charCountMap.get(s.charAt(leftIndex)) - 1);
        leftIndex++;
      }

      int newMaxLength = rightIndex - leftIndex + 1;
      if (newMaxLength > maxLength) {
        maxLength = newMaxLength;
        startIndex = leftIndex;
        endIndex = rightIndex;
      }
    }

    return s.substring(startIndex, endIndex + 1);
  }

  private static boolean isValid(HashMap<Character, Integer> count, int k) {
    return count.values().stream().filter(i -> i > 0).count() <= k;
  }
}
