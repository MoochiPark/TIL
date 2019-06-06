package io.wisoft.seminar.thisisjava.collectionframework.set;

public class Members {

  public String name;
  public int age;

  public Members(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Members) {
      Members members = (Members) obj;
      return members.name.equals(name) && (members.age == age);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return name.hashCode() + age;
  }

}
