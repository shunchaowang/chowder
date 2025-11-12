package me.algorithm.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCoinsForChange {

  private int dfs(List<Integer> coins, int amount, int sum, Map<Integer, Integer> memo) {
    int ans = Integer.MAX_VALUE;
    if (sum > amount) {
      return Integer.MAX_VALUE;
    }
    if (sum == amount) {
      return 0;
    }

//        if(memo.containsKey(sum) && memo.get(sum)!=Integer.MAX_VALUE)
    if (memo.containsKey(sum)) {
      return memo.get(sum);
    }
    for (int c : coins) {
      int result = dfs(coins, amount, sum + c, memo);
      if (result == Integer.MAX_VALUE) {
        continue; // no path
      }
      ans = Math.min(ans, result + 1);
    }

    memo.put(sum, ans);
    return ans;
  }

  public int coinChange(List<Integer> coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (coins == null || coins.isEmpty()) {
      return -1;
    }
    int min = dfs(coins, amount, 0, new HashMap<>());
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public int coinChange(int[] coins, int amount) {
    return bottomUp(coins, amount);
  }

  private int bottomUp(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    int n = coins.length;

    int[][] dp = new int[amount + 1][n + 1];

    // we want to fill impossible amount with -1
    for (int i = 0; i <= amount; ++i) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    // for amount 0 we should have 0
    for (int i = 0; i <= n; ++i) {
      dp[0][i] = 0;
    }

    for (int i = 1; i <= amount; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (dp[i][j - 1] != Integer.MAX_VALUE) {
          dp[i][j] = dp[i][j - 1];
        }
        // or
        if (i >= coins[j - 1]) {
          if (dp[i - coins[j - 1]][j - 1] != Integer.MAX_VALUE) {
            dp[i][j] = Math.min(dp[i][j], dp[i - coins[j - 1]][j - 1] + 1);
          }
          if (dp[i - coins[j - 1]][j] != Integer.MAX_VALUE) {
            dp[i][j] = Math.min(dp[i][j], dp[i - coins[j - 1]][j] + 1);
          }
        }

      }
    }

    return dp[amount][n] == Integer.MAX_VALUE ? -1 : dp[amount][n];
  }
}
