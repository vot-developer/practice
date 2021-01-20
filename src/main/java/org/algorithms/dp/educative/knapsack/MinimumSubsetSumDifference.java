package org.algorithms.dp.educative.knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDifference {

    //time - O(2^n), space - O(n) (stack)
    public int naive(int[] nums) {
        return doNaive(nums, 0, 0, 0);
    }

    private int doNaive(int[] nums, int sum1, int sum2, int index) {
        if (index == nums.length)
            return Math.abs(sum1 - sum2);

        int diff1 = doNaive(nums, sum1 + nums[index], sum2, index + 1);
        int diff2 = doNaive(nums, sum1, sum2 + nums[index], index + 1);
        return Math.min(diff1, diff2);
    }

    //time - O(n*S), space - O(n*S)
    public int topToDown(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return doTopToDown(new Integer[nums.length][sum], nums, 0, 0, 0);
    }

    private int doTopToDown(Integer[][] cache, int[] nums, int sum1, int sum2, int index) {
        if (index == nums.length)
            return Math.abs(sum1 - sum2);

        if (cache[index][sum1] != null)
            return cache[index][sum1];

        int diff1 = doTopToDown(cache, nums, sum1 + nums[index], sum2, index + 1);
        int diff2 = doTopToDown(cache, nums, sum1, sum2 + nums[index], index + 1);
        cache[index][sum1] = Math.min(diff1, diff2);
        return cache[index][sum1];
    }

    //time - O(n*S), space - O(n*S)
    public int bottomToUp(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int halfSum = sum / 2;
        boolean[][] isSumReached = new boolean[nums.length][halfSum + 1];
        for (int i = 0; i < nums.length; i++)
            isSumReached[i][0] = true;

        for (int s = 1; s <= halfSum; s++)
            if (nums[0] == s)
                isSumReached[0][s] = true;

        for (int i = 1; i < nums.length; i++)
            for (int s = 1; s <= halfSum; s++) {
                if (isSumReached[i - 1][s])
                    isSumReached[i][s] = true; //add nothing
                else if (s >= nums[i])
                    isSumReached[i][s] = isSumReached[i - 1][s - nums[i]];//add something
            }

        int s = halfSum;
        while (!isSumReached[nums.length - 1][s])
            s--;
        return sum - 2 * s;
    }
}
