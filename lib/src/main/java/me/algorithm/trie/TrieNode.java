package me.algorithm.trie;

public final class TrieNode {

  boolean isEndOfWord;
  TrieNode[] children;

  public TrieNode() {
    isEndOfWord = false;
    children = new TrieNode[26];
  }
}
