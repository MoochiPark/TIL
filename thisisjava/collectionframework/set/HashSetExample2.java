package io.wisoft.seminar.thisisjava.collectionframework.set;

import java.util.*;

public class HashSetExample2 {

  public static void main(String[] args) {
    Set<Members> set = new HashSet<>();

    set.add(new Members("홍길동", 30));
    set.add(new Members("홍길동", 30));

    System.out.println("총 객체수: " + set.size());
  }

}
