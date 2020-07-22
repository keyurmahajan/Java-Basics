package com.kbm.java.practice.sort;

/**
 * Counting sort
 * As name suggest its works on counting unique element present in input array
 * Input array element range should be in limit or else it will have large space complexity.
 * <p>
 * -> find max no and create count array of that size
 * -> Iterate over array and maintain count in count array
 * -> Now we will have count in count array for element present in the input
 * -> Iterate over count array and for element having count !=0 keep adding element in the array from start
 *
 * @author Keyur Mahajan
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] array = {5, 2, 3, 6, 100, 8, 4, 6, 7, 9};
        print(array);

        // small -> large
        print(CountingSort(array));

    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    private static int[] CountingSort(int[] array) {
        // find max no
        int maxNo = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNo) {
                maxNo = array[i];
            }
        }

        int[] count = new int[maxNo + 1];
        // maintain the count of each element
        for (int i = 0; i < array.length; i++) {
            count[array[i]] += 1;
        }

        int temp = 0;
        // put element in actual array based on the count and maintaining indices
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                int t1 = count[i];
                for (int j = temp; j < temp + t1; j++) {
                    array[j] = i;
                }
                temp += t1;
            }

        }

        return array;

    }
}
