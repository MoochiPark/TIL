package io.wisoft.seminar.programmers;
import java.util.Arrays;

public class Tower {

  private static int[] solution(int[] heights) {
    int[] answer = new int[heights.length];
    for (int i = 1; i < heights.length; i++)
      for (int j = i; j > 0; j--)
        if (heights[i] < heights[j - 1]) {
          answer[i] = j;
          break;
        }
    return answer;
  }

  public static void main(String[] args) {
    int[] arr = {6, 9, 5, 7, 4};
    System.out.println(Arrays.toString(solution(arr)));
  }

}
