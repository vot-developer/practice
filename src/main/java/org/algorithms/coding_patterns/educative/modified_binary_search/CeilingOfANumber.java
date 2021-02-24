package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.

Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
 */
public class CeilingOfANumber {
    //time - O(log n), space - O(1)
    public static int searchCeilingOfANumber(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        if (key > arr[end])
            return -1;

        while (start <= end) {
            if (start == end)
                return start;

            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                end = mid; //! mid without '-1' - that could be ceil
            else
                start = mid + 1;
        }

        return start;
    }
}
