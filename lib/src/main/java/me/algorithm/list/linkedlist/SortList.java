package me.algorithm.list.linkedlist;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [4,2,1,3] Output: [1,2,3,4] Example 2:
 * <p>
 * Input: head = [-1,5,3,4,0] Output: [-1,0,3,4,5] Example 3:
 * <p>
 * Input: head = [] Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 5 * 104]. -105 <= Node.val <= 105
 * <p>
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {

  // we can use 2 pointers to find the middle point of the list, then sort both halves individually
  // keep dividing and conquering, until the list is empty or contains single node
  // then merge the 2 lists into one
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head; // empty list or single node list
    }

    ListNode fast = head;
    ListNode slow = head;
    ListNode temp = null;

    while (fast != null && fast.next != null) {
      temp = slow; // this is to mark the end of the left half of the list
      slow = slow.next;
      fast = fast.next.next;
    }

    // now slow is the middle of the list, temp is the left node of the slow
    temp.next = null;
    ListNode leftList = sortList(head);
    ListNode rightList = sortList(slow);

    return merge(leftList, rightList);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode head = new ListNode();
    ListNode cur = head;
    while (left != null && right != null) {
      if (left.val < right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }

    if (left != null) {
      cur.next = left;
    }
    if (right != null) {
      cur.next = right;
    }

    return head.next;
  }

  static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
