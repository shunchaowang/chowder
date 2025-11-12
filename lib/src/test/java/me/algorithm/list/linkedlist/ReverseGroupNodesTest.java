package me.algorithm.list.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import me.algorithm.list.linkedlist.ReverseGroupNodes.ListNode;
import org.junit.jupiter.api.Test;

class ReverseGroupNodesTest {

  @Test
  void test1() {
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    List<Integer> reversedList = List.of(2, 1, 4, 3, 5);
    ListNode head = null, curr = null;

    for (int i = 0; i < list.size(); i++) {
      ListNode newNode = new ListNode(list.get(i));

      if (i == 0) {
        head = newNode;
        curr = newNode;
      }

      curr.next = newNode;
      curr = newNode;
    }

    curr = new ReverseGroupNodes().reverseKGroup(head, 2);

    for (Integer integer : reversedList) {
      assertEquals(integer, curr.val);
      curr = curr.next;
    }
  }
}