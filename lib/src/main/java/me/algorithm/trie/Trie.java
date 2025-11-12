package me.algorithm.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

  private Map<Character, Trie> children;
  private int frequency;

  public Trie() {
    frequency = 0;
    children = new HashMap<>();
  }

  public void insert(String s) {
    if (s == null || s.isEmpty()) {
      return;
    }

    Trie curr = this;
    for (char c : s.toCharArray()) {
      curr.children.putIfAbsent(c, new Trie());
      curr = curr.children.get(c);
      curr.frequency++;
    }
  }

  public int query(String prefix) {
    if (prefix == null || prefix.isEmpty()) {
      return 0;
    }
    Trie curr = this;
    for (char c : prefix.toCharArray()) {
      if (!curr.children.containsKey(c)) {
        return 0;
      }
      curr = curr.children.get(c);
    }
    return curr.frequency;
  }
}
