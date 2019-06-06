package io.wisoft.seminar.thisisjava.streamparallelprocessing.stream_type;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {

  public static void main(String[] args) {
    String[] strArray = {"홍길동", "신용권", "김미나"};
    Stream<String> strStream = Arrays.stream(strArray);
    strStream.forEach( s-> System.out.print(s + ",") );
    System.out.println();

    int[] intArray = {1, 2, 3, 4, 5};
    IntStream intStream = Arrays.stream(intArray);
    intStream.forEach( a -> System.out.print(a + ",") );
    System.out.println();
  }

}
