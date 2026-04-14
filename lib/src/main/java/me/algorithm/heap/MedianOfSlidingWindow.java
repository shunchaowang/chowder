package me.algorithm.heap;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there
 * is no middle value. So the median is the mean of the two middle values.
 * <p>
 * For examples, if arr = [2,3,4], the median is 3. For examples, if arr = [1,2,3,4], the median is
 * (2 + 3) / 2 = 2.5. You are given an integer array nums and an integer k. There is a sliding
 * window of size k which is moving from the very left of the array to the very right. You can only
 * see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the median array for each window in the original array. Answers within 10-5 of the actual
 * value will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output:
 * [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000] Explanation: /// ``` /// Window position
 *             Median /// ---------------                  ----- /// [1  3  -1] -3  5  3  6  7
 *  1 /// 1 [3  -1  -3] 5  3  6  7        -1 /// 1  3 [-1  -3  5] 3  6  7        -1 /// 1  3  -1 [-3
 *  5  3] 6  7         3 /// 1  3  -1  -3 [5  3  6] 7         5 /// 1  3  -1  -3  5 [3  6  7]
 * 6 /// ``` Example 2:
 * <p>
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3 Output:
 * [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 105 -231 <= nums[i] <= 231 - 1
 */
public class MedianOfSlidingWindow {

  // we want to use max heap to store the left half of the window
  // we want to use min heap to store the right half of the window
  // we want to keep the size of the left half and right half as close as possible
  // we want to keep the max of the left half less than or equal to the min of the right half
  // we want to remove the element that is going out of the window from the heap
  // we want to add the new element to the heap
  // we want to balance the heap if necessary
  public double[] medianSlidingWindow(int[] nums, int k) {

    double[] ans = new double[nums.length - k + 1];

    // a comparator for both max heap and min heap, we want to use
    // the numbers at the key to compare and sort, but to avoid the duplicated values, we store the
    // index of the number in the array in the heap
    // we want to use the TreeSet instead of the PriorityQueue, TreeSet provides the log(n) time
    // complexity for the add and remove operations
    Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a],
        nums[b]) : a - b;

    // right size is always equal or one more than the left size
    TreeSet<Integer> left = new TreeSet<>(comparator.reversed()); // this is the left side and the top is the largest number
    TreeSet<Integer> right = new TreeSet<>(comparator); // this is the right side and the top is the smallest number

    // add a thread to balance the left and right
    Runnable balancer = () -> {while (left.size() > right.size()) right.add(left.pollFirst());};

    Supplier<Double> medianSupplier = () -> left.size() == right.size() ? (nums[left.first()] + nums[right.first()]) / 2.0
        : (double) nums[right.first()];

    for (int i =0;i<k;i++) {
      left.add(i);
    }
    balancer.run();
    ans[0] = medianSupplier.get();

    for (int i = k, j = 1; i < nums.length; i++, j++) {
      // remove i-k from the heap
      // add i to the heap
      // balance the heap
      // update the median
      if (!left.remove(i - k))
        right.remove(i - k);
      right.add(i);
      left.add(right.pollFirst());
      balancer.run();
      ans[j] = medianSupplier.get();
    }

    return ans;
  }
}
