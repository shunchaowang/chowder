package me.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelTraversal {

  public static class Node<T> {

    public T val;
    public Node<T> left;
    public Node<T> right;

    public Node(T val) {
      this(val, null, null);
    }

    public Node(T val, Node<T> left, Node<T> right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // we need to add all children to the queue when finishing
  // iterating the current levels
  public void bfs(Node<Integer> root, List<List<Integer>> res) {
    if (root == null) {
      return;
    }
    Queue<Node<Integer>> queue = new ArrayDeque<>();
    queue.add(root);
    List<Integer> path = new ArrayList<>();
    List<Node<Integer>> children = new ArrayList<>();
    while (!queue.isEmpty()) {
      // for all the nodes on this level
      // if the queue is empty, it means this level is done, add
      // all the children
      Node<Integer> node = queue.poll();
      path.add(node.val);
      if (node.left != null) {
        children.add(node.left);
      }
      if (node.right != null) {
        children.add(node.right);
      }
      if (queue.isEmpty()) {
        res.add(path);
        path = new ArrayList<>();
        queue.addAll(children);
        children = new ArrayList<>();
      }
    }

  }

  public List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
    // WRITE YOUR BRILLIANT CODE HERE
    List<List<Integer>> res = new ArrayList<>();
    bfs(root, res);
    return res;
  }
}
