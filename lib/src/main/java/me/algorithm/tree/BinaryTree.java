package me.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class BinaryTree<T> {

  static int pathCount = 0;
  private TreeNode<T> root;

  public BinaryTree() {
  }

  public BinaryTree(TreeNode<T> root) {
    this.root = root;
  }

  // consider a tree like this
  //      a
  //    /   \
  //   b     c
  //  / \     \
  // d   e     f
  // the dfs will be going deeper before going broader
  // the traversal will be a b d e c f
  // the idea is to finish the current node before moving to the next one
  // stack is the data structure to use
  // start with putting root into the stack, poping it and putting children
  // into the stack, until the stack is empty
  public static void dfsIteratively(TreeNode<String> root) {
    if (root == null) {
      return;
    }
    Deque<TreeNode<String>> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode<String> node = stack.pop();
      System.out.print(node.val + " ");
      // we put the children right first, the output will be left to right
      // vice versa, both are depth first search
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
  }

  public static void dfsRecursively(TreeNode<String> root) {
    if (root == null) {
      return;
    }
    // depth first, always print the root first
    System.out.print(root.val + " ");
    // traverse left child if not null
    if (root.left != null) {
      dfsRecursively(root.left);
    }
    // traverse right child if not null
    if (root.right != null) {
      dfsRecursively(root.right);
    }
  }

  // consider a tree like this
  //      a
  //    /   \
  //   b     c
  //  / \     \
  // d   e     f
  // the bfs will be going broader before going deeper
  // bfs will be a b c d e f
  public static List<String> bfs(TreeNode<String> root) {
    if (root == null) {
      return List.of(); // return an empty list instead of null
    }
    // queue can be used
    List<String> list = new ArrayList<>();
    Queue<TreeNode<String>> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode<String> node = queue.poll();
      list.add(node.val);
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }

    return list;
  }

  /**
   * Binary Tree Level Order Traversal
   *
   * <p>Given the root of a binary tree, return the level order traversal of its nodes' values.
   * (i.e., from left to right, level by level).
   *
   * <p>Example 1:
   *
   * <p>Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]]
   *
   * <p>Example 2:
   *
   * <p>Input: root = [1] Output: [[1]]
   *
   * <p>Example 3:
   *
   * <p>Input: root = [] Output: []
   *
   * <p>Constraints:
   *
   * <p>The number of nodes in the tree is in the range [0, 2000]. -1000 <= Node.val <= 1000
   *
   * @return
   */
  public static List<List<Integer>> listLevelOrder(TreeNode<Integer> root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode<Integer>> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int count = queue.size();
      List<Integer> l = new ArrayList<>();
      while (count > 0) {
        TreeNode<Integer> t = queue.poll();
        l.add(t.val);
        count--;
        if (t.left != null) {
          queue.add(t.left);
        }
        if (t.right != null) {
          queue.add(t.right);
        }
      }
      result.add(l);
    }

    return result;
  }

  public static void traverseLevelOrder(TreeNode<Integer> root) {

    if (root == null) {
      return;
    }
    // use queue FIFO or recursion
    Queue<TreeNode<Integer>> queue = new LinkedList<>();
    TreeNode<Integer> curr = root;
    // enqueue the curr element
    queue.add(curr);
    while (!queue.isEmpty()) {
      // enqueue the current element
      TreeNode<Integer> t = queue.poll();
      System.out.print(t.val + " ");
      if (t.left != null) {
        // enqueue the left
        queue.add(t.left);
      }
      if (t.right != null) {
        queue.add(t.right);
      }
    }
  }

  //public int min(TreeNode<? extends Integer> root) {
  public static int min(TreeNode<? extends Integer> root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    int minVal = Math.min(root.val, Integer.MAX_VALUE);
    int minChild = Math.min(min(root.left), min(root.right));
    return Math.min(minVal, minChild);
  }

  public static int maxRootLeafPath(TreeNode<? extends Integer> root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }
    // if it's not leaf, find the max child path
    int maxChild = Math.max(maxRootLeafPath(root.left), maxRootLeafPath(root.right));
    return root.val + maxChild;
  }

  /**
   * Hard Print all k-sum paths in a binary tree Given the root of a binary tree and an integer
   * targetSum, return the number of paths where the sum of the values along the path equals
   * targetSum.
   *
   * <p>The path does not need to start or end at the root or a leaf, but it must go downwards
   * (i.e., traveling only from parent nodes to child nodes).
   *
   * <p>Example 1:
   * <p>
   * 10 /            \ 5               -3 /       \      /           \ 3         2 11 /  \     /   \
   * 3   -2         1
   * <p>Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8 Output: 3 Explanation: The
   * paths that sum to 8 are shown.
   *
   * <p>Example 2:
   *
   * <p>Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22 Output: 3
   *
   * <p>Constraints:
   *
   * <p>The number of nodes in the tree is in the range [0, 1000]. -109 <= Node.val <= 109 -1000 <=
   * targetSum <= 1000
   *
   * @param root
   * @param targetSum
   * @return
   */
  public static int pathSum(TreeNode<Integer> root, int targetSum) {
    if (root == null) {
      return 0;
    }
    HashMap<Integer, Integer> map = new HashMap<>(); // store the map of sum of subtree -> count
    pathSumHelper(root, targetSum, map, 0);
    return pathCount;
  }

  /**
   * @param root      the node current visiting
   * @param targetSum the target sum
   * @param map       the sum of subtree to count
   * @param sum       the
   */
  private static void pathSumHelper(
      TreeNode<Integer> root, int targetSum, HashMap<Integer, Integer> map, int sum) {

    if (root.val + sum == targetSum) {
      pathCount++;
    }
  }

  public static void main(String[] args) {
    // create the tree like this
    //      a
    //    /   \
    //   b     c
    //  / \     \
    // d   e     f

    TreeNode<String> a = new TreeNode<>("a");
    TreeNode<String> b = new TreeNode<>("b");
    TreeNode<String> c = new TreeNode<>("c");
    TreeNode<String> d = new TreeNode<>("d");
    TreeNode<String> e = new TreeNode<>("e");
    TreeNode<String> f = new TreeNode<>("f");

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;
    System.out.println("DFS iteratively");
    dfsIteratively(a);
    System.out.println();
    System.out.println("DFS recursively");
    dfsRecursively(a);
    System.out.println();
    System.out.println("BFS travesal " + bfs(a));

    // int tree like this
    //       5
    //    /     \
    //   14      3
    //  /  \      \
    // 6    1      4
    TreeNode<Integer> n5 = new TreeNode<>(5);
    TreeNode<Integer> n14 = new TreeNode<>(14);
    TreeNode<Integer> n3 = new TreeNode<>(3);
    TreeNode<Integer> n6 = new TreeNode<>(6);
    TreeNode<Integer> n1 = new TreeNode<>(1);
    TreeNode<Integer> n4 = new TreeNode<>(4);
    n5.left = n14;
    n5.right = n3;
    n14.left = n6;
    n14.right = n1;
    n3.right = n4;

    System.out.printf("the min of tree should be 1, actual is %d\n", min(n5));
    System.out.printf("the max root to leaf path should be 25, actual is %d\n",
        maxRootLeafPath(n5));
  }

  public TreeNode<T> getRoot() {
    return this.root;
  }

  public void setRoot(TreeNode<T> root) {
    this.root = root;
  }
}
