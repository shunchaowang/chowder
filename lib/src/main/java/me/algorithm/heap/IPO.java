package me.algorithm.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Supplier;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture
 * Capital, LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after finishing at most k
 * distinct projects. You are given n projects where the ith project has a pure profit profits[i]
 * and a minimum capital of capital[i] is needed to start it. Initially, you have w capital. When
 * you finish a project, you will obtain its pure profit and the profit will be added to your total
 * capital. Pick a list of at most k distinct projects from given projects to maximize your final
 * capital, and return the final maximized capital. The answer is guaranteed to fit in a 32-bit
 * signed integer. Example 1:
 * <p>
 * Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1] Output: 4 Explanation: Since your
 * initial capital is 0, you can only start the project indexed 0. After finishing it you will
 * obtain profit 1 and your capital becomes 1. With capital 1, you can either start the project
 * indexed 1 or the project indexed 2. Since you can choose at most 2 projects, you need to finish
 * the project indexed 2 to get the maximum capital. Therefore, output the final maximized capital,
 * which is 0 + 1 + 3 = 4. Example 2:
 * <p>
 * Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2] Output: 6
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= 105 0 <= w <= 109 n == profits.length n == capital.length 1 <= n <= 105 0 <= profits[i]
 * <= 104 0 <= capital[i] <= 109
 */
public class IPO {

  void main() {

    /*
    Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
     */
    int k = 2;
    int w = 0;
    int[] profits = {1, 2, 3};
    int[] capital = {0, 1, 1};
    int actual = maxCapital(k, w, profits, capital);
    int expected = 4;
    assert expected == actual;
  }

  int maxCapital(int k, int w, int[] profits, int[] capital) {

    record Project(int capitalNeeded, int profitGained) {

    }

    Comparator<Project> sortByCapital = (p1, p2) -> (p1.capitalNeeded - p2.capitalNeeded);
    Comparator<Project> sortByProfit = (p1, p2) -> (p2.profitGained - p1.profitGained);

    // sort the project by capital asc
    int l = profits.length;
    Project[] projects = new Project[l];
    for (int i = 0; i < l; i++) {
      projects[i] = new Project(capital[i], profits[i]);
    }

    Arrays.sort(projects, sortByCapital);

    // create a priority queue by profit desc
    PriorityQueue<Project> maxHeap = new PriorityQueue<>(sortByProfit);

    Supplier<Integer> supplier = () -> (maxHeap.isEmpty() ? 0 : maxHeap.poll().profitGained);

    int i = 0;
    while (k-- > 0) {
      while (i < l && projects[i].capitalNeeded <= w) {
        maxHeap.offer(projects[i]);
        i++;
      }

      w += supplier.get();
    }

    return w;
  }
}



