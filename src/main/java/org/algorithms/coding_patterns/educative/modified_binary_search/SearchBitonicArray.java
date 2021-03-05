package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given a Bitonic array, find if a given 'key' is present in it.
An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Write a function to return the index of the 'key'. If the 'key' is not present, return -1.
 */
public class SearchBitonicArray {
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

            if (arr[start] < arr[end]) { // ascending order
                if (key < arr[mid])
                    end = mid - 1;
                else  // key > arr[mid]
                    start = mid + 1;

            } else { // descending order
                if (key > arr[mid])
                    end = mid - 1;
                else  // key < arr[mid]
                    start = mid + 1;
            }
        }
        return -1;
    }
}
