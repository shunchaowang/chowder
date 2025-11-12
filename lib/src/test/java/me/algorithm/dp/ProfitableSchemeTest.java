package me.algorithm.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.algorithm.dp.knapsack.ProfitableScheme;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitableSchemeTest {

  @Test
  @DisplayName("n = 5, minProfit = 3, group = [2,2], profit = [2,3] should have 2 schemes")
  void testCase1() {
    int n = 5, minProfit = 3;
    int[] group = {2, 2}, profit = {2, 3};

    ProfitableScheme profitableScheme = new ProfitableScheme();

    assertEquals(2, profitableScheme.findProfitableSchemes(n, minProfit, group, profit));
  }

  @Test
  @DisplayName("n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8] should have 7 schemes")
  void testCase2() {
    int n = 10, minProfit = 5;
    int[] group = {2, 3, 5}, profit = {6, 7, 8};

    ProfitableScheme profitableScheme = new ProfitableScheme();
    assertEquals(7, profitableScheme.findProfitableSchemes(n, minProfit, group, profit));
  }


  @Test
  void testCase3() {
    int n = 100, minProfit = 100, expected = 692206787;
    int[] group = {2, 5, 36, 2, 5, 5, 14, 1, 12, 1, 14, 15, 1, 1, 27, 13, 6, 59, 6, 1, 7, 1, 2, 7,
        6, 1, 6, 1, 3, 1, 2, 11, 3, 39, 21, 20, 1, 27, 26, 22, 11, 17, 3, 2, 4, 5, 6, 18, 4, 14, 1,
        1, 1, 3, 12, 9, 7, 3, 16, 5, 1, 19, 4, 8, 6, 3, 2, 7, 3, 5, 12, 6, 15, 2, 11, 12, 12, 21, 5,
        1, 13, 2, 29, 38, 10, 17, 1, 14, 1, 62, 7, 1, 14, 6, 4, 16, 6, 4, 32, 48},
        profit = {21, 4, 9, 12, 5, 8, 8, 5, 14, 18, 43, 24, 3, 0, 20, 9, 0, 24, 4, 0, 0, 7, 3, 13,
            6, 5, 19, 6, 3, 14, 9, 5, 5, 6, 4, 7, 20, 2, 13, 0, 1, 19, 4, 0, 11, 9, 6, 15, 15, 7, 1,
            25, 17, 4, 4, 3, 43, 46, 82, 15, 12, 4, 1, 8, 24, 3, 15, 3, 6, 3, 0, 8, 10, 8, 10, 1,
            21, 13, 10, 28, 11, 27, 17, 1, 13, 10, 11, 4, 36, 26, 4, 2, 2, 2, 10, 0, 11, 5, 22, 6};

    ProfitableScheme profitableScheme = new ProfitableScheme();
    assertEquals(expected, profitableScheme.findProfitableSchemes(n, minProfit, group, profit));
  }

  @Test
  void testCase4() {
    int n = 100, minProfit = 100, expected = 653387801;
    int[] group = {24, 23, 7, 4, 26, 3, 7, 11, 1, 7, 1, 3, 5, 26, 26, 1, 13, 12, 2, 1, 7, 4, 1, 27,
        13, 16, 26, 18, 6, 1, 1, 7, 16, 1, 6, 2, 5, 9, 19, 28, 1, 23, 2, 1, 3, 4, 4, 3, 22, 1, 1, 3,
        5, 34, 2, 1, 22, 16, 8, 5, 3, 21, 1, 8, 14, 2, 1, 3, 8, 12, 40, 6, 4, 2, 2, 14, 1, 11, 9, 1,
        7, 1, 1, 1, 6, 6, 4, 1, 1, 7, 8, 10, 20, 2, 14, 31, 1, 13, 1, 9},
        profit = {5, 2, 38, 25, 4, 17, 5, 1, 4, 0, 0, 8, 13, 0, 20, 0, 28, 1, 22, 7, 10, 32, 6, 37,
            0, 11, 6, 11, 23, 20, 13, 13, 6, 2, 36, 1, 0, 9, 4, 5, 6, 14, 20, 1, 13, 6, 33, 0, 22,
            1, 17, 12, 10, 1, 19, 13, 8, 1, 0, 17, 20, 9, 8, 6, 2, 2, 1, 4, 22, 11, 3, 2, 6, 0, 40,
            0, 0, 7, 1, 0, 25, 5, 12, 7, 19, 4, 12, 7, 4, 4, 1, 15, 33, 14, 2, 1, 1, 61, 4, 5};

    ProfitableScheme profitableScheme = new ProfitableScheme();
    assertEquals(expected, profitableScheme.findProfitableSchemes(n, minProfit, group, profit));
  }
}