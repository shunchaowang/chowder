package me.algorithm.list;

/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]
*/
public class MergeTwoSortedList {

  private static ListNode merge(ListNode n1, ListNode n2) {
    if (n1 == null) {
      return n2;
    }
    if (n2 == null) {
      return n1;
    }

    ListNode head = new ListNode(), curr = head; // create a head as the dog watcher

    ListNode c1 = n1, c2 = n2;
    while (c1 != null && c2 != null) {
      if (c1.val < c2.val) {
        curr.next = c1;
        c1 = c1.next;
      } else {
        curr.next = c2;
        c2 = c2.next;
      }
      curr = curr.next;
    }

    // if c1 is pointing to the null, append c2 to the curr, vice versa
    if (c1 == null) {
      curr.next = c2;
    } else {
      curr.next = c1;
    }

    return head.next;
  }

  private static class ListNode {

    int val;
    ListNode next;

    public ListNode() {
      val = 0;
      next = null;
    }

    public ListNode(int val) {
      this.val = val;
      next = null;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
