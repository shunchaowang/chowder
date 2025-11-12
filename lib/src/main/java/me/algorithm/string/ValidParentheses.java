package me.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * <p>An input string is valid if:
 *
 * <p>Open brackets must be closed by the same type of brackets. Open brackets must be closed in
 * the correct order.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "()" Output: true Example 2:
 *
 * <p>Input: s = "()[]{}" Output: true Example 3:
 *
 * <p>Input: s = "(]" Output: false Example 4:
 *
 * <p>Input: s = "([)]" Output: false Example 5:
 *
 * <p>Input: s = "{[]}" Output: true
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 104 s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

  public static void main(String[] args) {
    // test cases
    String case1 = "()";
    String case2 = "()[]{}";
    String case3 = "(]";
    String case4 = "([)]";
    String case5 = "{[]}";
    System.out.println(case1 + " is " + isValid(case1));
    System.out.println(case2 + " is " + isValid(case2));
    System.out.println(case3 + " is " + isValid(case3));
    System.out.println(case4 + " is " + isValid(case4));
    System.out.println(case5 + " is " + isValid(case5));
  }

  /*
   * use stack. iterate the array, push when encountering a left parenthese. when there is a right
   * parenthese, ,there are 3 possible scanerios: 1. return false if the stack is empty; 2. pop the
   * top, if it matches the current one, keep iterating; 3. pop the top, return false if it doesn't
   * match.
   */
  private static boolean isValid(String s) {
    if (s == null || s.length() < 2) {
      return false;
    }
    String left = "([{";
    String right = ")]}";
    Map<Character, Character> parentheseMap = new HashMap<>();
    for (int i = 0; i < left.length(); i++) {
      parentheseMap.put(right.charAt(i), left.charAt(i));
    }
    Stack<Character> stack = new Stack<>();
    Set<Character> leftParentheses =
        new HashSet<>(left.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
    Set<Character> rightParentheses =
        new HashSet<>(right.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (leftParentheses.contains(c)) {
        stack.push(c);
        continue;
      }
      if (rightParentheses.contains(c)) {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if (top != parentheseMap.get(c)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
