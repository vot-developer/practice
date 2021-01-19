package org.algorithms.dynamic.educative;

import java.util.Arrays;

/**
 * Given a set of positive numbers, find if we can partition it into two subsets such that
 * the sum of elements in both the subsets is equal.
 */
public class EqualSubsetSum {

    //NAIVE
    //time - O(2^n), space - O(n) (stack)
    public boolean naive(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0)
            return false;

        return doNaive(nums, 0, sum / 2);
    }

    private boolean doNaive(int[] nums, int index, int sum) {
        if (sum == 0)
            return true;

        if (index == nums.length)
            return false;

        if (nums[index] <= sum)
            if (doNaive(nums, index + 1, sum - nums[index])) //add something
                return true;

        return doNaive(nums, index + 1, sum); //add nothing
    }

    // TOP TO BOTTOM
    //time - O(n * S), space - O(n * S)
    public boolean topToDown(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0)
            return false;

        sum /= 2;
        Boolean[][] cache = new Boolean[nums.length][sum + 1];
        return doToToDown(nums, 0, sum, cache);
    }

    private boolean doToToDown(int[] nums, int index, int sum, Boolean[][] cache) {
        if (sum == 0)
            return true;

        if (index == nums.length)
            return false;

        if (cache[index][sum] != null)
            return cache[index][sum];

        if (nums[index] <= sum)
            if (doToToDown(nums, index + 1, sum - nums[index], cache)) { //add something
                cache[index][sum] = true;
                return true;
            }

        cache[index][sum] = doToToDown(nums, index + 1, sum, cache); //add nothing
        return cache[index][sum];
    }

    // BOTTOM TO TOP
    //time - (n * capacity), space - O(n * capacity)
    public boolean bottomToTop(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0)
            return false;

        sum /= 2;
        boolean[][] isSum = new boolean[nums.length][sum + 1]; // index = 3, is could get this sum by all indexes before 3 (0, 1, 2, 3)

        //INITIAL STATE
        for (int i = 0; i < nums.length; i++)
            isSum[i][0] = true; // 0 could get of any indexes (empty set)
        for (int s = 1; s <= sum; s++)
            isSum[0][s] = (nums[0] == s); // true if sum == first number (by index 0)

        //CALCULATE ALL STATES
        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (isSum[i - 1][s]) {
                    isSum[i][s] = isSum[i - 1][s]; //add nothing
                } else if (s >= nums[i]) {
                    isSum[i][s] = isSum[i - 1][s - nums[i]]; //add something
                }
            }
        }

        return isSum[nums.length - 1][sum];
    }
}
