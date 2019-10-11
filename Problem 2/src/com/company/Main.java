package com.company;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.printTree();
    }
}
