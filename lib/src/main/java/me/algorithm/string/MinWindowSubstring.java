package me.algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given two strings, original and check, return the minimum substring of original such that each
 * character in check, including duplicates, are included in this substring. By "minimum", I mean
 * the shortest substring. If two substrings that satisfy the condition have the same length, the
 * one that comes lexicographically first is smaller.
 * <p>
 * Parameters original: The original string. check: The string to check if a window contains it.
 * Result The smallest substring of original that satisfies the condition. Examples Example 1 Input:
 * original = "cdbaebaecd", check = "abc"
 * <p>
 * Output: baec
 * <p>
 * Explanation: baec is the shortest substring of original that contains all of a, b, and c.
 * <p>
 * Constraints 1 <= len(check), len(original) <= 10^5 original and check both contain only uppercase
 * and lowercase characters in English. The characters are case-sensitive.
 */
public class MinWindowSubstring {

  private boolean isValid(Map<Character, Integer> o, Map<Character, Integer> c) {

    for (Entry<Character, Integer> e : c.entrySet()) {

      if (o.getOrDefault(e.getKey(), 0) < e.getValue()) {
        return false;
      }
    }
    return true;
  }

  public String getMinimumWindow(String original, String check) {

    char[] oChars = original.toCharArray();
    Map<Character, Integer> oMap = new HashMap<>();
    char[] cChars = check.toCharArray();
    Map<Character, Integer> cMap = new HashMap<>();
    for (char c : cChars) {
      cMap.put(c, cMap.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int distance = Integer.MAX_VALUE;

    int i = 0; // left index
    for (int j = 0; j < original.length(); j++) {
      while (isValid(oMap, cMap)) {
        if (j - i + 1 < distance) {
          left = i;
          right = j + 1;
          distance = j - i + 1;
        } else if (j - i + 1 == distance) {
          if (original.substring(i, j + 1).compareTo(original.substring(left, right)) < 0) {
            left = i;
            right = j + 1;
          }
        }

        oMap.put(oChars[i], oMap.get(oChars[i]) - 1);
        i++;
      }

      oMap.put(oChars[j], oMap.getOrDefault(oChars[j], 0) + 1);
    }

    return distance == Integer.MAX_VALUE ? "" : original.substring(left, right);
  }
}
