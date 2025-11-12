package me.algorithm.list.linkedlist;

public class LinkedNode {

  int data;
  LinkedNode next;

  public LinkedNode(int data) {
    this.data = data;
    next = null;
  }

  public static LinkedNode fromArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      return null;
    }

    LinkedNode head = new LinkedNode(arr[0]);
    LinkedNode curr = head;
    LinkedNode node = null;
    for (int i = 1; i < arr.length; i++) {
      node = new LinkedNode(arr[i]);
      curr.next = node;
      curr = node;
    }
    return head;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public LinkedNode getNext() {
    return next;
  }

  public void setNext(LinkedNode next) {
    this.next = next;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + data;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LinkedNode other = (LinkedNode) obj;
    if (data != other.data) {
      return false;
    }
    return true;
  }
}
