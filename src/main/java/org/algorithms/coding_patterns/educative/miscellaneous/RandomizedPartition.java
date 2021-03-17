package org.algorithms.coding_patterns.educative.miscellaneous;

import java.util.Random;

public class RandomizedPartition {
    //time worst - O(n*n), expected - O(n), space - O(n) (recursion stack)
    public static int findKthSmallestNumber(int[] nums, int k) {
        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
    }

    private static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {
        int p = partition(nums, start, end);

        if (p == k - 1)
            return nums[p];

        if (p > k - 1) // search lower part
            return findKthSmallestNumberRec(nums, k, start, p - 1);

        // search higher part
        return findKthSmallestNumberRec(nums, k, p + 1, end);
    }

    private static int partition(int[] nums, int low, int high) {
        if (low == high)
            return low;

        Random randomNum = new Random();
        int pivotIndex = low + randomNum.nextInt(high - low);
        swap(nums, pivotIndex, high);

        int pivot = nums[high];
        for (int i = low; i < high; i++) {
            // all elements less than 'pivot' will be before the index 'low'
            if (nums[i] < pivot)
                swap(nums, low++, i);
        }
        // put the pivot in its correct place
        swap(nums, low, high);
        return low;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
