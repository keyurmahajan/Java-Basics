package com.kbm.java.practise.datastructure;

/**
 * Represents Node of a Binary Tree data structure
 *
 * @author Keyur Mahajan
 */
public class TreeNode<T extends Comparable<T>> {

    private T data;
    private TreeNode<T> rightChild;
    private TreeNode<T> leftChild;

    public TreeNode(T data) {
        this.data = data;
    }

    /**
     * insert data in Binary Tree
     *
     * @param dt - data
     * @return true - if inserted or else false
     */
    public boolean insert(T dt) {
        if (dt != null) {
            int compare = dt.compareTo(data);
            if (compare == 0) {
                throw new IllegalStateException("Data " + dt + " already present in the tree");
            } else if (compare == 1) {
                if (rightChild == null) {
                    rightChild = new TreeNode<T>(dt);
                } else {
                    rightChild.insert(dt);
                }
            } else {
                if (leftChild == null) {
                    leftChild = new TreeNode<T>(dt);
                } else {
                    leftChild.insert(dt);
                }

            }
            return true;
        }
        return false;
    }

    /**
     * Used to traverse Binary tree in InOrder sequence
     */
    public void traverseInOrder() {
        // left, root, right
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + " ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    /**
     * Returns data of a node
     *
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * sets data for a give node
     *
     * @param data - data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns right child
     *
     * @return - right child
     */
    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * sets right child
     *
     * @param rightChild
     */
    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Returns left child
     *
     * @return
     */
    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Sets left child
     *
     * @param leftChild
     */
    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }
}
