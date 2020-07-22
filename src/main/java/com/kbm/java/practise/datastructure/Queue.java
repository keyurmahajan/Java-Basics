package com.kbm.java.practise.datastructure;


/**
 * Queue using Circular Array. This can be easily achieved by Linked list
 *
 * @author Keyur Mahajan
 */
public class Queue {

    private int[] queue;
    private int front;
    private int back;

    public Queue(int capacity) {
        queue = new int[capacity];
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.print();

        System.out.println("Deleted = " + queue.remove());
        System.out.println("Deleted = " + queue.remove());
        System.out.println("Deleted = " + queue.remove());
        System.out.println("Deleted = " + queue.remove());
        System.out.println("Deleted = " + queue.remove());
        queue.print();

        queue.add(1);
        queue.add(2);
        queue.print();
        System.out.println("Deleted = " + queue.remove());
        queue.add(3);
        queue.print();
        System.out.println("Deleted = " + queue.remove());
        queue.add(4);
        queue.print();
        System.out.println("Deleted = " + queue.remove());
        queue.add(5);
        queue.print();
        System.out.println("Deleted = " + queue.remove());
        queue.add(6);
        queue.print();
        System.out.println("Deleted = " + queue.remove());
        queue.print();
    }

    public void add(int data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Queue is Full");
        }

        if (back == queue.length && front > 0) {
            back = 0;
        }
        queue[back++] = data;
    }

    public int remove() throws IllegalAccessException {
        if (isEmpty()) {
            // TODO : check
            throw new IllegalAccessException("Queue is empty");
        }

        if (front == queue.length && back > 0) {
            front = 0;
        }
        int data = queue[front];
        queue[front] = 0;
        front++;
        if (isEmpty()) {
            front = 0;
            back = 0;
        }

        return data;
    }

    public int peek() throws Exception {
        if (!isFull()) {
            throw new Exception("Cant peek as Queue is Empty");
        }
        return queue[front];
    }

    public int size() {
        if (back >= front) {
            return back - front;
        } else {
            return queue.length - (front - back);
        }

    }

    public boolean isFull() {
        return size() == queue.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is Empty. Nothing to print");
            return;
        }
        if (back >= front) {

            for (int i = front; back > i; i++) {
                System.out.print(queue[i] + "<-");
            }

        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.print(queue[i] + "<-");
            }
            for (int i = 0; i < back; i++) {
                System.out.print(queue[i] + "<-");
            }

        }
        System.out.println();
    }


}
