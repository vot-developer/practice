package org.algorithms.coding_patterns.educative.miscellaneous;

import java.util.Arrays;

public class BruteForceSorting {
    //time - O(n * log n), space - O(1)
    public static int findKthSmallestNumber(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }
}
