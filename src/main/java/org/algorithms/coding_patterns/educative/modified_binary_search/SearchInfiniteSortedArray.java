package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given an infinite sorted array (or an array with unknown size), find if a given number 'key' is present in the array.
Write a function to return the index of the 'key' if it is present in the array, otherwise return -1.

Since it is not possible to define an array with infinite (unknown) size, you will be provided with
an interface ArrayReader to read elements of the array. ArrayReader.get(index) will return the number at index;
if the array's size is smaller than the index, it will return Integer.MAX_VALUE.
 */
public class SearchInfiniteSortedArray {
    //time - O(log n), space - O(1)
    public static int search(ArrayReader reader, int key) {
        int start = 0, end = 1;
        while (reader.get(end) < key) { //find border
            int newStart = end + 1;
            end += (end - start + 1) * 2;
            start = newStart;
        }

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (key < reader.get(mid))
                end = mid - 1;
            else if (key > reader.get(mid))
                start = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}
