package me.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical
 * expressions, such as eval().
 * <p>
 * Example 1:
 * <p>
 * Input: s = "1 + 1" Output: 2 Example 2:
 * <p>
 * Input: s = " 2-1 + 2 " Output: 3 Example 3:
 * <p>
 * Input: s = "(1+(4+5+2)-3)+(6+8)" Output: 23
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105 s consists of digits, '+', '-', '(', ')', and ' '. s represents a valid
 * expression. '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid). '-'
 * could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid). There will be no two
 * consecutive operators in the input. Every number and running calculation will fit in a signed
 * 32-bit integer.
 */
public class BasicCalculator {

  public int calculate(String s) {

    int result = 0, sign = 1, l = s.length();
    Deque<Integer> stack = new LinkedList<>();

    for (int i = 0; i < l; i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int sum = c - '0';
        while (i + 1 < l && Character.isDigit(s.charAt(i + 1))) {
          i++;
          sum = sum * 10 + (s.charAt(i) - '0');
        }

        result += sum * sign;
      } else if (c == '+') {
        sign = 1;
      } else if (c == '-') {
        sign = -1;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else if (c == ')') {
        result = result * stack.pop() + stack.pop();
      }
    }
    return result;

  }
}
