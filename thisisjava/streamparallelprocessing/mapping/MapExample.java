package io.wisoft.seminar.thisisjava.streamparallelprocessing.mapping;

import io.wisoft.seminar.thisisjava.streamparallelprocessing.lambda_expressions.Student;

import java.util.Arrays;
import java.util.List;

public class MapExample {

  public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
        new Student("홍길동", 10),
        new Student("신용권", 20),
        new Student("유미선", 30)
    );

//    double avg = studentList.stream()
//        .mapToInt(Student::getScore)
//        .average()
//        .getAsDouble();
//
//    System.out.println(avg);

    studentList.stream()
        .mapToInt(Student::getScore)
        .forEach(System.out::println);
    System.out.println("======");

    studentList.stream()
        .forEach(s -> System.out.println(s.getScore()));
    System.out.println("======");

  }

}
