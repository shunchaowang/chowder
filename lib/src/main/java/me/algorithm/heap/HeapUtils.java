package me.algorithm.heap;

import java.util.Arrays;

/**
 * head is a `complete binary tree` with heap properties complete binary tree contains perfect
 * binary and almost complete binary tree perfect binary tree is a complete tree, below is an
 * example 0 /     \ 1       2 /   \   /   \ 3    4  5     6 almost complete binary tree is a
 * complete tree with less leaves, but all leaves are on the bottom and from left to right, below is
 * an example
 * <p>
 * 0 /     \ 1       2 /   \   /   \ 3    4  5
 * <p>
 * when designing algorithm for binary tree, it's better to use height as the indicator, we
 * calculate height from 1, the root is 1, then 2,,, and leaves are the highest we use `n` to denote
 * the number of nodes on a tree, the relationship between n and h is:
 * - level h has 2's to the power of h - 1 nodes, eg, root is level 1 with nodes 1 so leaf level
 * will have 8 leaves on a complete tree with height 4 like above
 * - the total number nodes on a perfect binary tree is (2's to the power of h) - 1
 * - the total number nodes on a complete binary tree with level h is [2's to the power of (h - 1),
 * (2's to the power of h) - 1], with 1 leaf and with full leaves
 * <p>
 * binary tree can be presented by an array, assume the node is at ith, the children will be at 2i+1
 * and 2i+2, i starts from 0
 */
public final class HeapUtils {

  /**
   * heapify the ith node of the array, this only works other nodes meet heap properties time
   * complexity is O(logn), this heapifying is based on the height of the tree
   *
   * @param arr the heap to be heapified represented in arr
   * @param i   the ith node to be heapified
   */
  public static void maxHeapify(final int[] arr, final int i) {
    if (arr == null || arr.length == 0 || i >= arr.length) {
      return;
    }

    //           1
    //         /   \
    //       /       \
    //      14        8
    //    /   \      /  \
    //   9     5    6    4
    //  / \
    // 3   2
    // this binary tree is represented at
    // [1, 14, 8, 9, 5, 6, 4, 3 ,2]
    // we are heapifying 0th node `1`
    // once we have 0th node heapified, we need to recursively heapify the swapping subtrees
    // the heap should look like
    // [14, 9, 8, 3, 5, 6, 4, 1, 2]

    int leftChildIndex = 2 * i + 1;
    int rightChildIndex = 2 * i + 2;
    // if the ith node is leaf, return
    // I use a sentinel for leaf instead of check indeces
    int leftChild = leftChildIndex < arr.length ? arr[leftChildIndex] : Integer.MIN_VALUE;
    int rightChild = rightChildIndex < arr.length ? arr[rightChildIndex] : Integer.MIN_VALUE;
    if (arr[i] >= leftChild && arr[i] >= rightChild) {
      return;
    }

    // locate the larger child
    int largerChildIndex = rightChild > leftChild ? rightChildIndex : leftChildIndex;
    ;
    int tmp = arr[i];
    arr[i] = arr[largerChildIndex];
    arr[largerChildIndex] = tmp;

    // after we swap, recursively call to heapify the subtree changed
    maxHeapify(arr, largerChildIndex);
  }

  /**
   * make the arr to be a max heap
   *
   * @param arr the arr to be build
   */
  public static void buildMaxHeap(final int[] arr) {
    // consider the heap array [0, 1, 2, 3, 4, 5, 6, 7, 8], it has 9 nodes
    // n = 9, h = 4 (floor of logn + 1 assuming the root is at height 1)
    // to build a max heap from this array, we consider the heap properties
    // leves have at most 2's to the power of (h - 1) nodes, the index should start at the floor of (2h -1)/2
    // the internal nodes backward starts at the floor of (2h - 1)/2 - 1
    // calculate the tree height from node, arr length
    int h = (int) (Math.log(arr.length) / Math.log(2)) + 1;
    int capacity = (int) (Math.pow(2, h)) - 1;
    int leafStartIndex = capacity / 2;

    // start from the last internal node index to heapify the tree
    int i = leafStartIndex - 1;
    while (i >= 0) {
      maxHeapify(arr, i);
      i--;
    }

  }


  public static void main(String[] args) {

    int h = (int) (Math.log(9) / Math.log(2)) + 1;
    System.out.println("I expect a 4, actual is " + h);

    int capacity = (int) (Math.pow(2, h)) - 1;
    System.out.println("I expect a pow is 15, actual is " + capacity);
    int leafStartIndex = capacity / 2;
    System.out.println("I expect a pow is 7, actual is " + leafStartIndex);

    // test heapify
    int[] arr = {1, 14, 8, 9, 5, 6, 4, 3, 2};
    int[] expected = {14, 9, 8, 3, 5, 6, 4, 1, 2};
    maxHeapify(arr, 0);
    System.out.printf("After heapifying the arr turns %s\n", Arrays.toString(arr));
    System.out.printf("test the heapify %s to %s is %b\n",
        Arrays.toString(arr), Arrays.toString(expected), Arrays.equals(arr, expected));

    // test to build a heap
    int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    System.out.printf("build a heap from %s\n", Arrays.toString(arr1));
    buildMaxHeap(arr1);
    System.out.printf("build a heap to be %s\n", Arrays.toString(arr1));
  }

}
