package io.wisoft.seminar.lecture.algorithm.hashtable;

public class Main {

  public static void main(String[] args) {
    HashTable hashTable = new HashTable(193);

    hashTable.set(418, 32114);
    hashTable.set(9, 514);
    hashTable.set(27, 8917);
    hashTable.set(1031, 286);

    System.out.println("Key : 418, Value : " + hashTable.get(418));
    System.out.println("Key : 9, Value : " + hashTable.get(9));
    System.out.println("Key : 27, Value : " + hashTable.get(27));
    System.out.println("Key : 1031, Value : " + hashTable.get(1031));

  }

}


