package io.wisoft.seminar.thisisjava.lambda.constructor_references;

public class Members {

  private String name;
  private String id;

  public Members() {
    System.out.println("Members() 실행");
  }

  public Members(String id) {
    System.out.println("Members(String id) 실행");
    this.id = id;
  }

  public Members(String name, String id) {
    System.out.println("Members(String name, String id)");
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }
}
