package io.wisoft.seminar.programmers.ramenfactory;

public class Solution {

  public int solution(int stock, int[] dates, int[] supplies, int k) {
    int answer = 0;
    int n = 0;
    Heap heap = new Heap(10000);

    while (stock < k) {
      for (int i = n; i < dates.length; i++) {
        if (dates[i] <= stock) {
          heap.insert((supplies[i]));
          supplies[i] = 0;
        } else {
          n = i;
          break;
        }
      }
      stock += heap.delete();
      answer++;
    }
    return answer;
  }

  class Heap {
    private final int[] heap;
    private final int maxCount;
    private int currentCount;

    public Heap() {
      this.maxCount = 20;
      this.heap = new int[maxCount];
    }

    public Heap(int maxCount) {
      this.maxCount = maxCount;
      this.heap = new int[maxCount];
    }

    public void insert(int data) {
      if (this.currentCount == this.maxCount) {
        System.out.println("오류, 힙이 가득 찼습니다.");
        return;
      }
      this.currentCount++;
      int i = this.currentCount;
      while ((i != 1) && data > this.heap[i / 2]) {
        this.heap[i] = this.heap[i / 2];
        i /= 2;
      }
      heap[i] = data;
    }

    public int delete() {
      int returnData = 0;
      int temp = 0;
      int parent = 1, child = 2;

      if (currentCount > 0) {
        returnData = this.heap[1];

        temp = this.heap[currentCount];
        currentCount--;

        while (child <= currentCount) {
          if (child < currentCount && this.heap[child] < this.heap[child + 1]) child++;

          if (temp >= this.heap[child]) break;

          this.heap[parent] = this.heap[child];
          parent = child;
          child *= 2;
        }
        this.heap[parent] = temp;
      }
      return returnData;
    }
  }


}
