package com.kbm.java.practise.datastructure;

/**
 * Stack implementation using Linked List
 *
 * @author Keyur Mahajan
 */
public class Stack<T extends Comparable> {

    private LinkedList<T> linkedList;

    public Stack(){
        linkedList = new LinkedList<T>();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("p0");
        stack.push("p1");
        stack.push("p2");
        stack.push("p3");

        stack.print();

        String pop = stack.pop();
        System.out.println("pop = " + pop);
        stack.print();

        String peek = stack.peek();
        System.out.println("peek = " + peek);


    }

    public void push(T data) {
        linkedList.addAtFirst(data);
    }

    public T pop() {
        return linkedList.removeFirst().getData();
    }

    public T peek() {
        return linkedList.getHead().getData();
    }

    public void print(){
        linkedList.print();
    }

}
