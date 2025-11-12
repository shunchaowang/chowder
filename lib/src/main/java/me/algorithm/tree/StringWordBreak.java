package me.algorithm.tree;

import java.util.List;

public class StringWordBreak {

  private static boolean dfs(String s, List<String> words, int index) {
    if (index == s.length()) {
      return true; // reach the end of s
    }
    // brute force try everyone from the prefix
    for (String w : words) {
      if (s.startsWith(w, index)) {

        return dfs(s, words, index + w.length());
      }
    }
    return false;
  }

  public static boolean wordBreak(String s, List<String> words) {
    if (s == null || s.length() == 0) {
      return false;
    }
    if (words == null || words.size() == 0) {
      return false;
    }

    return dfs(s, words, 0);
  }

  public static void main(String[] args) {
    var s = "algomonster";
    var words = List.of("algo", "monster");
    wordBreak(s, words);
  }

}
