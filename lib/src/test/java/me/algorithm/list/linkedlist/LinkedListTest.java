package me.algorithm.list.linkedlist;

import static me.algorithm.list.linkedlist.LinkedList.reverse;
import static me.algorithm.list.linkedlist.LinkedList.toLinkedList;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

;

public class LinkedListTest {

  private final static Logger LOGGER = LoggerFactory.getLogger(LinkedListTest.class);

  @Test
  public void testReverseGroup() {
    int[] nums = {1, 2, 3, 4, 5};
    LinkedNode head = toLinkedList(nums);
    int k = 3;
    LinkedNode node = reverse(head, k);
    LOGGER.debug("The reverse linked list is {}", node.data);
  }
}
