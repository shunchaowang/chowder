package me.algorithm.leetcode.binarysearch;

import java.util.Collections;
import java.util.List;

/**
 * There are n packages that needs to be transported from one city to another, and you need to
 * transport them there within d days For the ith package, the weight of the package is weights[i]
 * You are required to deliver them in order with a rental truck The rental trucks come in different
 * sizes The bigger trucks have greater weight capacity but cost more to rent To minimize cost, you
 * want to deliver the packages in one truck once per day, with a weight capacity as small as
 * possible to save on rental cost What is the minimum weight capacity of the truck that is required
 * to deliver all packages within d days?
 * <p>
 * Input weights: A list of packages and their weights d: The number of days to deliver all packages
 * Output The minimum weight capacity of the truck Examples Example 1: Input: 1weights = [1, 2, 3,
 * 4, 5, 6, 7, 8, 9, 10] d = 5 Output: 15 Explanation: The first day we deliver the first 5 package
 * The second day we deliver the next 2, and for each following days, we deliver 1 The maximum
 * weight delivered on each day is 15, so we can have a truck with a capacity of 15 This value is
 * the minimum Constraints 1 <= len(weights) <= 5 * 10^4 1 <= d <= len(weights) 1 <= weights[i] <=
 * 500
 */
public class CapacityToShipPackagesInDays {

  // the concept is that if we can have the biggest capacity to put all packages in it, then it can be delivered in 1
  // day
  // we need to find the min capacity within the days, binary search
  //
  public static int minCapacityToShip(List<Integer> packages, int days) {
    // calculate the sum
    int sum = 0;
    for (int p : packages) {
      sum += p;
    }

    int max = sum;
    int min = Collections.max(packages);
    int result = max;
    while (min <= max) {
      int capacity = (min + max) / 2;
      if (canShip(packages, days, capacity)) {
        max = capacity - 1;
        result = capacity;
      } else {
        min = capacity + 1;
      }
    }
    return result;
  }

  public static boolean canShip(List<Integer> packages, int days, int capacity) {
    int neededDays = 1;
    int sum = capacity;

    int i = 0;
    while (i < packages.size()) {
      if (sum >= packages.get(i)) {
        sum -= packages.get(i);
        i++;
      } else {
        sum = capacity;
        neededDays++;
      }
    }
    return neededDays <= days;
  }

}
