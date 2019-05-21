package io.wisoft.seminar.datastructure.arraylist;

public class ArrayList {

  private int currentCount;
  private final int maxCount;
  private final Node[] list;

  public ArrayList() {
    this.maxCount = 10;
    this.list = new Node[maxCount];
  }

  public ArrayList(final int maxCount) {
    this.maxCount = maxCount;
    this.list = new Node[maxCount];
  }

  void addData(final int pos, final int data) {
    Node node = new Node(data);
    for (int i = currentCount-1; i >= pos ; i--)
      list[i+1] = list[i];

    list[pos] = node;
    currentCount++;
  }

  void removeData(final int pos) {
    for (int i = pos; i < currentCount-1 ; i++)
      list[i] = list[i+1];
    currentCount--;
    list[currentCount] = null;
  }
  void deleteList() {
    for (int i = 0; i < currentCount; i++)
      list[i] = null;
    currentCount = 0;
  }

  void printData() {
    for (int i = 0; i < currentCount; i++)
      System.out.println(list[i].data);

    if (currentCount == 0)
      System.out.println("공백 리스트입니다.");
  }

}
