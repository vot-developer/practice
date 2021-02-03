package org.algorithms.coding_patterns.educative.two_pointers;

import java.util.Arrays;

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
Write a function to return the count of such triplets.
 */
public class TripletWithSmallerSum {
    //time - O(n^2), space - O(1)
    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum < target) {
                    // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                    // left and right to get a sum less than the target sum
                    count+= r - l;
                    l++;
                } else
                    r--;
            }
        }
        return count;
    }
}
