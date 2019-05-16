package io.wisoft.seminar.programmers;

public class StringToInt {
  private static int solution(final String s) {

    return Integer.parseInt(s);
  }

  public static void main(String[] args) {
    String s = "-1234";
    System.out.println(solution(s));
  }
}
