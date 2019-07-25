package io.wisoft.seminar.programmers.practice.lv1.makingstrangecharacters;

public class Solution {
  public String solution(String s) {
    StringBuilder answer = new StringBuilder();
    int i = 0;
    String[] str = s.split("");
    for(String n : str){
      if (n.equals(" ")) {
        i = 0;
        answer.append(" ");
      }
      else if (i % 2 == 0) {
        answer.append(n.toUpperCase());
        i++;
      }else if (i % 2 == 1) {
        answer.append(n.toLowerCase());
        i++;
      }
    }
    return answer.toString();
  }
}
