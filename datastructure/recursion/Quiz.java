package io.wisoft.seminar.datastructure.recursion;

public class Quiz {

  public static void main(String[] args) {
  quiz(10);
  }

  private static void quiz(int n) {
    if (n == 0) return;
    quiz(n-1);
    System.out.println(n);
  }
}
