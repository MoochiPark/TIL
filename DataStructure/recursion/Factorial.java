package io.wisoft.seminar.datastructure.recursion;

import org.apache.commons.lang3.time.StopWatch;

public class Factorial {

  private static int factorial(final int n) {
    if (n <= 1)
      return n;
    else
      return factorial(n - 1) * n;
  }

  private static int factorial_iter(final int n) {
    int ret = 1;
    for (int i = n; i > 1; i--) {
      ret = ret * i;
    }
    return ret;
  }

  public static void main(String[] args) {

    StopWatch sw = new StopWatch();
    int num = 4;
    sw.reset();
    sw.start();
    System.out.println("재귀 호출 사용 결과 : " + factorial(num));
    sw.stop();
    System.out.println("재귀 호출 시간 : " + sw.getNanoTime());

    sw.reset();
    sw.start();
    System.out.println("반복 호출 사용 결과 : " + factorial_iter(num));
    sw.stop();
    System.out.println("반복 호출 시간 : " + sw.getNanoTime());

  }

}
