package me.algorithm.dp.dualsequence;

/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as
 * subsequences. If there are multiple valid strings, return any of them.
 * <p>
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0)
 * results in the string s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "abac", str2 = "cab" Output: "cabac" Explanation: str1 = "abac" is a subsequence of
 * "cabac" because we can delete the first "c". str2 = "cab" is a subsequence of "cabac" because we
 * can delete the last "ac". The answer provided is the shortest such string that satisfies these
 * properties. Example 2:
 * <p>
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa" Output: "aaaaaaaa"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= str1.length, str2.length <= 1000 str1 and str2 consist of lowercase English letters.
 */
public class ShortCommonSupersequence {

  public String dfs(String str1, String str2) {

    String[][] memo = new String[str1.length()][str2.length()];
    return dfs(str1, str2, 0, 0, memo);
  }

  private String dfs(String str1, String str2, int index1, int index2, String[][] memo) {

    if (index1 == str1.length()) {
      return str2.substring(index2);
    }
    if (index2 == str2.length()) {
      return str1.substring(index1);
    }

    if (memo[index1][index2] != null) {
      return memo[index1][index2];
    }

    // check if the characters are the same, add
    if (str1.charAt(index1) == str2.charAt(index2)) {
      memo[index1][index2] = str1.charAt(index1) + dfs(str1, str2, index1 + 1, index2 + 1, memo);
    } else {
      // if they are different we pick the shortest
      // pick from string 1 or string 2
      String pick1 = str1.charAt(index1) + dfs(str1, str2, index1 + 1, index2, memo);
      String pick2 = str2.charAt(index2) + dfs(str1, str2, index1, index2 + 1, memo);

      memo[index1][index2] = pick1.length() < pick2.length() ? pick1 : pick2;
    }

    return memo[index1][index2];
  }

  public String dp(String str1, String str2) {
    int l1 = str1.length();
    int l2 = str2.length();

    String[] nextRow = new String[l2 + 1];

    // we initialize the nextRow with the 0 suffix, the values are the substring of str2
    for (int i = 0; i <= l2; i++) {
      nextRow[i] = str2.substring(i); // nextRow[l2] is "" an empty string
    }

    // we only need to memorization the current character, next character and next row since we move from
    // backward to forward
    // 0 1 2 3 4 (i,j), (i,j+1)
    // 0 1 2 3 4 (i+1,j),(i+1,j)
    // for each loop, we make the currValue is (i,j), there are 3 options of (i,j) currValue
    /*
     * str1[i]+nextRow[j+1] | str1[i]==str2[j];
     * str1[i]+nextRow[j] or str2[j]+prevValue | which is shorter
     * at the end of inner loop we set nextRow[j+1]=prevValue,prevValue=currValue;
     * at the end of the outer loop we set nextRow[j]=currValue.
     * */
    String currValue = "";
    for (int i = l1 - 1; i >= 0; i--) {
      String prevValue = str1.substring(i);
      for (int j = l2 - 1; j >= 0; j--) {
        if (str1.charAt(i) == str2.charAt(j)) {
          currValue = str1.charAt(i) + nextRow[j + 1];
        } else {
          String pick1 = str1.charAt(i) + nextRow[j];
          String pick2 = str2.charAt(j) + prevValue;
          currValue = pick1.length() < pick2.length() ? pick1 : pick2;
        }

        nextRow[j + 1] = prevValue;
        prevValue = currValue;
      }
      nextRow[0] = currValue;
    }

    return currValue;
  }

}
