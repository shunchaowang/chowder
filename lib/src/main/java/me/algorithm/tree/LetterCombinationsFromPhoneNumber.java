package me.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsFromPhoneNumber {

  private static final Map<Character, char[]> pads = Map.of(
      '2', "abc".toCharArray(),
      '3', "def".toCharArray(),
      '4', "ghi".toCharArray(),
      '5', "jkl".toCharArray(),
      '6', "mno".toCharArray(),
      '7', "pqrs".toCharArray(),
      '8', "tuv".toCharArray(),
      '9', "wxyz".toCharArray());

  // a dfs tree of height of the size of the number
  private static void dfs(String input, int index, StringBuilder path, List<String> result) {
    // if index==input.length-1, add the result and return
    if (input == null || input.length() == 0) {
      return;
    }
    if (index == input.length()) {
      result.add(path.toString());
      return;
    }

    // get the number from the input, and find the string mapped to it
    char i = input.charAt(index);
    for (char c : pads.get(i)) {

      // add each one to the path
      path.append(c);
      dfs(input, index + 1, path, result);
      // pop
      path.deleteCharAt(index);
    }
    return;
  }

  public static List<String> letterCombinationsOfPhoneNumber(String digits) {
    if (digits == null || digits.length() == 1) {
      return List.of();
    }
    List<String> result = new ArrayList<>();
    dfs(digits, 0, new StringBuilder(), result);
    return result;
  }

  public static void main(String[] args) {

    letterCombinationsOfPhoneNumber("56");
  }
}
