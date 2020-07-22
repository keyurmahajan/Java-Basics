package com.kbm.java.practice.sort;

/**
 * Insertion sort
 * -> Virtually divide array in sorted and unsorted parts
 * -> sorted part will start from index 1 and unsorted from 1 to end.
 * -> Insert element from unsorted array to sorted array such that order will be maintain
 *
 * @author Keyur Mahajan
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {50, 20, 5, 60, 15, 8, 55, 66, 78, 99};
        print(array);

        insertionSort(array);

        print(array);

    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    private static void insertionSort(int[] array) {

        for (int unsortedIndex = 1; unsortedIndex < array.length; unsortedIndex++) {
            int firstElement = array[unsortedIndex];
            int i;
            for (i = unsortedIndex; i > 0 && array[i - 1] > firstElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = firstElement;

        }
    }
}
