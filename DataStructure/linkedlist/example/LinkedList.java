package io.wisoft.seminar.datastructure.linkedlist.example;

public class LinkedList {

  private int currentCount = 0;
  private Node headerNode;

  public LinkedList() {
    this.headerNode = new Node();
  }

  public <T> T getData(final int position) {
    Node<T> currentNode = headerNode;
    for (int i = 0; i <= position; i++)
      currentNode = currentNode.next;

    return currentNode.data;
  }

  public <T> void insert(final int position, final T data) {
    Node<T> newNode = new Node<>(data);
    Node preNode = headerNode;

    for (int i = 0; i < position; i++)
      preNode = preNode.next;

    newNode.next = preNode.next;
    preNode.next = newNode;
    currentCount++;
  }

  public void remove(final int position) {
    Node preNode = headerNode;
    for (int i = 0; i < position; i++)
      preNode = preNode.next;

    Node delNode = preNode.next;
    preNode.next = delNode.next;
    currentCount--;
  }

  public void display() {
    Node pNode = headerNode.next;
    for (int i = 0; i < currentCount; i++) {
      System.out.print("[" + i + "]:");
      System.out.println(pNode.data);
      pNode = pNode.next;
    }
    System.out.println("노드 수 : " + currentCount);
  }

}

