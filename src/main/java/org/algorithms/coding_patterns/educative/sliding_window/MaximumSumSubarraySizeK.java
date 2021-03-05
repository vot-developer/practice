package org.algorithms.coding_patterns.educative.sliding_window;

/*
Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 */
public class MaximumSumSubarraySizeK {

    //time - O(n), space - O(1)
    public static int findMaxSumSubArray(int[] nums, int k) {
        int max = 0;

        for (int start = 0, end = 0, sum = 0; end < nums.length; end++) {
            sum += nums[end];
            if (end >= k - 1){
                max = Math.max(sum, max);
                sum -= nums[start];
                start++;
            }
        }
        return max;
    }
}
