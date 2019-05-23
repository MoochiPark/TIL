package io.wisoft.seminar.datastructure.linkedlist.polynomialcalc;

public class Node {

  public int coef;
  public int degree;
  Node next = null;

  public Node() {
  }

  public Node(final int coef, final int degree) {
    this.coef = coef;
    this.degree = degree;
  }

}
