package org.algorithms.coding_patterns.educative.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
public class TripletSumToZero {

    //time - O(n^2), space - O(1)
    public static List<List<Integer>> searchTriplets(int[] arr) {
        if (arr.length < 3) return new ArrayList<>();
        Arrays.sort(arr);
        List<List<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    solutions.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1])
                        left++; // skip same element to avoid duplicate triplets
                    while (left < right && arr[right] == arr[right + 1])
                        right--; // skip same element to avoid duplicate triplets
                }
            }
        }
        return solutions;
    }
}
