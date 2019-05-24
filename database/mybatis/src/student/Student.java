package io.wisoft.seminar.student;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.StringJoiner;

public class Student {

  private String no;
  private String name;
  private String birthday;

  public Student() {
  }

  public Student(String no, String name, String birthday) {
    this.no = no;
    this.name = name;
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("no", no)
        .append("name", name)
        .append("birthday", birthday)
        .toString();
  }

}
