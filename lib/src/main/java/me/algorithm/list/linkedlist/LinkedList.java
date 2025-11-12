package me.algorithm.list.linkedlist;

import java.util.HashSet;
import java.util.Random;

public final class LinkedList {

  static LinkedNode head = new LinkedNode(5);
  static int bound = 10;

  static {
    LinkedNode curr = head;
    Random random = new Random();
    for (int i = 0; i < 10; i++) {

      LinkedNode n = new LinkedNode(random.nextInt(bound));
      curr.next = n;
      curr = curr.next;
    }
  }

  public static LinkedNode toLinkedList(int[] nums) {
    LinkedNode head = new LinkedNode(nums.length);
    LinkedNode curr = head;
    for (int i : nums) {
      LinkedNode node = new LinkedNode(i);
      curr.next = node;
      curr = node;
    }

    return head.next;
  }

  public static LinkedNode reverse(LinkedNode head) {

    if (head == null || head.next == null) {
      return head;
    }
    LinkedNode curr = head;
    LinkedNode next = null;
    LinkedNode prev = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static LinkedNode reverseRecursively(LinkedNode head) {
    // consider the linked list below
    // 1 2 3 4 5 => 5 4 3 2 1
    if (head == null || head.next == null) {
      return head;
    }
    // stack 1 2 3
    //  stack 2 3
    //  stack 3
    LinkedNode p = head.next;
    LinkedNode h = reverseRecursively(p);
    h.next = head;
    head.next = null;
    return h;
  }

  /**
   * Given the head of a linked list, reverse the nodes of the list k at a time, and return the
   * modified list.
   * <p>
   * k is a positive integer and is less than or equal to the length of the linked list. If the
   * number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it
   * is.
   * <p>
   * You may not alter the values in the list's nodes, only nodes themselves may be changed. Example
   * 1:
   * <p>
   * Input: head = [1,2,3,4,5], k = 2 Output: [2,1,4,3,5] Example 2:
   * <p>
   * Input: head = [1,2,3,4,5], k = 3 Output: [3,2,1,4,5]
   * <p>
   * Constraints:
   * <p>
   * The number of nodes in the list is n. 1 <= k <= n <= 5000 0 <= Node.val <= 1000
   * <p>
   * Follow-up: Can you solve the problem in O(1) extra memory space?
   *
   * @param head
   * @param k
   * @return
   */
  public static LinkedNode reverse(LinkedNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    // use recursion
    int count = 0;
    LinkedNode curr = head;
    LinkedNode next = null;
    LinkedNode prev = null;
    while (curr != null && count < k) {
      count++;
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    // now prev is the head of new list
    // if curr == null and count < k, the list remain the same, so we reverse it
    // back
    if (curr == null && count < k) {

      curr = prev;
      prev = null;
      while (count > 0) {
        count--;
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
    }
    if (curr != null) {
      head.next = reverse(curr, k);
    }

    return prev;
  }

  public static void main(String[] args) {
    System.out.print("Original linked list is: ");
    LinkedNode curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();

    removeDupsSet(head);
    System.out.print("Updated linked list running is: ");
    curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();
    int[] nums = {1, 2, 3, 4, 5};
    LinkedNode h = toLinkedList(nums);
    System.out.printf("Original list is %s\n", toString(h));
    LinkedNode newHead = reverseRecursively(h);
    System.out.printf("Reversed list is %s\n", toString(newHead));
  }

  private static void removeDupsInPlace(LinkedNode list) {
    LinkedNode curr = list, runner = list;

    while (curr != null) {
      runner = curr;

      while (runner.next != null) {
        if (runner.next.data == curr.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      curr = curr.next;
    }
  }

  private static void removeDupsSet(LinkedNode list) {
    HashSet<Integer> set = new HashSet<>();
    LinkedNode curr = list;
    LinkedNode prev = null;

    while (curr != null) {
      if (set.contains(curr.data)) {
        prev.next = curr.next;
      } else {
        set.add(curr.data);
        prev = curr;
      }
      curr = curr.next;
    }
  }

  private static String toString(LinkedNode h) {
    StringBuilder sb = new StringBuilder();
    LinkedNode c = h;
    while (c != null) {
      sb.append(c.data + " ");
      c = c.next;
    }
    return sb.toString();
  }
}
