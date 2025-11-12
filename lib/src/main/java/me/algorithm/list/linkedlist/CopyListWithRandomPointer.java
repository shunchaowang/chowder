package me.algorithm.list.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node. Both the
 * next and random pointer of the new nodes should point to new nodes in the copied list such that
 * the pointers in the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for
 * the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented
 * as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val random_index: the index of the node (range from 0 to n-1)
 * that the random pointer points to, or null if it does not point to any node. Your code will only
 * be given the head of the original linked list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 * <p>
 * Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]] Example 3:
 * <p>
 * Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 1000 -104 <= Node.val <= 104 Node.random is null or is pointing to some node in the
 * linked list.
 */
public class CopyListWithRandomPointer {

  public static class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    // [[7,null],[13,0],[11,4],[10,2],[1,0]]
    // we can have an index, for each node, if the random points to the
    // index less than the current node index, then we need point the random to it;
    // every time we deep copy the node, we add it to a map of index->node
    // if the current node points to the future index, we make it null
    // once we finish all the nodes, we iterate the linked list again
    // we create a new flat node, the next is null and the random is the index of the
    // node the node points to
    // create a map for the index
    Map<Node, Integer> nodeIndexMap = new HashMap<>();
    Node curr = head;
    int i = 0;
    while (curr != null) {
      nodeIndexMap.put(curr, i++);
      curr = curr.next;
    }

    // create a map for the random pointer, 0->null, 1->0
    Map<Integer, Integer> randomPointIndexMap = new HashMap<>();
    curr = head;
    i = 0;
    while (curr != null) {
      randomPointIndexMap.put(i++, curr.random == null ? null : nodeIndexMap.get(curr.random));
      curr = curr.next;
    }

    // create a map for index to new node
    Map<Integer, Node> newIndexNodeMap = new HashMap<>();
    Node newHead = new Node(0);
    Node newCurr = newHead;
    curr = head;
    for (int j = 0; j < i; j++) {
      Node newNode = new Node(curr.val);
      newIndexNodeMap.put(j, newNode);
      newCurr.next = newNode;
      newCurr = newCurr.next;
      curr = curr.next;
    }

    newCurr = newHead.next;
    curr = head;
    while (newCurr != null) {
      newCurr.random = randomPointIndexMap.get(nodeIndexMap.get(curr)) == null ? null
          : newIndexNodeMap.get(randomPointIndexMap.get(nodeIndexMap.get(curr)));
      newCurr = newCurr.next;
      curr = curr.next;
    }

    return newHead.next;
  }
}
