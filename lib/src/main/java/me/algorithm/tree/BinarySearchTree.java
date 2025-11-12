package me.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BinarySearchTree {

  static int index = 0;
  private TreeNode<Integer> root;

  public BinarySearchTree(TreeNode<Integer> root) {
    this.root = root;
  }

  /**
   * create a balanced bst from a sorted array the array is sorted, so the largest element is at the
   * middle of the array
   */
  public BinarySearchTree(final int[] arr) {
    // [1, 2, 3, 5, 6] will becomes
    //      3
    //  /       \
    // 1         6
    //  \       /
    //   2     5
    // since the array is sorted, the mid element [arr.length/2] would be the root of the bst
    // then we recursively create the left and right subtree based on the left and right half of the array
    this.root = arrayToBST(arr, 0, arr.length - 1);
  }

  /**
   * convert a normal binary tree to a bst and maintain the tree structure, the strategy is to
   * create an array from the bst from in order traversal, this will generate a sorted array then we
   * place the elements back into the tree by in order traversal.
   */
  public static void binaryTreeToBST(TreeNode<Integer> root) {
    // the binary tree looks like
    //          1
    //    /           \
    //   2             3
    //     \         /
    //       5      6
    // should be converted like
    //          3
    //    /            \
    //   1              6
    //    \           /
    //     2         5
    // when inorder traversing a bst, it will generate a sorted array, we need to sort the array

    List<Integer> nodes = inOrderTraverse(root); // the array is [2, 5, 1, 6, 3]
    nodes.sort((a, b) -> a - b); // the array is [1, 2, 3, 5, 6]
    index = 0;
    arrayToBST(nodes, root);

  }

  public static void arrayToBST(List<Integer> array, TreeNode<Integer> root) {
    if (root == null) {
      return;
    }
    arrayToBST(array, root.left);
    root.val = array.get(index);
    arrayToBST(array, root.right);
  }

  public static List<Integer> preOrderTraverse(TreeNode<Integer> root) {
    List<Integer> l = new ArrayList<>();
    if (root == null) {
      return l;
    }

    // root comes first
    l.add(root.val);
    // recursively traverse every left child and right child
    if (root.left != null) {
      l.addAll(preOrderTraverse(root.left));
    }
    if (root.right != null) {
      l.addAll(preOrderTraverse(root.right));
    }

    return l;
  }

  public static List<Integer> inOrderTraverse(TreeNode<Integer> root) {
    List<Integer> l = new ArrayList<>();
    if (root == null) {
      return l;
    }

    // recursively traverse every left child and right child
    if (root.left != null) {
      l.addAll(inOrderTraverse(root.left));
    }
    l.add(root.val);
    if (root.right != null) {
      l.addAll(inOrderTraverse(root.right));
    }

    return l;
  }

  public static List<Integer> postOrderTraverse(TreeNode<Integer> root) {
    List<Integer> l = new ArrayList<>();
    if (root == null) {
      return l;
    }

    // recursively traverse every left child and right child
    if (root.left != null) {
      l.addAll(postOrderTraverse(root.left));
    }
    if (root.right != null) {
      l.addAll(postOrderTraverse(root.right));
    }
    l.add(root.val);

    return l;
  }

  public static void main(String[] args) {

    // int tree like this
    //       5
    //    /     \
    //   4       6
    //  /  \      \
    // 1    3      14
    TreeNode<Integer> n5 = new TreeNode<>(5);
    TreeNode<Integer> n14 = new TreeNode<>(14);
    TreeNode<Integer> n3 = new TreeNode<>(3);
    TreeNode<Integer> n6 = new TreeNode<>(6);
    TreeNode<Integer> n1 = new TreeNode<>(1);
    TreeNode<Integer> n4 = new TreeNode<>(4);
    n5.left = n4;
    n5.right = n6;
    n4.left = n1;
    n4.right = n3;
    n6.right = n14;

    System.out.printf("pre order traverse is %s\n",
        Arrays.toString(preOrderTraverse(n5).toArray(new Integer[0])));
    System.out.printf("in order traverse is %s\n",
        Arrays.toString(inOrderTraverse(n5).toArray(new Integer[0])));
    System.out.printf("post order traverse is %s\n",
        Arrays.toString(postOrderTraverse(n5).toArray(new Integer[0])));

    // the binary tree looks like
    //          1
    //    /           \
    //   2             3
    //     \         /
    //       5      6
    // should be converted like
    //          3
    //    /            \
    //   1              6
    //    \           /
    //     2         5

    TreeNode<Integer> case1n1 = new TreeNode<Integer>(1);
    TreeNode<Integer> case1n2 = new TreeNode<Integer>(2);
    TreeNode<Integer> case1n3 = new TreeNode<Integer>(3);
    TreeNode<Integer> case1n5 = new TreeNode<Integer>(5);
    TreeNode<Integer> case1n6 = new TreeNode<Integer>(6);

    // create the binary tree
    case1n1.left = case1n2;
    case1n1.right = case1n3;
    case1n2.right = case1n5;
    case1n3.left = case1n6;

    System.out.printf("in order traverse is %s\n",
        Arrays.toString(inOrderTraverse(case1n1).toArray(new Integer[0])));
    binaryTreeToBST(case1n1);
    System.out.printf("in order traverse is after converting to bst %s\n",
        Arrays.toString(inOrderTraverse(case1n1).toArray(new Integer[0])));

    // array [1, 2, 3, 4, 5]
    int[] arr = {1, 2, 3, 4, 5};
    BinarySearchTree bstFromSortedArray = new BinarySearchTree(arr);
    System.out.printf("pre order traverse is %s\n",
        Arrays.toString(preOrderTraverse(bstFromSortedArray.getRoot()).toArray(new Integer[0])));

  }

  private TreeNode<Integer> arrayToBST(final int[] arr, int start, int end) {
    if (arr == null || arr.length == 0) {
      return null;
    }
    if (start > end) {
      return null;
    }
    int m = (start + end) / 2;
    TreeNode<Integer> root = new TreeNode<>(arr[m]);
    root.left = arrayToBST(arr, start, m - 1);
    root.right = arrayToBST(arr, m + 1, end);
    return root;
  }

  public TreeNode<Integer> getRoot() {
    return root;
  }

  public void setRoot(TreeNode<Integer> root) {
    this.root = root;
  }

}
