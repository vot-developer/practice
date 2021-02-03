package org.algorithms.coding_patterns.educative.two_pointers;

import java.util.Arrays;

/*
Given an array of unsorted numbers and a target number, find a triplet in the array
whose sum is as close to the target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 */
public class TripletSumCloseToTarget {
    //time - O(n^2), space - O(1)
    public static int searchTriplet(int[] arr, int targetSum) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int diff = targetSum - arr[i] - arr[l] - arr[r];

                if (Math.abs(diff) < Math.abs(min))
                    min = diff;

                if (diff > 0)
                    l++;
                else if (diff < 0)
                    r--;
                else
                    return targetSum;
            }

        }

        return targetSum - min;
    }
}
