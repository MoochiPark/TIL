package io.wisoft.seminar.programmers.practice.lv1.stringbasic;

public class Solution {
  public boolean solution(String s) {
    boolean answer = true;

    if(s.length() == 4 || s.length() == 6) {
      try {
        Integer.parseInt(s);
      } catch (NumberFormatException e) {
        answer = false;
      }
    } else answer = false;
    return answer;
  }
}