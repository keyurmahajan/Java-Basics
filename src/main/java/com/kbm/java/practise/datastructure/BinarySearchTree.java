package com.kbm.java.practise.datastructure;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> head;

    public BinarySearchTree(T headData) {
        this.head = new TreeNode<T>(headData);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<Integer>(0);
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(20);
        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(8);
        binaryTree.insert(15);

        System.out.println(binaryTree);

        binaryTree.traverseInOrder();

    }

    public boolean insert(T data) {
        return head.insert(data);
    }

    public void traverseInOrder() {
        head.traverseInOrder();
    }


}
