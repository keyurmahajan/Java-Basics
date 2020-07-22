package com.kbm.java.practise.sort;

/**
 * Bubble sort
 * -> Iterate over an array till unsorted index
 * -> compare current and next/prev and bubble up the max/min element at sorted index
 *
 * @author Keyur Mahajan
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {50, 20, 5, 60, 15, 8, 55, 66, 78, 99};
        print(array);

        // small -> large
        bubleSort(array);

        print(array);

    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    private static void bubleSort(int[] array) {
        // iterate whole array
        for (int i = 0; i < array.length; i++) {

            // iterate end to ith location and do swap
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

            }
        }
    }
}
