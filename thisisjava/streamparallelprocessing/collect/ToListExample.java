package io.wisoft.seminar.thisisjava.streamparallelprocessing.collect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {

  public static void main(String[] args) {
    List<Student> totalList = Arrays.asList(
        new Student("홍길동", 10, Student.Sex.MALE),
        new Student("김수애", 6, Student.Sex.FEMALE),
        new Student("신용권", 10, Student.Sex.MALE),
        new Student("박수미", 6, Student.Sex.FEMALE)
    );

    //남학생들만 묶어 List 생성
    List<Student> maleList = totalList.stream()         //전체 학생 List에서 Stream을 얻는다.
        .filter(s -> s.getSex()==Student.Sex.MALE)      //남학생만 필터링해서 Stream을 얻는다.
        .collect(Collectors.toList());                  //collect 메소드로 Student를 수집해서 새로운 List를 얻는다.
    maleList.stream()
        .forEach(s -> System.out.println(s.getName()));

    System.out.println();

    //여학생들만 묶어 HashSet 생성
    Set<Student> femaleSet = totalList.stream()
        .filter(s -> s.getSex()==Student.Sex.FEMALE)
        .collect(Collectors.toCollection(HashSet::new));
    femaleSet.stream()
        .forEach(s -> System.out.println(s.getName()));
  }

}
