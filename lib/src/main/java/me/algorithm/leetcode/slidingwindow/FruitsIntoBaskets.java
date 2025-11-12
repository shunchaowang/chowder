package me.algorithm.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two
 * baskets and your goal is to put maximum number of fruits in each basket.
 *
 * <p>The only restriction is that each basket can have only one type of fruit. You can start with
 * any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree
 * until you cannot.
 *
 * <p>i.e., you will stop when you have to pick from a third fruit type. Write a function to return
 * the maximum number of fruits in both the baskets.
 *
 * <p>Example 1: Input: Fruit=['A', 'B', 'C', 'A', 'C'] Output: 3 Explanation: We can put 2 'C' in
 * one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 * <p>Example 2: Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C'] Output: 5 Explanation: We can put 3
 * 'B' in one basket and two 'C' in the other basket. This can be done if we start with the second
 * letter: ['B', 'C', 'B', 'B', 'C']
 */
public final class FruitsIntoBaskets {
  // the goal is to find the longest substring of 2 unique letters
  // slide the windows to get the max length

  /**
   * time complexity is O(n) and space complexity is 1.
   *
   * @param fruits the fruits array
   * @return the max number of fruits fitting into 2 baskets
   */
  public static int findFruitsOptimally(final int[] fruits) {
    // 3 3 3 1 2 2 2 1 3
    int max = 0;
    int currentMax = 0;
    int lastFruit = -1;
    int secondLastFruit = -1;
    int lasFruitCount = 0;

    for (int fruit : fruits) {

      if (fruit == lastFruit || fruit == secondLastFruit) {
        currentMax++;
      } else {
        currentMax = lasFruitCount + 1;
      }

      if (fruit == lastFruit) {
        lasFruitCount++;
      } else {
        secondLastFruit = lastFruit;
        lastFruit = fruit;
        lasFruitCount = 1;
      }

      max = Math.max(max, currentMax);
    }

    return max;
  }

  public static int findIntFruits(final int[] fruits) {

    // since int is not have a known range, we should use map to track the occurrence
    // Input: fruits = [1,2,3,2,2]
    // Output: 4
    int max = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    Map<Integer, Integer> counts = new HashMap<>();
    counts.putIfAbsent(fruits[rightIndex], 1);
    while (true) {
      if (isMapValid(counts)) {
        if (rightIndex - leftIndex + 1 > max) {
          max = rightIndex - leftIndex + 1;
        }

        if (rightIndex == fruits.length - 1) {
          break;
        }
        rightIndex++;
        Integer occurrence = counts.putIfAbsent(fruits[rightIndex], 1);
        if (occurrence != null) {
          counts.put(fruits[rightIndex], occurrence + 1);
        }
      } else {
        Integer occurrence = counts.get(fruits[leftIndex]);
        if (occurrence != null) {
          counts.put(fruits[leftIndex], occurrence - 1);
        }
        leftIndex++;
      }
    }
    return max;
  }

  public static int findCharFruits(final char[] fruits) {

    int max = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    int start = 0;
    int end = 0;

    // Fruit=['A', 'B', 'C', 'B', 'B', 'C', 'D']
    // {'D', 'B', 'C', 'B', 'B', 'C'}
    // if the char is not case-sensitive
    final int COUNT_OF_CHAR = 26;
    int[] counts = new int[COUNT_OF_CHAR];
    counts[fruits[rightIndex] - 'A'] = 1;
    while (true) {

      if (isArrayValid(counts)) {
        if (rightIndex - leftIndex + 1 > max) {
          max = rightIndex - leftIndex + 1;
          start = leftIndex;
          end = rightIndex;
        }
        if (rightIndex == fruits.length - 1) {
          break;
        }
        counts[fruits[++rightIndex] - 'A']++;
      } else {
        counts[fruits[leftIndex++] - 'A']--;
        if (leftIndex > rightIndex) {
          rightIndex++;
        }
      }
    }

    //    char[] results = Arrays.copyOfRange(fruits, start, end - 1);
    return max;
  }

  /**
   * check if the counts have 2 unique chars
   *
   * @param counts the array for all the counts
   * @return true if there are 2 chars, otherwise false
   */
  private static boolean isArrayValid(int[] counts) {
    return Arrays.stream(counts).filter(e -> e > 0).count() <= 2;
  }

  /**
   * check if the counts have 2 unique int in the map
   *
   * @param counts the map containing the occurrence
   * @return true or false
   */
  private static boolean isMapValid(Map<Integer, Integer> counts) {
    return counts.values().stream().filter(e -> e > 0).count() <= 2;
  }
}
