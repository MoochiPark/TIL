package io.wisoft.seminar.thisisjava.generic.generic_method;

import io.wisoft.seminar.thisisjava.generic.generic_example.Box;

public class BoxingMethodExample {

  public static void main(String[] args) {
    Box<Integer> box1 = Util.<Integer>boxing(100);    //명시적 타입 지정
    int intValue = box1.getObject();

    Box<String> box2 = Util.boxing("홍길동");        //타입 파라미터를 String으로 추정
    String strValue = box2.getObject();

    System.out.println(intValue + ", " + strValue);
  }

}
