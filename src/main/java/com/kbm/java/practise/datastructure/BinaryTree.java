package com.kbm.java.practise.datastructure;

import java.util.TreeSet;

/**
 * Binary Tree Implementation
 *
 * @author Keyur Mahajan
 */
public class BinaryTree {

    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(20);
        treeSet.add(70);
        treeSet.add(25);
        System.out.println(treeSet.last());

        MyBinaryTree<Integer> tree = new MyBinaryTree<Integer>();
        tree.insert(10);

        tree.insert(5);
        tree.insert(20);
        tree.insert(5);
        tree.insert(70);
        tree.insert(25);
        tree.insert(7);
        System.out.println();

        System.out.println("traverseInOrdered");
        tree.traverseInOrdered();
        System.out.println();

        System.out.println("\ntraversePreOrdered");
        tree.traversePreOrdered();
        System.out.println();

        System.out.println("\ntraversePostOrdered");
        tree.traversePostOrdered();
        System.out.println();

        System.out.println("\nget Value=" + tree.getNode(20));
        System.out.println("\nMin Value=" + tree.getMinValue());
        System.out.println("\nMax Value=" + tree.getMaxValue());

        System.out.println("\ntraverseInOrdered");
        tree.traverseInOrdered();
        System.out.println("Deleting a Node 10");
        tree.remove(10);
        tree.traverseInOrdered();

    }

    private static class MyBinaryTree<T extends Comparable> {
        private Node<T> head;

        public void insert(T data) {
            if (head == null) {
                head = new Node<T>(data);
            } else {
                this.head.insert(data);
            }
        }

        public void traverseInOrdered() {
            if (head != null) {
                head.traverseInOrdered();
            }
        }


        public void traversePreOrdered() {
            if (head != null) {
                head.traversePreOrdered();
            }
        }

        public void traversePostOrdered() {
            if (head != null) {
                head.traversePostOrdered();
            }
        }

        public Node<T> getNode(T data) {
            if (head != null) {
                return head.getNode(data);
            }
            return null;
        }


        public T getMinValue() {
            if (head != null) {
                return head.getMinValue();
            }
            return null;
        }

        public T getMaxValue() {
            if (head != null) {
                return head.getMaxValue();
            }
            return null;
        }

        public void remove(T data) {
            head = remove(head, data);
        }

        /**
         * Remove the element from the tree and return the replacement node
         * <p>
         * -> Logic is as follow
         * -> for a node to be deleted replace its value as min from right subtree
         * -> after replacing that, remove that min element from right sub tree
         *
         * @param subTreeRoot - root of subtree
         * @param data        - data to be deleted from the tree
         * @return - Element replaced at deleted location
         */
        private Node<T> remove(Node<T> subTreeRoot, T data) {
            // if null then return null
            if (subTreeRoot == null) {
                return null;
            }

            int result = data.compareTo(subTreeRoot.getData());
            if (result > 0) {
                // remove node from right subtree
                Node<T> replacedNode = remove(subTreeRoot.getRight(), data);
                // set replaced node as right element
                subTreeRoot.setRight(replacedNode);
            } else if (result < 0) {
                // set left node as it is if subtree do not match the data or it will go down the tree until match found
                subTreeRoot.setLeft(remove(subTreeRoot.getLeft(), data));
            } else {
                // if we found data match in tree

                // Scenario - 1, 2 where node to be deleted having 0 or 1 children

                // Scenario - 1, 2  if right is null then only 1 or 0 children so select left or null
                if (subTreeRoot.getRight() == null) {
                    return subTreeRoot.getLeft();
                }

                // Scenario - 1, 2 if right is null then only 1 or 0 children so select left or null
                if (subTreeRoot.getLeft() == null) {
                    return subTreeRoot.getRight();
                }

                //Scenario - 3 , delete node with two children,

                // replace min from right subtree
                subTreeRoot.setData(subTreeRoot.getRight().getMinValue());

                // delete the node having min value
                subTreeRoot.setRight(remove(subTreeRoot.getRight(), subTreeRoot.getData()));

            }

            return subTreeRoot;
        }
    }

    private static class Node<T extends Comparable> {
        private Node<T> right;
        private Node<T> left;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public void insert(T data) {
            int result = data.compareTo(this.data);
            if (result > 0) {
                if (right != null) {
                    right.insert(data);
                } else {
                    right = new Node<T>(data);
                    System.out.println("Creating Right Node(" + data + ") from " + this.data);
                }
            } else if (result < 0) {
                if (left != null) {
                    left.insert(data);
                } else {
                    left = new Node<T>(data);
                    System.out.println("Creating Left Node(" + data + ") from " + this.data);
                }
            } else {
                System.out.println("Same data not allowed");
            }
        }

        public T getData() {
            return data;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setData(T data) {
            this.data = data;
        }


        public void traverseInOrdered() {
            if (left != null) {
                left.traverseInOrdered();
            }
            System.out.print(this.data + ",");
            if (right != null) {
                right.traverseInOrdered();
            }
        }

        public void traversePreOrdered() {
            System.out.print(this.data + ",");
            if (left != null) {
                left.traversePreOrdered();
            }
            if (right != null) {
                right.traversePreOrdered();
            }
        }

        public void traversePostOrdered() {
            if (left != null) {
                left.traversePostOrdered();
            }
            if (right != null) {
                right.traversePostOrdered();
            }
            System.out.print(this.data + ",");
        }

        public Node<T> getNode(T data) {
            int result = data.compareTo(this.data);
            if (result > 0) {
                if (right != null) {
                    return right.getNode(data);
                }
            } else if (result < 0) {
                if (left != null) {
                    return left.getNode(data);
                }
            } else {
                return this;
            }

            return null;
        }

        public T getMinValue() {
            if (left != null) {
                return left.getMinValue();
            }
            return this.data;
        }

        public T getMaxValue() {
            if (right != null) {
                return right.getMaxValue();
            }
            return this.data;
        }

        @Override
        public String toString() {
            return "Node{" + this.data + "}";
        }

    }


}
