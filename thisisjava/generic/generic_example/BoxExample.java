package io.wisoft.seminar.thisisjava.generic.generic_example;

public class BoxExample {

  public static void main(String[] args) {
//    Box<String> box = new Box();
//    box.setObject("홍길동");                     // String -> Object (자동 타입 변환)
//    String name = (String) box.getObject();      // Object -> String (강제 타입 변환)
//
//    box.setObject(new Apple());                  // Apple -> Object (자동 타입 변환)
//    Apple apple = (Apple) box.getObject();       // Object -> Apple (강제 타입 변환)

    Box<String> box = new Box<>();
    box.setObject("hello");
    String str = box.getObject();
    System.out.println(str);

    Box<Integer> box2 = new Box<>();
    box2.setObject(6);
    int value = box2.getObject();
    System.out.println(value);
  }

}
