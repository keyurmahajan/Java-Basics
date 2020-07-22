package com.kbm.java.practice.sort;

/**
 * Selection Sort. Select min/max from unsorted array
 * -> search for min/max element and swap it from first element
 * -> search remaining unsorted array part and find min/max element and swap with 2nd element
 * -> do it for n element
 *
 * @author Keyur Mahajan
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {50, 20, 5, 60, 15, 8, 55, 66, 78, 99};
        print(array);

        selectionSort(array);

        print(array);

    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    private static void selectionSort(int[] array) {
        int minIndex = 0;

        // iterate whole array
        for (int i = 0; i < array.length; i++) {
            // maintain min Index as Ith
            minIndex = i;
            // iterate from end to i and find minimum index
            for (int j = array.length - 1; j >= i; j--) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // swap i th location with selected min index
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

    }
}
