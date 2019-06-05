package io.wisoft.seminar.lecture.algorithm.dp;

import java.util.Scanner;

public class MatMul {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] m = new int[501][501];
    int[] d = new int[1001];

    for (int i = 0; i < n; i++) {
      d[i] = sc.nextInt();
      d[i + 1] = sc.nextInt();
    }

    for (int len = 2; len <= n; len++) {
      for (int i = 1; i <= n - len + 1; i++) {
        int j = i + len - 1;
        m[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          int cost = m[i][k] + m[k + 1][j] + d[i - 1] * d[k] * d[j];
          m[i][j] = Math.min(m[i][j], cost);
        }
      }
    }
    System.out.println("최소 곱셈 수 = " + m[1][n]);
  }

}
