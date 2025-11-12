package me.algorithm.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once
 * in a word.
 * <p>
 * Example 1:
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words =
 * ["oath","pea","eat","rain"] Output: ["eat","oath"] Example 2:
 * <p>
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"] Output: []
 * <p>
 * Constraints:
 * <p>
 * m == board.length n == board[i].length 1 <= m, n <= 12 board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104 1 <= words[i].length <= 10 words[i] consists of lowercase English
 * letters. All the strings of words are unique.
 */
public class WordSearchII {


  public List<String> findWords(char[][] board, String[] words) {

    List<String> res = new ArrayList<>();
    Trie trie = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, trie, res);
      }
    }

    return res;
  }

  // we just use a 26 array for all the letters since the word only contains lower letters, a is 97
  private static class Trie {

    Trie[] next = new Trie[26]; // the next trie after this letter
    String word; // if this is a word, put the word on this node, otherwise null

  }

  // we need to build a trie from the words
  private Trie buildTrie(String[] words) {
    Trie root = new Trie();
    for (String word : words) {
      Trie cur = root;
      for (char c : word.toCharArray()) {
        int i = c - 'a';
        if (cur.next[i] == null) {
          cur.next[i] = new Trie();
        }
        cur = cur.next[i];
      }
      cur.word = word;
    }

    return root;
  }

  private void dfs(char[][] board, int row, int col, Trie cur, List<String> result) {

    // we need to backtrack the cur cell, mark the cell as visited, when we backtrack it, we need to
    // make it unvisited
    // instead of using a 2-dimensional array for backtracking, we can use s special character for
    // it
    char c = board[row][col];
    if (c == '#' || cur.next[c - 'a'] == null) { // this cell is visited, or it's not matching word
      return;
    }

    cur = cur.next[c - 'a'];

    if (cur.word != null) { // we've found this word
      result.add(cur.word);
      cur.word = null; // set it to null to prevent duplication
    }

    board[row][col] = '#';

    if (row > 0) {
      dfs(board, row - 1, col, cur, result); // the left cell
    }
    if (row < board.length - 1) {
      dfs(board, row + 1, col, cur, result);
    }
    if (col > 0) {
      dfs(board, row, col - 1, cur, result);
    }
    if (col < board[0].length - 1) {
      dfs(board, row, col + 1, cur, result);
    }

    board[row][col] = c;
  }

}
