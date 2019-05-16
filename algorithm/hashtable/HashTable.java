package io.wisoft.seminar.lecture.algorithm.hashtable;

public class HashTable {

  private final int tableSize;
  private final Node[] table;

  public HashTable(final int tableSize) {
    this.tableSize = tableSize;
    this.table = new Node[tableSize];
  }

  void set(final int key, final int value) {
    int address = hash(key, tableSize);
    Node node = new Node();
    node.key = key;
    node.value = value;
    table[address] = node;
  }

  int get(final int key) {
    int address = hash(key, tableSize);

    return this.table[address].value;
  }

  private int hash(final int key, final int tableSize) {
    return key % tableSize;
  }

}


