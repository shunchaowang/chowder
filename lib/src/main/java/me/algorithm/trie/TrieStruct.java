package me.algorithm.trie;

/**
 * word matching data structure, the methods to exposed are insert the word to the trie if not
 * existing; search is a word exist by full matching; check is a string is a valid prefix.
 */
public final class TrieStruct {

  TrieNode root;

  public TrieStruct() {
    root = new TrieNode();
  }

  public static void main(String[] args) {
    TrieStruct trieStruct = new TrieStruct();
    trieStruct.insert("cat");
    trieStruct.insert("car");
    trieStruct.insert("dog");
    trieStruct.insert("pick");
    trieStruct.insert("pickle");
    boolean isPresent = trieStruct.search("cat");
    System.out.println("cat is present " + isPresent);
    isPresent = trieStruct.search("picky");
    System.out.println("picky is present " + isPresent);
    isPresent = trieStruct.startsWith("ca");
    System.out.println("ca is a prefix " + isPresent);
    isPresent = trieStruct.startsWith("pen");
    System.out.println("pen is a prefix " + isPresent);
  }

  public void insert(String word) {
    if (word == null || word.length() == 0) {
      return;
    }
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.isEndOfWord = true;
  }

  public boolean search(String word) {
    return isMatch(word, root, 0, true);
  }

  public boolean startsWith(String prefix) {
    return isMatch(prefix, root, 0, false);
  }

  /**
   * match the string with node recursively
   *
   * @param s           the pattern
   * @param node        the target node
   * @param index       the index of the pattern
   * @param isFullMatch is this matching the whole s or starting with
   * @return match or not
   */
  private boolean isMatch(String s, TrieNode node, int index, boolean isFullMatch) {
    // if the s still has char, but node is null, not matching
    if (node == null) {
      return false;
    }

    // if we only match starts with, return true if the string is ended even
    // though the end of word is false
    if (index == s.length()) {
      return !isFullMatch || node.isEndOfWord;
    }

    // if we are not done with the s, keep moving to the next char
    return isMatch(s, node.children[s.charAt(index) - 'a'], index + 1, isFullMatch);
  }
}
