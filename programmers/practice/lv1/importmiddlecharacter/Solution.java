package io.wisoft.seminar.programmers.practice.lv1.importmiddlecharacter;

class Solution {
  public String solution(String s) {
    String answer = "";
    int h = s.length() / 2;
    if (s.length() % 2 == 0) {
      answer = s.substring(h-1, h+1);
    }
    else answer = s.substring(h,h+1);
    return answer;
  }
}