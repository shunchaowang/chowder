package me.algorithm.list.linkedlist;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LinkedListIntersectionTest {

  private final Logger logger = LoggerFactory.getLogger(LinkedListIntersectionTest.class);

  @Test
  void testCommonCase() {
    int[] arrA = {2, 4, 1, 5, 8, 9};
    int[] arrB = {3, 5, 8, 9};
    LinkedNode listA = LinkedNode.fromArray(arrA);
    LinkedNode listB = LinkedNode.fromArray(arrB);
    logger.info("test {} and {} intersection at {}", arrA, arrB, 5);
    assertSame(5, LinkedListIntersection.findInteraction(listA, listB));
  }
}
