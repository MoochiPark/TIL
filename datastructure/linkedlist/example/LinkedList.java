package io.wisoft.seminar.datastructure.linkedlist.example;

public class LinkedList {

  private int currentCount = 0;
  private final Node headerNode;

  public LinkedList() {
    this.headerNode = new Node();
  }

  public <T> T getData(final int position) {
    Node<T> currentNode = this.headerNode;
    for (int i = 0; i <= position; i++)
      currentNode = currentNode.next;
    return currentNode.data;
  }

  public <T> void insert(final int position, final T data) {
    Node<T> newNode = new Node<>(data);
    Node preNode = this.headerNode;

    for (int i = 0; i < position; i++)
      preNode = preNode.next;

    newNode.next = preNode.next;
    preNode.next = newNode;
    this.currentCount++;
  }

  public void remove(final int position) {
    Node preNode = this.headerNode;
    for (int i = 0; i < position; i++)
      preNode = preNode.next;

    Node delNode = preNode.next;
    preNode.next = delNode.next;
    this.currentCount--;
  }

  public void print() {
    Node pNode = this.headerNode.next;
    for (int i = 0; i < this.currentCount; i++) {
      System.out.print("[" + i + "]:");
      System.out.println(pNode.data);
      pNode = pNode.next;
    }
    System.out.println("노드 수 : " + this.currentCount);
  }

}

