package io.wisoft.seminar.datastructure.linkedlist.polynomialcalc;

public class Polynomial {

  private int currentCount = 0;
  private final Node headerNode;

  public Polynomial() {
    this.headerNode = new Node();
  }

  private void insertNode(final int coef, final int degree) {
    Node newNode = new Node(coef, degree);
    Node preNode = this.headerNode;

    for (int i = 0; i < this.currentCount; i++)
      preNode = preNode.next;

    newNode.next = preNode.next;
    preNode.next = newNode;
    this.currentCount++;
  }

  public void insertExp(String exp) {
    exp = exp.replaceAll("[^0-9]{2}", " ")
        .replaceAll("[(+)]", " +")
        .replaceAll("(-)", " -");
    String[] list = exp.split(" ");
    for (int i = list[0].equals("") ? 1 : 0; i < list.length; i += 2) {
      try {
        insertNode(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1]));
      } catch (ArrayIndexOutOfBoundsException e) {
        insertNode(Integer.parseInt(list[i]), 0);
      }
    }
  }

  public void print() {
    for (Node pNode = this.headerNode.next; pNode != null; pNode = pNode.next) {
      if (pNode.degree == 0) {
        System.out.format("%+d", pNode.coef);
      } else {
        System.out.format("%+dx^%d ", pNode.coef, pNode.degree);
      }
    } System.out.println();
  }

  public Polynomial calc(final Polynomial anotherPolynomial, final int optional) {
    Polynomial resultList = new Polynomial();
    Node aList = this.headerNode.next;
    Node bList = anotherPolynomial.headerNode.next;
    int result;
    while (aList != null && bList != null) {
      if (aList.degree > bList.degree) {              // A의 차수가 더 높은 경우
        resultList.insertNode(aList.coef, aList.degree);
        aList = aList.next;
      } else if (aList.degree < bList.degree) {       // B의 차수가 더 높은 경우
        resultList.insertNode(bList.coef, bList.degree);
        bList = bList.next;
      } else {                                // A, B의 차수가 같은 경우
        result = (optional == 1) ? aList.coef + bList.coef : aList.coef - bList.coef;
        if (result == 0) {
          aList = aList.next;
          bList = bList.next;
        } else {
          resultList.insertNode(result, aList.degree);
          aList = aList.next;
          bList = bList.next;
        }
      }
    }
    for (; aList != null; aList = aList.next) resultList.insertNode(aList.coef, aList.degree);
    for (; bList != null; bList = bList.next) resultList.insertNode(bList.coef, bList.degree);

    return resultList;
  }

}

