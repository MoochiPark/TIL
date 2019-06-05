package io.wisoft.seminar.thisisjava.referencetype.exercise;

public class Exercise08 {

  public static void main(String[] args) {
    int[][] arrays = {
        {95, 86},
        {83, 92, 96},
        {78, 83, 93, 87, 88}
    };

    int sum = 0;
    double cnt = 0.0;
    double avg = 0.0;

    for (int[] array : arrays)
      for (int num : array) {
        sum += num;
        cnt++;
      }
    System.out.println(sum);
    System.out.println(sum/cnt);
  }

}
