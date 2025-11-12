package me.algorithm.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WordLadderTest {

  @Test
  void testWordLadder() {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    WordLadder wordLadder = new WordLadder();
    int actual = wordLadder.ladderLength(beginWord, endWord, words);

    assertEquals(5, actual);
  }
}