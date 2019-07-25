package io.wisoft.seminar.programmers.stockprice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private static int[] stocksPrice(int[] prices) {
    int[] answer = new int[prices.length];
    Queue<Integer> queue = new LinkedList<>();
    int i, j, p;

    for (int price : prices)
      queue.add(price);

    for (i = 0; i < prices.length; i++) {
      p = queue.poll();
      answer[i] = queue.size();
      j = 1;
      for (int q : queue) {
        if (p > q) {
          answer[i] = j;
          break;
        } j++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] prices = {2, 2, 3, 3, 2, 2, 3, 3, 4, 4, 2, 2};
    System.out.println(Arrays.toString(stocksPrice(prices)));
  }

}
