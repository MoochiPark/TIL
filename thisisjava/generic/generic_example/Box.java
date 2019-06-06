package io.wisoft.seminar.thisisjava.generic.generic_example;

public class Box<T> {

  private T t;

  public void setObject(T t) {
    this.t = t;
  }

  public T getObject() {
    return t;
  }
}
