package me.algorithm.trie;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Design a data structure that supports adding new words and finding if a string matches any
 * previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * WordDictionary() Initializes the object. void addWord(word) Adds word to the data structure, it
 * can be matched later. bool search(word) Returns true if there is any string in the data structure
 * that matches word or false otherwise. word may contain dots '.' where dots can be matched with
 * any letter.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]] Output
 * [null,null,null,null,false,true,true,true]
 * <p>
 * Explanation WordDictionary wordDictionary = new WordDictionary(); wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad"); wordDictionary.addWord("mad"); wordDictionary.search("pad"); //
 * return False wordDictionary.search("bad"); // return True wordDictionary.search(".ad"); // return
 * True wordDictionary.search("b.."); // return True
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 25 word in addWord consists of lowercase English letters. word in search
 * consist of '.' or lowercase English letters. There will be at most 2 dots in word for search
 * queries. At most 104 calls will be made to addWord and search.
 */
public class WordDictionary {

  boolean isWord;
  Map<Character, WordDictionary> dict;

  // use a trie for eash search, with the trie, the search time
  // is O(n) which n is the length of the word
  // the insertion also take O(n) time.
  // the space O(n) too since there are 26 lettters

  public WordDictionary() {
    dict = new HashMap<>();
  }

  public void addWord(String word) {
    // for each letter, check if it's in the dict
    // get the value and keep with the loop
    // create a new dict if it's not
    // keep looping until we reach the end of the word
    // set the valid to be true on the end letter
    WordDictionary cur = this;

    for (char c : word.toCharArray()) {

      if (!cur.dict.containsKey(c)) {
        cur.dict.put(c, new WordDictionary());
      }
      cur = cur.dict.get(c);
    }
    cur.isWord = true;
  }

  /*
  * we need to use a queue, start by putting the dict into the queue.
  when the queue is not empty, we pop one, we need to have the queue's size to count for the .
  increment the index of the word when we finish 1 layer.
  the result should be i == word.length()
  */
  public boolean search(String word) {
    WordDictionary cur = this;

    Deque<WordDictionary> queue = new LinkedList<>();
    int i = 0;
    queue.offer(cur);
    while (!queue.isEmpty() && i < word.length()) {
      char c = word.charAt(i);
      int l = queue.size();
      for (int j = 0; j < l; j++) {
        cur = queue.poll();
        if (c == '.') { // we need to add all sub dicts into the queue
          queue.addAll(cur.dict.values());
        } else {
          // if cur doesn't contain a c, return false
          if (cur.dict.containsKey(c)) {
            queue.add(cur.dict.get(c));
          }
        }
      }
      i++;
    }
    // if the queue is empty, it means the last char is not in the dict
    while (!queue.isEmpty()) {
      cur = queue.poll();
      if (cur.isWord) {
        return true;
      }
    }

    return false;
  }
}
