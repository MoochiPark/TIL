package io.wisoft.seminar.programmers.practice.lv1.findprimenumber;

public class Solution {
  public int solution(int n) {
    int answer = 0;

    for(int i = 2; i <= n; i++) {
      int cnt = 0;
      for (int j = 2; j <= (int)Math.sqrt(i); j++) {
        if (i % j == 0) { cnt++; break;}
      }
      if(cnt == 0) answer++;
    }
    return answer;
  }
}