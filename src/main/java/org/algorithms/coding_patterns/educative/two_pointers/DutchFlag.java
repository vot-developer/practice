package org.algorithms.coding_patterns.educative.two_pointers;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place.
You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 */
public class DutchFlag {
    //pattern - two points, time - O(n), space - O(1)
    public static void sort(int[] arr) {
        int i = 0, l = 0, r = arr.length - 1;
        while (i <= r) {
            if (arr[i] == 0)
                swap(arr, i++, l++);
            else if (arr[i] == 1)
                i++;
            else
                swap(arr, i, r--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
