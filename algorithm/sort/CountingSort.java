package io.wisoft.seminar.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

  private static void countingSort(final int n) {
    int[] A = new int[n];
    int[] B = new int[n];
    int i = 0;

    for (i = 0; i < n; i++)
      A[i] = (int) (Math.random() * 100);

    int aMax = Arrays.stream(A)
        .max()
        .getAsInt();
    int[] count = new int[aMax];

    for (i = 0; i < n; i++)
      count[A[i]]++;

    for (i = aMax - 1; i >= 0; i-- )      //    for (i = 1; i < aMax + 1; i++)
      count[i] += count[i+1];             //      count[i] += count[i - 1];

    for (i = A.length - 1; i >= 0; i--)
        B[--count[A[i]]] = A[i];

    System.out.print("정렬 전 : ");
    Arrays.stream(A)
        .forEach(a -> System.out.print(a + ", "));
    System.out.println();

    System.out.print("정렬 후 : ");
    Arrays.stream(B)
        .forEach(b -> System.out.print(b + ", "));
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("배열의 길이를 입력 : ");
    int n = scanner.nextInt();
    countingSort(n);

  }

}


