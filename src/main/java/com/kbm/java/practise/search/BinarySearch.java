package com.kbm.java.practise.search;


/**
 * Binary Search implementation.
 *
 * @author Keyur Mahajan
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 100, 200};

        int index = binarySearch(array, 205);
        System.out.println("Index is  = " + index);
    }

    private static int binarySearch(int[] input, int data) {
        int min = 0;
        int max = input.length;
        int index = 0;
        while (min < max) {
            index = (min + max) / 2;
            if (input[index] == data) {
                return index;
            }
            if (input[index] > data) {
                max = index;
            } else {
                min = index + 1;
            }
        }
        return -1;

    }
}
