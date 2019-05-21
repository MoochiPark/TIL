package io.wisoft.seminar.datastructure.linkedlist.polynomialcalc;

class Polynomial {

  private int currentCount = 0;
  private Node headerNode;

  public Polynomial() {
    this.headerNode = new Node();
  }

  private void insertNode(final int coef, final int degree) {
    Node newNode = new Node(coef, degree);
    Node preNode = headerNode;

    for (int i = 0; i < currentCount; i++)
      preNode = preNode.next;

    newNode.next = preNode.next;
    preNode.next = newNode;
    currentCount++;
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

  public void display() {
    for (Node pNode = headerNode.next; pNode != null; pNode = pNode.next) {
      if (pNode.degree == 0) {
        System.out.format("%+d", pNode.coef);
      } else {
        System.out.format("%+dx^%d", pNode.coef, pNode.degree);
      }
    }
    System.out.println();
  }

  public Polynomial add(Polynomial anotherPolynomial) {
    Polynomial result = new Polynomial();
    Node a = headerNode.next;
    Node b = anotherPolynomial.headerNode.next;

    while (a != null && b != null) {
      if (a.degree > b.degree) {              // A의 차수가 더 높은 경우
        result.insertNode(a.coef, a.degree);
        a = a.next;
      } else if (a.degree < b.degree) {       // B의 차수가 더 높은 경우
        result.insertNode(b.coef, b.degree);
        b = b.next;
      } else {                                // A, B의 차수가 같은 경우
        int sum = a.coef + b.coef;
        if (sum == 0) {                       // 계수의 합이 0일 때
          a = a.next;
          b = b.next;
        } else {
          result.insertNode(sum, a.degree);
          a = a.next;
          b = b.next;
        }
      }
    }
    for (; a != null; a = a.next) result.insertNode(a.coef, a.degree);
    for (; b != null; b = b.next) result.insertNode(b.coef, b.degree);

    return result;
  }

}

