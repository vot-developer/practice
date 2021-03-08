package org.algorithms.coding_patterns.educative.sliding_window;

/*
Given an array of positive numbers and a positive number 'S,' find the length of the smallest contiguous subarray
whose sum is greater than or equal to 'S'. Return 0 if no such subarray exists.
 */
public class MinSizeSubArraySum {

    //time - O(n), space - O(1)
    public static int findMinSubArray(int S, int[] arr) {
        int min = Integer.MAX_VALUE;
        int sum = 0, start = 0, end = 0;
        while (end < arr.length) {
            sum += arr[end++];
            while (sum >= S) {
                min = Math.min(end - start, min);
                sum -= arr[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
