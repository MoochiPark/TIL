package io.wisoft.seminar.lecture;

import java.util.Arrays;

public class InsertionSort {

  private static int[] insertSort(int[] arr) {
    int key, i, j;
    int length = arr.length;
    for (i = 1; i < length; i++) {
      System.out.println(Arrays.toString(arr));
      key = arr[i];
      System.out.println(key);
      for (j = i - 1; j >= 0 && arr[j] > key; j--) {
        arr[j + 1] = arr[j];
      }
      arr[j + 1] = key;
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {12, 70, 30, 20, 55, 25, 40, 50};
    int[] sortedArr;

    System.out.println("삽입 정렬 전 : " + Arrays.toString(arr));
    sortedArr = insertSort(arr);
    System.out.println("삽입 정렬 후 : " + Arrays.toString(sortedArr));
  }

}
