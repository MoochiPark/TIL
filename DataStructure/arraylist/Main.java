package io.wisoft.seminar.datastructure.arraylist;

public class Main {

  public static void main(String[] args) {
    ArrayList arrayList = new ArrayList(10);
    arrayList.addData(0, 10);
    arrayList.addData(1, 20);
    arrayList.addData(1, 30);
    arrayList.addData(2, 40);

    arrayList.printData();
    System.out.println();
    arrayList.removeData(1);
    arrayList.printData();

    System.out.println();
    arrayList.deleteList();
    arrayList.printData();
  }

}
