package io.wisoft.seminar.programmers;

public class StringBasic {

  private static boolean solution(final String s) {
    boolean answer = true;

    if(s.length() == 4 || s.length() == 6) {
      try {
        Integer.parseInt(s);
      } catch (NumberFormatException e) {
        answer = false;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("String"));
  }

}
