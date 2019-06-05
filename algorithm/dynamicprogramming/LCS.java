package io.wisoft.seminar.lecture.algorithm.dp;

import java.util.Scanner;

public class LCS {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Input Text A > ");
    String a = sc.nextLine();
    System.out.print("Input Text B > ");
    String b = sc.nextLine();

    int i = 0;
    int j = 0;

    int[][] lenArr = new int[a.length() + 1][b.length() + 1];
    for (i = 0; i < a.length() + 1; i++) {
      for (j = 0; j < b.length() + 1; j++) {
        if (i == 0 || j == 0) {
          lenArr[i][j] = 0;
        } else if (a.toCharArray()[i - 1] == b.toCharArray()[j - 1]) {
          lenArr[i][j] = lenArr[i - 1][j - 1] + 1;
        } else {
          lenArr[i][j] = Math.max(lenArr[i][j - 1], lenArr[i - 1][j]);
        }
      }
    }

    System.out.print("    ");
    for (i = 0; i < a.length(); i++)
      System.out.print(a.charAt(i) + " ");
    System.out.println();

    for (i = 0; i < b.length() + 1; i++) {
      if (i == 0)
        System.out.print("  ");
      else System.out.format("%-2c", b.charAt(i - 1));
      for (j = 0; j < a.length() + 1; j++) {
        System.out.print(lenArr[i][j] + " ");
      }
      System.out.println();
    }
    trace(a, b, a.length(), b.length(), lenArr, "");
    System.out.println(" (Length :" + lenArr[a.length()][b.length()] + ")");
  }

  static void trace(String a, String b, int m, int n, int[][] data, String lcs) {

    if (m == 0 || n == 0) {
      System.out.print("LCS : \"");
      for (int i = lcs.length() - 1; i >= 0; i--)
        System.out.print(lcs.charAt(i));
      System.out.print("\"");
      return;
    }

    if (data[m][n] > data[m - 1][n] && data[m][n] > data[m][n - 1]) {
      lcs = lcs + a.charAt(m - 1);
      trace(a, b, m - 1, n - 1, data, lcs);
    } else {
      if (data[m][n] == data[m][n - 1])
        trace(a, b, m, n - 1, data, lcs);
      else
        trace(a, b, m - 1, n, data, lcs);
    }
  }
}

