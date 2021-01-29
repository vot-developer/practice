package org.algorithms.coding_patterns.educative.sliding_window;

/*
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
find the length of the longest contiguous subarray having all 1s.
 */
public class ReplacingOnes {
    //time - O(n), space - O(1)
    public static int findLength(int[] arr, int k) {
        int maxLength = 0;
        int count = 0;
        for (int start = 0, end = 0; end < arr.length; end++){
            if (arr[end] == 1)
                count++;

            if (end - start + 1 - count > k){
                if (arr[start++] == 1)
                    count--;
            }
            maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;
    }
}
