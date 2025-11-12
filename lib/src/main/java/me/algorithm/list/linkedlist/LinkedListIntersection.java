package me.algorithm.list.linkedlist;

/**
 * Leetcode
 *
 * <p>Given the heads of two singly linked-lists headA and headB, return the node at which the two
 * lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * <p>The test cases are generated such that there are no cycles anywhere in the entire linked
 * structure.
 *
 * <p>Note that the linked lists must retain their original structure after the function returns.
 *
 * <p>Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?
 *
 * <p>Custom Judge:
 *
 * <p>The inputs to the judge are given as follows (your program is not given these inputs):
 *
 * <p>intersectVal - The value of the node where the intersection occurs. This is 0 if there is no
 * intersected node. listA - The first linked list. listB - The second linked list. skipA - The
 * number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the
 * intersected node. The judge will then create the linked structure based on these inputs and pass
 * the two heads, headA and headB to your program. If you correctly return the intersected node,
 * then your solution will be accepted.
 *
 * <p>
 *
 * <ul>
 *   <li>Example 1
 *       <p>Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB =
 *       3 Output: Intersected at '8' Explanation: The intersected node's value is 8 (note that this
 *       must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5].
 *       From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected
 *       node in A; There are 3 nodes before the intersected node in B.
 *   <li>Example 2 Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
 *       1 Output: Intersected at '2' Explanation: The intersected node's value is 2 (note that this
 *       must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4].
 *       From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in
 *       A; There are 1 node before the intersected node in B.
 *   <li>Example 3 Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 *       Output: No intersection Explanation: From the head of A, it reads as [2,6,4]. From the head
 *       of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
 *       while skipA and skipB can be arbitrary values. Explanation: The two lists do not intersect,
 *       so return null.
 * </ul>
 *
 * <p>Solution
 *
 * <p>First to find the different length of two lists, then make two lists move forward the same
 * time.
 */
public class LinkedListIntersection {

  private LinkedListIntersection() {
  }

  public static Integer findInteraction(LinkedNode listA, LinkedNode listB) {

    if (listA == null || listB == null) {
      return null;
    }

    int lengthA = 0;
    int lengthB = 0;
    LinkedNode currA = listA;
    LinkedNode currB = listB;
    while (currA != null) {
      lengthA++;
      currA = currA.next;
    }
    while (currB != null) {
      lengthB++;
      currB = currB.next;
    }

    currA = listA;
    currB = listB;

    // if lengthA is bigger, move listA forward of lengthA - lengthB
    if (lengthA > lengthB) {
      for (int i = 0; i < lengthA - lengthB; i++) {
        currA = currA.next;
      }
    } else if (lengthB > lengthA) {
      // if lengthB is bigger, move listB forward of lengthB - lengthA
      for (int i = 0; i < lengthB - lengthA; i++) {
        currB = currB.next;
      }
    }

    // else they are equal length
    // now we can move both list simultaneously
    while (currA != null && currB != null) {
      if (currA.data == currB.data) {
        return currA.data;
      }

      currA = currA.next;
      currB = currB.next;
    }
    return null;
  }
}
