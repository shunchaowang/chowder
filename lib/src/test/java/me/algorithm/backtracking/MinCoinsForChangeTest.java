package me.algorithm.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinCoinsForChangeTest {

  @Test
  @DisplayName("test [1,2,5] for 11 should need 3 steps")
  void case1() {
    List<Integer> coins = List.of(1, 2, 5);
    int amount = 11;
    MinCoinsForChange minCoinsForChange = new MinCoinsForChange();
    int expected = 3;
    int actual = minCoinsForChange.coinChange(coins, amount);
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("test [186,419,83,408] for 6249 should have no result")
  void case2() {

    List<Integer> coins = List.of(186, 419, 83, 408);
    int amount = 6249;
    int expected = 20;
    MinCoinsForChange minCoinsForChange = new MinCoinsForChange();
    int actual = minCoinsForChange.coinChange(coins, amount);
    assertEquals(expected, actual);

  }

  @Test
  @DisplayName("test dp on [1,2,5] for 11 should be 3")
  void testBottomUp() {
    int[] coins = {1, 2, 5};
    int amount = 11;
    int expected = 3;
    MinCoinsForChange minCoinsForChange = new MinCoinsForChange();
    int actual = minCoinsForChange.coinChange(coins, amount);
    assertEquals(expected, actual);
  }
}