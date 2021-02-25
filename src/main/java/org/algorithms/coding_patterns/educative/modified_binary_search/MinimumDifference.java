package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
 */
public class MinimumDifference {
    //time - O(log n), space - O(1)
    public static int searchMinDiffElement(int[] arr, int key) {
        if (key < arr[0])
            return arr[0];
        if (key > arr[arr.length - 1])
            return arr[arr.length - 1];

        int start = 0, end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > key)
                end = mid - 1;
            else if (arr[mid] < key)
                start = mid + 1;
            else
                return arr[mid];
        }

        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];
    }
}
