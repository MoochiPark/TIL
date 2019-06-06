package io.wisoft.seminar.thisisjava.generic.generic_method;

import io.wisoft.seminar.thisisjava.generic.generic_example.Box;

public class Util {

  public static <T> Box<T> boxing(T t) {
    Box<T> box = new Box<>();
    box.setObject(t);
    return box;
  }

}
