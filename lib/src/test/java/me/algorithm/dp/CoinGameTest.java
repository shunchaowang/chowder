package me.algorithm.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import me.algorithm.dp.knapsack.CoinGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinGameTest {

  @Test
  @DisplayName("Coins [4, 4, 9, 4] should be 13")
  void case1() {
    Integer[] coins = {4, 4, 9, 4};
    int expected = 13;

    CoinGame coinGame = new CoinGame();
    int actual = coinGame.coinGame(Arrays.asList(coins));

    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Coins 1, 2, 9999, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 should be 10104")
  void case2() {

    assertEquals(10104, new CoinGame().coinGame(
        List.of(1, 2, 9999, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)));
  }

}