package com.kbm.java.practise.datastructure;

/**
 * Stack implementation using array
 *
 * @author Keyur Mahajan
 */
public class StackUsingArray<T> {

    private T[] array;
    private int sizePointer;

    public StackUsingArray(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }

    public static void main(String[] args) {
        StackUsingArray<String> stack = new StackUsingArray<String>(2);
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

        // if array full then do resize of array
        if (array.length == sizePointer) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[sizePointer++] = data;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }

        T data = array[sizePointer - 1];
        array[sizePointer - 1] = null;
        sizePointer--;
        return data;
    }

    public T peek() {
        return array[sizePointer - 1];

    }

    public int size() {
        return sizePointer;
    }

    public boolean isEmpty() {
        return sizePointer == 0;
    }

    public void print() {
        for (int i = 0; i < sizePointer; i++) {
            System.out.print(array[i] + "->");
        }

        System.out.println();
    }
}
