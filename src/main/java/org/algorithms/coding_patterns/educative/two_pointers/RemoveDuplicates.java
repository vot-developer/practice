package org.algorithms.coding_patterns.educative.two_pointers;

/*
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 */
public class RemoveDuplicates {
    //time - O(n), space - O(1)
    public static int remove(int[] arr) {
        int k = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[k - 1] != arr[i])
                arr[k++] = arr[i];
        return k;
    }

    //time - O(n), space - O(1)
    public static int removeKey(int[] arr, int key) {
        int k = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != key)
                arr[k++] = arr[i];
        return k;
    }
}
