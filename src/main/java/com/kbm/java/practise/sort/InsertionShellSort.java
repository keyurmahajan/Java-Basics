package com.kbm.java.practise.sort;

import java.util.Arrays;

/**
 * Insertion Shell sort
 * -> This is similar implementation like Insertion sort with gap value more than 1
 * -> As in insertion sort we compare near element, it require large shifting to come small number lying at end of array
 * -> to overcome above shot coming of insertion sort, Shell sort compare values with some gap value and then do comparison and shift
 * -> this leads to faster sorting then Insertion sort
 *
 * @author Keyur Mahajan
 */
public class InsertionShellSort {

    public static void main(String[] args) {
        int[] array = {50, 20, 66, 99, 60, 8, 55, 5, 78, 15};
        print(array);

        int gapValue = array.length / 2;

        while (gapValue >= 1) {
            shellSort(array, gapValue);
            print(array);
            gapValue = gapValue / 2;
        }

    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    private static void shellSort(int[] array, int gapValue) {
        System.out.println("array = " + Arrays.toString(array) + ", gapValue = " + gapValue);

        for (int i = gapValue; i < array.length; i++) {
            int newValue = array[i];
            int j;
            for (j = i; j >= gapValue && array[j - gapValue] > newValue; j = j - gapValue) {
                if (array[j - gapValue] > array[j]) {
                    array[j] = array[j - gapValue];
                }
            }
            array[j] = newValue;

        }


    }
}
