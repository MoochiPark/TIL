package io.wisoft.seminar.lecture.algorithm.bst;

public class BST {


  public void destroyNode(BSTNode node) {
    node = null;
  }

  public void destroyTree(final BSTNode tree) {
    if (tree.right != null)
      destroyTree(tree.right);
    if (tree.left != null)
      destroyTree(tree.left);

    tree.right = null;
    tree.left = null;
    destroyNode(tree);
  }

  public BSTNode searchNode(final BSTNode tree, final char target) {
    if (tree == null)
      return null;

    if (target < tree.data)
      return searchNode(tree.left, target);
    else if (target > tree.data)
      return searchNode(tree.right, target);
    else
      return tree;
  }

  public BSTNode searchMinNode(final BSTNode tree) {
    if (tree == null)
      return null;

    if (tree.left == null)
      return tree;
    else
      return searchMinNode(tree.left);
  }

  public void insertNode(final BSTNode tree, final BSTNode child) {
    if (tree.data < child.data) {
      if (tree.right == null)
        tree.right = child;
      else insertNode(tree.right, child);
    } else if (tree.data > child.data) {
      if (tree.left == null)
        tree.left = child;
      else insertNode(tree.left, child);
    }
  }

  public BSTNode removeNode(final BSTNode tree, final BSTNode parent, final char target) {
    BSTNode removed = null;
    if (tree == null)
      return null;

    if (tree.data > target)
      removed = removeNode(tree.left, tree, target);
    else if (tree.data < target)
      removed = removeNode(tree.right, tree, target);
    else {
      removed = tree;

      //잎 노드 인경우 바로 삭제
      if (tree.left == null && tree.right == null) {
        if (parent.left == tree)
          parent.left = null;
        else parent.right = null;
      } else {
        //자식이 양쪽 다 있는 경우
        if (tree.left != null && tree.right != null) {
          BSTNode minNode = searchMinNode(tree.right);
          minNode = removeNode(tree, null, minNode.data);

          tree.data = minNode.data;
        } else {
          //자식이 하나만 있는 경우
          BSTNode tmp = null;
          if (tree.left != null)
            tmp = tree.left;
          else tmp = tree.right;

          if (parent.left == tree)
            parent.left = tmp;
          else parent.right = tmp;
        }
      }
    }
    return removed;
  }

  public void inoderPrintTree(final BSTNode node) {
    if (node == null)
      return;

    inoderPrintTree(node.left);

    System.out.print(node.data + " ");

    inoderPrintTree(node.right);
  }
}
