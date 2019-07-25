package io.wisoft.seminar.programmers.practice.lv1.stringtoint;

public class Solution {

  private static int solution(final String s) {
    return Integer.parseInt(s);
  }

  public static void main(String[] args) {
    String s = "-1234";
    System.out.println(solution(s));
  }

}
