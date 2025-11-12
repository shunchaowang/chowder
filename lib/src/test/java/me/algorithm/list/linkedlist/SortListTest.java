package me.algorithm.list.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.algorithm.list.linkedlist.SortList.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortListTest {

  @Test
  @DisplayName("[-1,5,3,4,0] to be sorted")
  void case1() {
    ListNode head = new ListNode(-1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(0);

    SortList sortList = new SortList();
    sortList.sortList(head);

    assertEquals(-1, head.val);
  }
}