package me.algorithm.list.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.algorithm.list.linkedlist.CopyListWithRandomPointer.Node;
import org.junit.jupiter.api.Test;

class CopyListWithRandomPointerTest {

  @Test
  void test1() {
    // create the linked list
    // Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    // Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
    Node node7 = new Node(7);
    Node node13 = new Node(13);
    node7.next = node13;
    Node node11 = new Node(11);
    node13.next = node11;
    Node node10 = new Node(10);
    node11.next = node10;
    Node node1 = new Node(1);
    node10.next = node1;

    node7.random = null;
    node13.random = node7;
    node11.random = node1;
    node10.random = node11;
    node1.random = node7;

    Node newNode = new CopyListWithRandomPointer().copyRandomList(node7);
    assertEquals(7, newNode.val);
  }

}