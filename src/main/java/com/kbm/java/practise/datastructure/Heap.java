package com.kbm.java.practise.datastructure;

/**
 * Heap Implementation
 *
 * @author Keyur Mahajan
 */
public class Heap {

    private int[] heap;
    private int sizePointer;

    public Heap(int size) {
        heap = new int[size];
    }


    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.insert(5);
        heap.insert(9);
        heap.insert(8);
        heap.insert(2);
        heap.insert(7);

        heap.insert(0);
        heap.insert(-100);

        heap.printHeap();

        heap.delete(-100);
        heap.printHeap();

    }

    public int[] getData() {
        return this.heap;
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int size() {
        return this.sizePointer;
    }

    public boolean isFull() {
        return heap.length == this.sizePointer;
    }

    /**
     * Add element at last and do heapify above
     *
     * @param data
     */
    public void insert(int data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[sizePointer++] = data;

        heapifyAbove(sizePointer - 1);

    }

    /**
     * -> Loop till if parent having larger data
     * -> if data is larger then swap parent data with current index
     * -> increment the index till we reach root i.e. 0
     *
     * @param index
     */
    private void heapifyAbove(int index) {
        int data = heap[index];
        int indexPointer = index;
        while (indexPointer > 0 && heap[getParentIndex(indexPointer)] > data) {
            int parentIndex = getParentIndex(indexPointer);
            heap[indexPointer] = heap[parentIndex];
            heap[parentIndex] = data;
            indexPointer = parentIndex;
        }
    }

    /**
     * -> For removing we need to take last element( right most element of heap ) and put it in element index
     * -> after adding last element heap is property is not preserved so we need to maintain the heap
     * -> check if parent relation is not ok, then heapifyAbove or else heapifyBelow
     *
     * @param data
     */
    public void delete(int data) {
        if (isEmpty() == true) {
            return;
        }
        // find index of data
        int index = 0;
        for (int i = 0; i < size(); i++) {
            if (heap[i] == data) {
                index = i;
                break;
            }
        }
        // replace data index with last level right most value
        heap[index] = heap[sizePointer - 1];

        sizePointer--;
        // check if parent having larger data then heapify above or else check below
        if (index > 0 && heap[getParentIndex(index)] > data) {
            heapifyAbove(index);
        } else {
            heapifyBelow(index);
        }


    }

    public boolean isEmpty() {
        return sizePointer == 0;
    }

    public void printHeap() {
        for (int i = 0; i < sizePointer; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    /**
     * --> run a loop till end of the heap
     * -> swap the data between min/max of chile element ( either right or left )
     * -> do this until you reach last element.
     *
     * @param index
     */
    private void heapifyBelow(int index) {
        int data = heap[index];
        int pointerIndex = index;

        // loop until we hit end of heap
        while (pointerIndex < sizePointer) {

            // get both child pointerIndex to replace min of both
            int leftChildIndex = getLeftChildIndex(pointerIndex);
            int rightChildIndex = getRightChildIndex(pointerIndex);
            int childIndexToSwap = pointerIndex;

            // check if left child exist
            if (leftChildIndex < sizePointer) {
                // check if right child exist, if yes means it has two child
                // we can check first left and right as this is heap property
                if (rightChildIndex < sizePointer) {
                    childIndexToSwap = heap[leftChildIndex] > heap[rightChildIndex] ? rightChildIndex : leftChildIndex;
                }
                // this means only left child exist
                else {
                    childIndexToSwap = leftChildIndex;
                }

            } else {
                // this means no child exists
                return;
            }

            // swap values only if data is greater then child
            if (heap[childIndexToSwap] < data) {
                int temp = heap[childIndexToSwap];
                heap[childIndexToSwap] = heap[pointerIndex];
                heap[pointerIndex] = temp;
            }

            pointerIndex = childIndexToSwap;

        }

    }

    public int pop() {
        int root = heap[0];
        delete(root);
        return root;
    }


}
