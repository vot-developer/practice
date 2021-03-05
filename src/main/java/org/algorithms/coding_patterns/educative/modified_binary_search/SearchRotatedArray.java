package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given an array of numbers which is sorted in ascending order and also rotated by some arbitrary number, find if a given 'key' is present in it.

Write a function to return the index of the 'key' in the rotated array. If the 'key' is not present, return -1.
You can assume that the given array does not have any duplicates.
 */
public class SearchRotatedArray {
    //time - O(log n), space - O(1)
    public static int search(int[] arr, int key) {
        int maxIndex = findMax(arr);
        int keyIndex = binarySearch(arr, key, 0, maxIndex);
        if (keyIndex != -1)
            return keyIndex;
        return binarySearch(arr, key, maxIndex + 1, arr.length - 1);
    }

    private static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1] || arr[mid] < arr[start])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid])
                return mid;

            if (key < arr[mid])
                end = mid - 1;
            else  // key > arr[mid]
                start = mid + 1;
        }
        return -1;
    }
}
