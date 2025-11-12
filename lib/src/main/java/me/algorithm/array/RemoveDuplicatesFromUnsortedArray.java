package me.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * Google Interview
 *
 * <p>Given an unsorted array of integers, print the array after removing the duplicate elements
 * from it. We need to print distinct array elements according to their first occurrence.
 *
 * <p>Examples: Input : arr[] = { 1, 2, 5, 1, 7, 2, 4, 2} Output : 1 2 5 7 4 Explanation : {1, 2}
 * appear more than one time.
 *
 * <p>There are 3 approaches to solve the problem:
 *
 * <ul>
 *   <li>we can sort the array then follow the same way to remove the duplicates from a sorted
 *       array, this is an in-place without needing any extra ds, but this cannot retain the order
 *       of the array.
 *   <li>create a map, the key is the element and the value is the occurrence. Once all elements are
 *       iterated, we just need to iterate the map to create a new array containing all the keys.
 *       This is not an in-place. To retaining the order, we can use LinkedHashMap which is
 *       implemented using a double linked list. Normal HashMap doesn't guarantee the insertion
 *       order.
 *   <li>create a set. HashSet cannot retain the order, use LinkedHashSet to retain the order.
 * </ul>
 *
 * <br>
 *
 * @param nums
 * @return
 */
public class RemoveDuplicatesFromUnsortedArray {

  private RemoveDuplicatesFromUnsortedArray() {
  }

  public static int[] removeBySorting(int[] nums) {
    Arrays.sort(nums);
    int length = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
    return Arrays.copyOf(nums, length);
  }

  public static int[] removeByMap(int[] nums) {
    // use LinkedHashMap to preserve the insertion order
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    List<Integer> l = new ArrayList<>();
    map.forEach((k, v) -> l.add(k));
    return l.stream().mapToInt(i -> i).toArray();
  }

  public static int[] removeBySet(int[] nums) {
    // use LinkedHashSet to guarantee the insertion order
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    return set.stream().mapToInt(i -> i).toArray();
  }
}
