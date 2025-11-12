package me.algorithm.dp.dualsequence;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert
 * word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * Insert a character Delete a character Replace a character
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse (replace 'h' with
 * 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e') Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution" Output: 5 Explanation: intention -> inention
 * (remove 't') inention -> enention (replace 'i' with 'e') enention -> exention (replace 'n' with
 * 'x') exention -> exection (replace 'n' with 'c') exection -> execution (insert 'u')
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= word1.length, word2.length <= 500 word1 and word2 consist of lowercase English letters.
 */
public class EditDistance {

  public int minDistance(String word1, String word2) {
//    return dfs(word1, word2, 0, 0);
    return bottomUp(word1, word2);

  }

  private int dfs(String word1, String word2, int index1, int index2) {

    // 3 options, insert, delete or replace for each character
    if (index1 == word1.length()) {
      return word2.length() - index2;
    }
    if (index2 == word2.length()) {
      return word1.length() - index1;
    }

    // if the characters are the same, shift the indexes
//    if (word1.charAt(index1) == word2.charAt(index2)) {
//      return dfs(word1, word2, index1 + 1, index2 + 1);
//    }

    if (word1.charAt(index1) == word2.charAt(index2)) {
      return dfs(word1, word2, index1 + 1, index2 + 1);
    } else {
      // we only edit word1, since inserting on word1 is equal to deleting on word2
      int insert = dfs(word1, word2, index1, index2 + 1);
      int delete = dfs(word1, word2, index1 + 1, index2);
      int replace = dfs(word1, word2, index1 + 1, index2 + 1);
      return Math.min(Math.min(insert, delete), replace) + 1;
    }

  }

  private int bottomUp(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    if (l1 == 0) {
      return l2;
    }
    if (l2 == 0) {
      return l1;
    }
    // use prefixes; I really like prefixes
    // base on the recursion, for each current value
    // it should be
    // 1) currentValue=nextRow[j+1] | word1.charAt[i-1]==word2.charAt[j-1]
    // 2) currentValue=min(nextValue, nextRow[j],nextRow[j+1]) + 1 | otherwise
    int[] nextRow = new int[l2 + 1]; // nextRow[i] means the prefix of the array with i elements

    for (int i = 0; i <= l2; i++) {
      nextRow[i] = l2 - i;
    }
    int nextValue;
    int currValue = 0;

    for (int i = l1 - 1; i >= 0; i--) {
      nextValue = l1 - i;
      for (int j = l2 - 1; j >= 0; j--) {
        if (word1.charAt(i) == word2.charAt(j)) {
          currValue = nextRow[j + 1];
        } else {
          currValue = Math.min(Math.min(nextRow[j], nextRow[j + 1]), nextValue) + 1;
        }
        nextRow[j + 1] = nextValue;
        nextValue = currValue;
      }
      nextRow[0] = currValue;
    }

    return currValue;
  }
}
