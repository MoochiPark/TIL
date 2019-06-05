package io.wisoft.seminar.thisisjava.referencetype.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise09 {

  public static void main(String[] args) {
    int[] scores = null;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
      System.out.print("선택 > ");

      int selectNo = scanner.nextInt();

      switch (selectNo) {
        case 1:
          System.out.print("학생수 > ");
          scores = new int[scanner.nextInt()];
          break;
        case 2:
          for (int i = 0; i < scores.length; i++) {
            System.out.print("scores[" + i + "] > ");
            scores[i] = scanner.nextInt();
          }
          break;
        case 3:
//          for(int i = 0; i < scores.length; i++)
//            System.out.println("scores[" + i + "]: " + scores[i]);

          Arrays.stream(scores).forEach(s -> System.out.println("scores[ ]: " + s));
          break;
        case 4:
          int max = Arrays.stream(scores).max().getAsInt();
          System.out.println("최고 점수: " + max);
          double avg = Arrays.stream(scores).average().getAsDouble();
          System.out.println("평균 점수: " + avg);
          break;
        case 5:
          return;
      }
    }
  }

}
