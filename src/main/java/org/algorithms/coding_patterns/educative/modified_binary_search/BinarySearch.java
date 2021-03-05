package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given a sorted array of numbers, find if a given number 'key' is present in the array.
Though we know that the array is sorted, we don't know if it's sorted in ascending or descending order.
You should assume that the array can have duplicates.

Write a function to return the index of the 'key' if it is present in the array, otherwise return -1.
 */
public class BinarySearch {
    //time - O(log n), space - O(1)
    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            if (start == end){
                if (arr[start] == key)
                    return start;
                else
                    return -1;
            }

            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;
            if (isAsc){
                if (arr[mid] < key)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (arr[mid] > key)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }
}
