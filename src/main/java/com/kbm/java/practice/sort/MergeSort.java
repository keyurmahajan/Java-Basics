package com.kbm.java.practice.sort;

import java.util.Arrays;

/**
 * Merge Sort
 * -> Divide the array till minimum level i.e. until single element
 * -> start merging this part to gether such that merged array become sorted
 * -> Keep combining and sorting the sub array till whole array is constructed back
 *
 * @author Keyur Mahajan
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {50, 20, 5, 60, 15, 99, 8, 55, 66, 78};
        print(array);

        // small -> large
        mergeSort(array, 0, array.length - 1);

        print(array);

    }

    private static void mergeSort(int[] array, int startIndex, int endIndex) {
        // end condition
        if (startIndex < endIndex) {

            // find mid point
            int midPoint = (startIndex + endIndex) / 2;

            // keep dividing left sub array
            mergeSort(array, startIndex, midPoint);

            // keep dividing right sub array
            mergeSort(array, midPoint + 1, endIndex);


            // merge two sets of sorted array
            merge(array, startIndex, midPoint, endIndex);


        }
    }

    private static void merge(int[] array, int startIndex, int midPoint, int endIndex) {
        System.out.println("Merging array = " + Arrays.toString(Arrays.copyOfRange(array, startIndex, endIndex + 1)) + ", startIndex = " + startIndex + ", endIndex = " + endIndex);

        // temp array to put element
        int[] tempArray = new int[endIndex - startIndex + 1];

        int i = startIndex;
        int j = midPoint + 1;
        int k = 0;

        // iterate from two pointers, 1 from start to mid and 2 from mid to end
        while (i <= midPoint && j <= endIndex) {
            if (array[i] < array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }

        // just to make sure we complete iteration for first array from while loop
        while (i <= midPoint) {
            tempArray[k++] = array[i++];
        }

        // just to make sure we complete iteration for second array from while loop
        while (j <= endIndex) {
            tempArray[k++] = array[j++];
        }

        int z = 0;
        // copy sorted elements in original array
        for (int l = startIndex; l <= endIndex; l++) {
            array[l] = tempArray[z++];

        }

        System.out.println("After Merge array = " + Arrays.toString(tempArray) + ", startIndex = " + startIndex + ", endIndex = " + endIndex);
        System.out.println();

    }


    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }
}
