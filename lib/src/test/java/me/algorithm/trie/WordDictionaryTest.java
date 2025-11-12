package me.algorithm.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordDictionaryTest {

  WordDictionary wordDictionary;

  @BeforeEach
  void setup() {
    wordDictionary = new WordDictionary();
  }

  @Test
  void test1() {
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    assertFalse(wordDictionary.search("pad"));
    assertTrue(wordDictionary.search("bad"));
  }

  @Test
  void test2() {
    List<String> words = List.of("at", "and", "an", "add");
    for (String word : words) {
      wordDictionary.addWord(word);
    }

    assertFalse(wordDictionary.search("a"));
    assertFalse(wordDictionary.search(".at"));

    wordDictionary.addWord("bat");
    assertTrue(wordDictionary.search(".at"));

  }
}