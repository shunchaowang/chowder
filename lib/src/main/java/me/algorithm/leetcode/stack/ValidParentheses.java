package me.algorithm.leetcode.stack;

import static java.lang.System.out;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Easy
 *
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * <p>
 * An input string is valid if:
 *
 * <p>
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order.
 *
 * <p>
 * Example 1:Input: s = "()" Output: true
 *
 * <p>
 * Example 2: Input: s = "()[]{}" Output: true
 *
 * <p>
 * Example 3: Input: s = "(]" Output: false
 */
public final class ValidParentheses {

  public static boolean isValid(String s) {
    // use stack, iterate the char, push when the left ([{ occurs, pop when right
    // )]} occurs.
    // if any order is wrong, it's not valid
    if (s == null || s.length() == 0) {
      return true;
    }

    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      switch (c) {
        case '(', '[', '{' -> stack.push(c);
        case ')', ']', '}' -> {
          if (stack.isEmpty()) {
            return false; // not enough left not valid
          }
          char top = stack.pop();
          if (c == ')' && top != '(' || c == ']' && top != '[' || c == '}' && top != '{') {
            return false;
          } else {
            continue;
          }
        }
        default -> throw new IllegalStateException("Unexpected value: " + c);
      }
      ;
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s = "()[]{}";
    out.printf("%s is a %b sequence of parentheses", s, isValid(s));

  }
}
