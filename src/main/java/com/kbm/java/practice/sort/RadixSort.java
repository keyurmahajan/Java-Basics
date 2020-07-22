package com.kbm.java.practice.sort;

import java.util.*;

/**
 * Radix Sort uses logic of Counting sort
 * -> Sort array using decimal place 0 digits using selection sort
 * -> Sort array using decimal place 1 digits using selection sort
 * -> do it until maximum width if max number in array
 *
 * @author Keyur Mahajan
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {51, 22, 36, 63, 14, 87, 44, 63, 72, 996};
        print(array);

        // small -> large
        print(radixSort(array, 3, 10));

        Arrays.sort(array);

    }

    /**
     * @param array - input array
     * @param width - width of max no in array
     * @param radix - radix of given element in array. ( e.g. for number - 0-9 and for character 0-23 or 25 )
     * @return - Sorted Array
     */
    private static int[] radixSort(int[] array, int width, int radix) {

        // do sorting for each decimal places for given width.
        for (int i = 0; i < width; i++) {
            radixSortForPosition(array, i, radix);
        }

        return array;
    }

    private static void radixSortForPosition(int[] array, int position, int radix) {
        List<LinkedList> buckets = new ArrayList<LinkedList>(radix);
        for (int i = 0; i < radix; i++) {
            buckets.add(new LinkedList());
        }

        for (int j = 0; j < array.length; j++) {
            int value = array[j];
            int bucketLoc = getDigit(value, position);
            if (buckets.get(bucketLoc).size() != 0) {
                buckets.get(bucketLoc).add(value);
            } else {
                LinkedList list = new LinkedList();
                list.add(value);
                buckets.add(bucketLoc, list);
            }
        }

        int k = 0;
        for (int j = 0; j < buckets.size(); j++) {
            LinkedList linkedList = buckets.get(j);
            if (linkedList != null) {
                for (Iterator iterator = linkedList.iterator(); iterator.hasNext(); ) {
                    int next = (Integer) iterator.next();
                    array[k++] = next;
                }
            }
        }
    }


    private static int getDigit(int number, int position) {
        int num = number;
        while (position != 0) {
            num = num / 10;
            position--;
        }

        return num % 10;
    }


    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }
}
