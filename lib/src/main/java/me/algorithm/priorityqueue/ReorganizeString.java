package me.algorithm.priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, check if the letters can be rearranged so that two characters that are adjacent
 * to each other are not the same.
 * <p>
 * If possible, output any possible result. If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input:s = "aab"
 * <p>
 * Output: aba
 * <p>
 * Example 2:
 * <p>
 * Input:s = "aaab"
 * <p>
 * Output: ``
 * <p>
 * Note:
 * <p>
 * s will consist of lowercase letters and have length in the range [1, 500].
 */
public class ReorganizeString {

  record Element(char c, int occurrence) {

  }

  // there are always more even spots then odd spots in the string
  // since the string starts with 0
  // if 1 character has more than half of the length, it's impossible
  // to fulfill the request, return empty string
  // if there is no character with more than half of the occurrence
  // we can have the process to place the most elements into the
  // even spots, there are always no less spots then the odd spots
  // 0 1 2 3, 0 1 2

  public String reorganize(String s) {
    // WRITE YOUR BRILLIANT CODE HERE
    if (s == null || s.isEmpty()) {
      return "";
    }

    PriorityQueue<Element> queue = new PriorityQueue<>(
        Comparator.comparingInt(Element::occurrence).reversed());
    char[] charArr = new char[s.length()];
    Map<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    map.forEach((key, value) -> queue.add(new Element(key, value)));

    Element e = queue.peek();
    assert e != null;
    if (e.occurrence > Math.ceil(s.length() / 2.0)) {
      return "";
    }

    // fill all even spots with e.c
    int i = 0;
    while (!queue.isEmpty()) {
      e = queue.poll();
      for (int j = 0; j < e.occurrence; j++) {
        charArr[i] = e.c;
        i += 2;
        if (i >= s.length()) {
          i = 1;
        }
      }
    }

    return new String(charArr);
  }

}
