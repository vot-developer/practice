package org.algorithms.coding_patterns.educative.miscellaneous;

public class BruteForce {
    //time - O(N*K), space - O(1)
    public static int findKthSmallestNumber(int[] nums, int k) {
        int previousSmallestNum = Integer.MIN_VALUE;
        int previousSmallestIndex = -1;
        int currentSmallestNum = Integer.MAX_VALUE;
        int currentSmallestIndex = -1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > previousSmallestNum && nums[j] < currentSmallestNum) {
                    // found the next smallest number
                    currentSmallestNum = nums[j];
                    currentSmallestIndex = j;
                } else if (nums[j] == previousSmallestNum && j > previousSmallestIndex) {
                    // found a number which is equal to the previous smallest number; since numbers can repeat,
                    // we will consider 'nums[j]' only if it has a different index than previous smallest
                    currentSmallestNum = nums[j];
                    currentSmallestIndex = j;
                    break; // break here as we have found our definitive next smallest number
                }
            }
            // current smallest number becomes previous smallest number for the next iteration
            previousSmallestNum = currentSmallestNum;
            previousSmallestIndex = currentSmallestIndex;
            currentSmallestNum = Integer.MAX_VALUE;
        }

        return previousSmallestNum;
    }
}
