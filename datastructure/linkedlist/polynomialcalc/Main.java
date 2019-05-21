package io.wisoft.seminar.datastructure.linkedlist.polynomialcalc;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Polynomial polyA = new Polynomial();
    Polynomial polyB = new Polynomial();
    Polynomial polyC;

    System.out.print("다항식 A를 입력 > ");
    String exp1 = scanner.next();
    polyA.insertExp(exp1);
    System.out.print("다항식 B를 입력 > ");
    String exp2 = scanner.next();
    polyB.insertExp(exp2);

    polyC = polyA.add(polyB);
    System.out.print("다항식 A + B = ");
    polyC.display();
  }
}


