package com.kbm.java.practise.datastructure;

/**
 * Doubly Linked List implementation
 *
 * @author Keyur Mahajan
 */
public class LinkedList<T extends Comparable> {

    private Node<T> head;
    private Node<T> tail;
    private int sizePointer;

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.print();

        System.out.println("Add First");
        linkedList.addAtFirst(0);
        linkedList.print();

        System.out.println("Add Last");
        linkedList.addAtLast(50);
        linkedList.print();

        System.out.println("Reversing the linked list");
        linkedList.reverse();
        linkedList.print();

        System.out.println("Remove First");
        linkedList.removeFirst();
        linkedList.print();

        System.out.println("Remove Last");
        linkedList.removeLast();
        linkedList.print();

        System.out.println("Reversing the linked list");
        linkedList.reverse();
        linkedList.print();

        System.out.println("Creating New Linked list for insert sort test");
        LinkedList<Integer> linkedListSorted = new LinkedList<Integer>();
        linkedListSorted.insertSorted(300);
        linkedListSorted.insertSorted(20);
        linkedListSorted.insertSorted(-2);
        linkedListSorted.insertSorted(10);
        linkedListSorted.insertSorted(5);
        linkedListSorted.insertSorted(50);
        linkedListSorted.print();
    }

    public void addAtFirst(T data) {
        Node<T> incomingNode = new Node<T>(data);
        if (head == null) {
            tail = incomingNode;
        } else {
            incomingNode.setNext(head);
            head.setPrevious(incomingNode);
        }
        head = incomingNode;
        sizePointer++;
    }

    public void addAtLast(T data) {
        Node<T> incomingNode = new Node<T>(data);
        if (tail == null) {
            head = incomingNode;
        } else {
            incomingNode.setPrevious(tail);
            tail.setNext(incomingNode);
        }
        tail = incomingNode;
        sizePointer++;
    }

    public Node<T> add(T data) {
        Node incomingNode = new Node(data);
        sizePointer++;
        if (isEmpty()) {
            head = incomingNode;
            tail = incomingNode;
            return incomingNode;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(incomingNode);
        incomingNode.setPrevious(current);
        tail = incomingNode;

        return incomingNode;
    }

    public Node<T> removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = head;

        if (size() == 1) {
            head = null;
            tail = null;
            return removedNode;
        }

        head = head.getNext();
        head.setPrevious(null);

        sizePointer--;
        return removedNode;
    }

    public Node<T> removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = tail;

        if (size() == 1) {
            head = null;
            tail = null;
            return removedNode;
        }

        tail = tail.getPrevious();
        tail.setNext(null);

        sizePointer--;
        return removedNode;
    }

    public Node<T> reverse() {
        if (isEmpty() || size() == 1) {
            return head;
        }

        Node currentNode = head;
        Node previousNode = null;
        int counter = 0;
        while (currentNode != null) {
            Node nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            currentNode.setPrevious(nextNode);
            if (counter == 0) {
                tail = currentNode;
            }
            previousNode = currentNode;
            currentNode = nextNode;
            counter++;
        }

        head = previousNode;
        return head;
    }

    public Node<T> insertSorted(T data) {
        Node<T> incomingNode = new Node(data);

        // first element or less than root then add at front
        if (isEmpty() || data.compareTo(head.getData()) < 0) {
            addAtFirst(data);
        }
        // if greater than tail then add at last
        else if (data.compareTo(tail.getData()) > 0) {
            addAtLast(data);
        }
        // compare each node until we find node to swap
        else {
            Node current = head;
            Node nodeToSwap = null;
            while (current != null) {
                if (data.compareTo(current.getData()) <= 0) {
                    nodeToSwap = current;
                    break;
                }
                current = current.getNext();
            }

            if (nodeToSwap != null) {
                Node prev = nodeToSwap.getPrevious();
                prev.setNext(incomingNode);
                incomingNode.setPrevious(prev);
                incomingNode.setNext(nodeToSwap);
            }
        }

        return head;

    }

    public int size() {
        return sizePointer - 1;
    }

    public boolean isEmpty() {
        return !((sizePointer - 1) > 0);
    }

    public Node<T> getHead() {
        return head;
    }

    public void print() {
        System.out.print("null->");
        if (head != null) {
            Node current = head;
            while (current != null) {
                System.out.print(current + "->");
                current = current.getNext();
            }
            System.out.print("null");
        }
        System.out.println();
    }

    public class Node<T> {

        private Node next;
        private Node previous;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }


    }

}
