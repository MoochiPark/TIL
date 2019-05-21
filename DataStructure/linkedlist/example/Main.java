package io.wisoft.seminar.datastructure.linkedlist.example;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    int[] arr = {1, 2, 3};

    linkedList.insert(0, 123);
    linkedList.insert(1, "String");
    linkedList.insert(2, 0.123);
    linkedList.insert(3, arr);
    linkedList.insert(4, false);
    linkedList.insert(1, 'A');
    linkedList.display();

    System.out.println("\n==Get pos 1==");
    System.out.println("[1]:" + linkedList.getData(1));

    System.out.println("\n==Remove pos 1==");
    linkedList.remove(1);
    linkedList.display();

    System.out.println("\n==Remove pos 0==");
    linkedList.remove(0);
    linkedList.display();
  }

}
