package io.wisoft.seminar.thisisjava.streamparallelprocessing.parallel_processing._processing;

import java.util.*;
import java.util.stream.Stream;

public class ParallelExample {

  public static void main(String[] args) {
    List<String> list = Arrays.asList(
        "홍길동", "신용권", "감자바",
        "람다식", "박병렬");

    //순차 처리
    Stream<String> stream = list.stream();
    stream.forEach(ParallelExample:: print);  // 메소드 참조. (s -> ParallelExample.printList(s)와 동일.)
    System.out.println();

    //병렬 처리
    Stream<String> paralleStream = list.parallelStream();
    paralleStream.forEach(ParallelExample:: print);
  }

  public static void print(String str) {
    System.out.println(str + " : " + Thread.currentThread().getName());
  }

}
