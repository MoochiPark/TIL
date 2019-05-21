package io.wisoft.seminar.datastructure.recursion;

public class HanoiTower {

  private static void hanoiTower(final int n, final char from, final char temp, final char to) {
    if (n == 1)
      System.out.println("원판 1을 " + from + "에서 " + to + "로 옮겼습니다.@");
    else {
      hanoiTower(n - 1, from, to, temp);
      System.out.println("원판 " + n + "을 " + from + "에서 " + to + "로 옮겼습니다.");
      hanoiTower(n - 1, temp, from, to);
    }
  }

  public static void main(String[] args) {
    char from = 'A';
    char temp = 'B';
    char to = 'C';

    hanoiTower(4, from, temp, to);
  }

}
