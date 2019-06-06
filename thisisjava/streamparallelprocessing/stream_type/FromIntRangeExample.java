package io.wisoft.seminar.thisisjava.streamparallelprocessing.stream_type;

public class FromIntRangeExample {

  public static int sum;

  public static void main(String[] args) {
//    IntStream stream = IntStream.rangeClosed(1, 100);
//    stream.forEach( a -> sum += a );
//    System.out.println("총합: " + sum);

    for (int i = 1; i <= 100; i++ ) {
      sum += i;
    }
    System.out.println("총합: " + sum);
  }

}
