package io.wisoft.seminar.datastructure.linkedlist.polynomialcalc;

class Node {

  public int coef;
  public int degree;
  Node next = null;

  Node() {
  }

  public Node(final int coef, final int degree) {
    this.coef = coef;
    this.degree = degree;
  }

}
