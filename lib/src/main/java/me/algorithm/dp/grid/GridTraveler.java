package me.algorithm.dp.grid;

import java.util.HashMap;
import java.util.Map;

public final class GridTraveler {

  public static int travelGrid(int m, int n, Map<String, Integer> memo) {

    String k = m + ", " + n;
    if (memo.containsKey(k)) {
      return memo.get(k);
    }
    if (m <= 0 || n <= 0) {
      return 0;
    }
    if (m == 1 && n == 1) {
      return 1;
    }
    int result = travelGrid(m - 1, n, memo) + travelGrid(m, n - 1, memo);
    memo.put(k, result);
    return result;
  }

  public static void main(String[] args) {

    Map<String, Integer> memo = new HashMap<>();
    System.out.printf("there should be 3 and actual is %d ways to travel a 2x3 grid\n",
        travelGrid(20, 30, memo));
  }
}
