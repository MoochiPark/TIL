package io.wisoft.seminar.programmers.practice.lv2.correctbracket;

import java.util.Stack;

public class Solution {

  private static boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push('(');
      } else {
        try {
          stack.pop();
        } catch (Exception e) {
          return false;
        }
      }
    }
    return stack.size() == 0;
  }

}


