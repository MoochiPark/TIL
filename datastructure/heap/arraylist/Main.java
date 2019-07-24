package io.wisoft.seminar.datastructure.heap.arraylist;

public class Main {

  public static void main(String[] args) {
    Heap heap = new Heap(10);

    heap.insert(10);
    heap.insert(23);
    heap.insert(3);
    heap.insert(4);
    heap.insert(9);
    heap.insert(6);
    heap.insert(7);

    heap.print();

    System.out.println();
    System.out.println("d"+heap.delete());
    System.out.println("d" +heap.delete());
    System.out.println("d" +heap.delete());
    System.out.println("d" +heap.delete());
    System.out.println("d" +heap.delete());
    System.out.println("d" +heap.delete());
    System.out.println("d" +heap.delete());

    heap.print();
  }

}
