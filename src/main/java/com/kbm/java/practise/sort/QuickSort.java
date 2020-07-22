package com.kbm.java.practise.sort;

/**
 * Quick Sort
 * -> This sorting algorithm works on partition logic with reference to pivot element
 * -> [less than pivot element] [pivot element] [greater than pivot element]
 * -> select middle or start element as pivot element
 * -> two pointer from start and end shift towards center
 * -> left pointer shift till it is less then pivot or else exchange with right pointer
 * -> right pointer shifts left till it is grater then pivot or else exchange with left pointer
 * <p>
 * -> after initial partition do partition on left side and again on right side recursively
 *
 * @author Keyur Mahajan
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {50, 20, 5, 60, 15, 8, 55, 66, 78, 99};
        print(array);

        quickSort(array, 0, array.length - 1);

        print(array);

    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);
            System.out.println("Pivot Index = " + pivotIndex);

            quickSort(array, startIndex, pivotIndex);
            quickSort(array, pivotIndex + 1, endIndex);
        }

    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        // select pivot element
        int pivot = array[startIndex];

        int i = startIndex;
        int j = endIndex;
        while (i < j) {
            while (array[i] <= pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[j];
        array[j] = pivot;
        array[startIndex] = temp;

        return j;
    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }

        System.out.println();
    }
}
