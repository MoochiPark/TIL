package io.wisoft.seminar.thisisjava.streamparallelprocessing.collect;

import java.util.Arrays;
import java.util.List;

public class MaleStudentExample {

  public static void main(String[] args) {
    List<Student> totalList = Arrays.asList(
        new Student("홍길동", 10, Student.Sex.MALE),
        new Student("김수애", 6, Student.Sex.FEMALE),
        new Student("신용권", 10, Student.Sex.MALE),
        new Student("수미칩", 6, Student.Sex.FEMALE)
    );

    MaleStudent maleStudent = totalList.stream()
        .filter(s -> s.getSex() == Student.Sex.MALE)
        .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

    maleStudent.getList().stream()
        .forEach(s -> System.out.println(s.getName()));
  }

}
