package me.algorithm.backtracking.sppedrun;

import java.util.ArrayList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is
 * between 0 and 255 (inclusive) and cannot have leading zeros.
 * <p>
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245",
 * "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * <p>
 * Given a string s containing only digits, return all possible valid IP addresses that can be
 * formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You
 * may return the valid IP addresses in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "25525511135"
 * <p>
 * Output: ["255.255.11.135","255.255.111.35"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "0000"
 * <p>
 * Output: ["0.0.0.0"]
 * <p>
 * Example 3:
 * <p>
 * Input: s = "101023"
 * <p>
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20 s consists of digits only.
 */
public class ValidIp {

  public static List<String> validIPAddress(String IP) {
    return List.of();
  }

  // define isLeaf and getEdges
  // we are going through the string by 1 to 3 digits, if the substring is a valid portion,
  // we recursively to iterating the rest of string
  private static List<String> results = new ArrayList<>();

  private static void dfs(String IP, int start, List<String> path) {
    // path should have exact 4 items if start is the last character of the string

  }

  private static boolean isValidIP(String IP) {
    if(IP.startsWith("0") && IP.length() > 1) {
      return false;
    }

    return true;
  }


}
