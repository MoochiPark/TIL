package io.wisoft.seminar.lecture.algorithm.bst;

public class Test {

  public static void main(String[] args) {
    BST bst = new BST();
    BSTNode tree = new BSTNode();
    BSTNode node;

    bst.insertNode(tree, new BSTNode('D'));
    bst.insertNode(tree, new BSTNode('A'));
    bst.insertNode(tree, new BSTNode('E'));
    bst.insertNode(tree, new BSTNode('W'));
    bst.insertNode(tree, new BSTNode('O'));
    bst.insertNode(tree, new BSTNode('N'));

    bst.inoderPrintTree(tree);
    System.out.println();

    System.out.println("removing E...");
    node = bst.removeNode(tree, null, 'E');
    bst.destroyNode(node);
    bst.inoderPrintTree(tree);
    System.out.println();

    System.out.println("inserting K...");
    bst.insertNode(tree, new BSTNode('K'));
    bst.inoderPrintTree(tree);
    System.out.println();

    System.out.println("searching N...");
    System.out.println(bst.searchNode(tree, 'N').getData());


    bst.destroyTree(tree);
  }

}
