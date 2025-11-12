package me.algorithm.array;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining. Example 1:
 * <p>
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The above elevation map (black
 * section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped. Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5] Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == height.length 1 <= n <= 2 * 104 0 <= height[i] <= 105
 */
public class TrapRainWater {

  /**
   * we need to find all the valleys with the min highest sides to be the height water can be
   * trapped.
   */
  public int trap(int[] height) {

    int l = height.length;
    int sum = 0;

    // we use both prefix and suffix of the array
    int[] maxLeft = new int[l]; // the max height to the left of the ith bar
    int[] maxRight = new int[l]; // the max height to the right of the ith bar

    // maxLeft[0] is 0 since there is no bar to the left of the 1st bar
    for (int i = 1; i < l; i++) {
      maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
    }

    // maxRight[l-1] is 0 since there is no bar to the right of the last bar
    for (int i = l - 2; i >= 0; i--) {
      maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
    }

    // now we calculate the water trapped by every bar
    for (int i = 0; i < l; i++) {
      // the bar needs to be lower than the min of maxLeft and maxRight to
      // be able to trap the water
      int level = Math.min(maxLeft[i], maxRight[i]);
      if (height[i] < level) {
        sum += level - height[i];
      }
    }

    return sum;
  }
}
