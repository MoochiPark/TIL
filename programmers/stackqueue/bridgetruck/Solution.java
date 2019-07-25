package io.wisoft.seminar.programmers.bridgetruck;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private static int solution(final int bridgeLength, final int weight, final int[] truckWeights) {
    int answer = 0;
    Queue<Integer> wait = new LinkedList<>();
    Queue<Integer> passing = new LinkedList<>();
    Queue<Integer> pass = new LinkedList<>();
    Queue<Integer> time = new LinkedList<>();
    int currentTruckWeight = 0;
    int totalWeight = 0;

    for (int truckWeight : truckWeights)
      wait.add(truckWeight);

    while (pass.size() != truckWeights.length) {
      currentTruckWeight = wait.isEmpty() ? 0 : wait.peek();
      if (wait.size() != truckWeights.length &&
          time.peek() + bridgeLength == answer) {
        pass.add(passing.peek());
        time.remove();
        totalWeight -= passing.poll();
      }
      if (totalWeight + currentTruckWeight <= weight) {
        passing.add(wait.peek());
        time.add(answer);
        if (!wait.isEmpty())
          totalWeight += wait.poll();
      }
      answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
  }

}
