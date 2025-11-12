package me.algorithm.list.linkedlist;

public class SumList {

  private static int fromList(LinkedNode node) {
    int i = 0, total = 0;

    LinkedNode curr = node;
    while (curr != null) {
      int multi = (int) Math.pow(10, i);
      total += curr.data * multi;
      curr = curr.next;
      i++;
    }

    return total;
  }

  private static LinkedNode fromInt(int num) {
    LinkedNode n = new LinkedNode(0);
    LinkedNode curr = n;
    while (num > 0) {
      LinkedNode newNode = new LinkedNode(num % 10);
      curr.next = newNode;
      curr = curr.next;
      num /= 10;
    }

    return n.next;
  }

  public static void main(String[] args) {
    LinkedNode n1 = new LinkedNode(3);
    LinkedNode curr = n1;
    for (int i = 1; i < 3; i++) {
      LinkedNode n = new LinkedNode(i);
      curr.next = n;
      curr = curr.next;
    }

    System.out.println(fromList(n1));
    LinkedNode n2 = new LinkedNode(9);
    curr = n2;
    for (int i = 4; i < 6; i++) {
      LinkedNode n = new LinkedNode(i);
      curr.next = n;
      curr = curr.next;
    }

    System.out.println(fromList(n2));

    int sum = fromList(n1) + fromList(n2);

    System.out.println(sum);

    LinkedNode node = fromInt(sum);

    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }
}
