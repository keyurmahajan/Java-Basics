package com.kbm.java.practise.datastructure;

/**
 * Stack implementation using array
 * 
 * @author keyur.mahajan
 *
 */
public class MyStack<T> {
	private Object[] myArray;
	private int index = 0;
	private int stackSize;

	/**
	 * Creates new Stack object with given size
	 * 
	 * @param size
	 */
	public MyStack(int size) {
		stackSize = size;
		myArray = new Object[size];
	}

	/**
	 * Insert new element to stack.
	 * 
	 * @param i
	 */
	public void push(T i) {
		if (isFull()) {
			throw new IllegalAccessError("Stack is full");
		}
		myArray[index] = i;
		index++;
	}

	/**
	 * Removes top element of stack
	 * 
	 * @return
	 */
	public T pop() {
		if (isEmpty()) {
			throw new IllegalAccessError("Stack is full");
		}
		return (T) myArray[--index];
	}

	/**
	 * Reset the stack entry
	 */
	public void reset() {
		for (int i = myArray.length - 1; i >= 0; i--) {
			myArray[i] = 0;
		}
		index = 0;
	}

	public boolean isEmpty(){
		return index <= 0 ? true : false;
	}

	public boolean isFull() {
		return index >= stackSize ? true : false;
	}

	public static void main(String[] args) {
		int size = 10;
		MyStack<Integer> stack = new MyStack(size);
		for (int i = 0; i < size; i++) {
			stack.push(i);
		}

		System.out.println("Stack is Full:" + stack.isFull());

		for (int i = 0; i < size; i++) {
			System.out.println(stack.pop());
		}

		System.out.println("Stack is Empty:" + stack.isEmpty());

	}
}
