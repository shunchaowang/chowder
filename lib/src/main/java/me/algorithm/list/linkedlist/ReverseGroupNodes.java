package me.algorithm.list.linkedlist;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the
 * modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number
 * of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Example 1:
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
 */
public class ReverseGroupNodes {

  public static class ListNode {

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

  public ListNode reverseKGroup(ListNode head, int k) {
    // i need to know if this is the last reverse, we iterate the list once then calculate the reverse
    int totalNode = 0;
    ListNode cur = head;
    while (cur != null) {
      totalNode++;
      cur = cur.next;
    }

    cur = head;
    int reversedNode = 0;
    ListNode conn = new ListNode();
    while (cur != null) {

      ListNode end = null;
      ListNode tail = null;
      for (int i = 0; i < k; i++) {
        // save next of cur
        // add this cur as the last of the sub list
        ListNode next = cur.next;
        // cur becomes the tail of the sub list, if i == 0, we need to save this cur as the tail
        cur.next = end;
        end = cur;
        if (i == 0) {
          tail = end;
        }

        cur = next;
        reversedNode++;
      }

      // if this is the 1st reverse we need to set up the head
      if (reversedNode == k) {
        head = end;
      }

      conn.next = end;
      conn = tail;

      if (totalNode - reversedNode < k) {
        conn.next = cur;
        break;
      }

    }

    return head;
  }
}
