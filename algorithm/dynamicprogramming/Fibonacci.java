package io.wisoft.seminar.lecture.algorithm.dp;

public class Fibonacci {

  private static int[] f = new int[10];

  private static int fiboRecursion(final int n) {
    if (n == 1 || n == 2) return 1;
    else return fiboRecursion(n - 1) + fiboRecursion(n - 2);
  }

  private static int fiboDP(final int n) {
    f[0] = 1;
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }

  private static int fiboMemo(final int n) {
    if (f[n] != 0) return f[n];
    else {
      if (n == 1 || n == 2)
        f[n] = 1;
      else f[n] = fiboMemo(n - 1) + fiboMemo(n - 2);
    }
    return f[n];
  }

  public static void main(String[] args) {
    System.out.print("Recursion : ");
    for (int i = 1; i <= 10; i++)
      System.out.print(fiboRecursion(i) + " ");
    System.out.println();

    System.out.print("DP1 : ");
    for (int i = 0; i < 10; i++)
      System.out.print(fiboDP(i) + " ");
    System.out.println();

    System.out.print("Memo : ");
    for (int i = 0; i < 10; i++)
      System.out.print(fiboMemo(i) + " ");
    System.out.println();
  }

}
