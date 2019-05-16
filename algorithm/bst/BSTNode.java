package io.wisoft.seminar.lecture.algorithm.bst;

public class BSTNode {

  char data;
  BSTNode left;
  BSTNode right;

  BSTNode() {
    this.left = null;
    this.right = null;
  }

  BSTNode(final char data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public char getData() {
    return data;
  }

}
