package me.algorithm.trie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class WordSearchIITest {

  WordSearchII wordSearch = new WordSearchII();

  @Test
  void test1() {

    char[][] board = {{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};

    String[] words = {"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};

    List<String> result = wordSearch.findWords(board, words);

    assertEquals(4, result.size());
    assertTrue(result.contains("abcdefg"));
    assertTrue(result.contains("gfedcbaaa"));
    assertTrue(result.contains("befa"));
    assertTrue(result.contains("eaabcdgfa"));

  }

  @Test
  void test2() {
    char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}};
    String[] words = {"oath", "pea", "eat", "rain"};
    List<String> result = wordSearch.findWords(board, words);
    assertArrayEquals(new String[]{"oath", "eat"}, result.toArray());
  }

  @Test
  void test3() {
    char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'},
        {'a', 'f', 'l', 'v'}};
    List<String> result = wordSearch.findWords(board, new String[]{"oa", "oaa"});
    assertArrayEquals(new String[]{"oa", "oaa"}, result.toArray());
  }
}