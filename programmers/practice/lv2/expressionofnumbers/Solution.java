package io.wisoft.seminar.programmers.practice.lv2.expressionofnumbers;

public class Solution {

  private static int solution(final int n) {
    int answer = 1;
    int sum = 0;
    for (int i = 1; i <= (n / 2) + 1; i++) {
      for (int j = i; j <= (n / 2) + 1; j++) {
        sum += j;
        if (n == sum) {
          answer++;
          break;
        } else if (n < sum) break;
      }
      sum = 0;
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(15));
  }

}
