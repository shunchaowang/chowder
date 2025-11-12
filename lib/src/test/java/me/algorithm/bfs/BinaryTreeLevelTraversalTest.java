package me.algorithm.bfs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import me.algorithm.bfs.BinaryTreeLevelTraversal.Node;
import org.junit.jupiter.api.Test;

class BinaryTreeLevelTraversalTest {

  @Test
  void levelOrderTraversal() {

    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.right = new Node<>(6);
    root.left.left.right = new Node<>(7);

    BinaryTreeLevelTraversal binaryTreeLevelTraversal = new BinaryTreeLevelTraversal();
    List<List<Integer>> res = binaryTreeLevelTraversal.levelOrderTraversal(root);

    assertEquals(4, res.size());
  }
}