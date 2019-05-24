package io.wisoft.seminar.student;

import java.util.List;

public interface StudentService {

  int insertStudent(final Student student);

  int insertStudentList(final List<Student> studentList);

  int insertStudentListBatch(final List<Student> studentList);

  List<Student> getStudentAll();

  List<Student> getStudentListByNo(final List<String> studentNoList);

}
