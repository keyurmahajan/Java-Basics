package com.kbm.java.practise.sort;


import com.kbm.java.practise.datastructure.Heap;

/**
 * Heap Sort uses Heap data structure
 * -> Create Heap from given array elements
 * -> Once heap properties are restored, then root will be min/max element
 * -> remove root and heapify the heap until heap is empty
 *
 * @author Keyur Mahajan
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {51, 22, 36, 63, 14, 87, 44, 63, 72, 996};
        print(array);

        // small -> large
        Heap heap = new Heap(array.length);
        for (int i = 0; i < array.length; i++) {
            heap.insert(array[i]);
        }

        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = heap.pop();
        }

        print(temp);

    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }
}
