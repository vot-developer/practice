package org.algorithms.dp.educative.knapsack;

import java.util.Arrays;

/*
Given a set of positive numbers (non zero) and a target sum ‘S’. Each number should be assigned either a ‘+’ or ‘-’ sign.
 We need to find out total ways to assign symbols to make the sum of numbers equal to target ‘S’.
 */
public class TargetSum {

    //time - O(2^n), space - O(n) - stack
    public int naive(int[] nums, int s) {
        int sum = Arrays.stream(nums).sum();
        if (sum < s || (s + sum) % 2 == 1)
            return 0;
        return doNaive(nums, s, 0);
    }

    private int doNaive(int[] nums, int s, int index) {
        if (index == nums.length) {
            if (s == 0)
                return 1;
            return 0;
        }

        int sum1 = doNaive(nums, s - nums[index], index + 1);
        int sum2 = doNaive(nums, s + nums[index], index + 1);
        return sum1 + sum2;
    }

    //time - O(2^n), space - O(n) - stack
    public int naive2(int[] nums, int s) {
        int sum = Arrays.stream(nums).sum();
        if (sum < s || (s + sum) % 2 == 1)
            return 0;
        int sumToFind = (sum + s) / 2; //because Sum(s1) - Sum(s2) = S and Sum(s1) + Sum(s2) = Sum(num) => need find Sum(s1)
        return doNaive2(nums, sumToFind, 0);
    }

    private int doNaive2(int[] nums, int s, int index) {
        if (s == 0)
            return 1;
        if (index == nums.length)
            return 0;

        int sum1 = 0;
        if (s >= nums[index])
            sum1 = doNaive2(nums, s - nums[index], index + 1);//add something
        int sum2 = doNaive2(nums, s, index + 1); //add nothing
        return sum1 + sum2;
    }

    //time - O(n * s), space - O(n * s)
    public int topToDown(int[] nums, int s) {
        int sum = Arrays.stream(nums).sum();
        if (sum < s || (s + sum) % 2 == 1)
            return 0;
        int sumToFind = (sum + s) / 2;
        return topToDown(new Integer[nums.length][sumToFind + 1], nums, sumToFind, 0);
    }

    private int topToDown(Integer[][] cache, int[] nums, int s, int index) {
        if (s == 0)
            return 1;
        if (index == nums.length)
            return 0;

        if (cache[index][s] != null)
            return cache[index][s];

        int sum1 = 0;
        if (s >= nums[index])
            sum1 = topToDown(cache, nums, s - nums[index], index + 1);
        int sum2 = topToDown(cache, nums, s, index + 1);
        cache[index][s] = sum1 + sum2;
        return cache[index][s];
    }

    //time - O(n * s), space - O(s)
    public int bottomToUp(int[] nums, int S) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum < S || (totalSum + S) % 2 == 1)
            return 0;
        int sumToFind = (totalSum + S) / 2;

        int[] countSum = new int[sumToFind + 1];

        countSum[0] = 1;

        for (int s = 0; s <= sumToFind; s++)
            if (nums[0] == s)
                countSum[s] = 1;

        for (int i = 1; i < nums.length; i++)
            for (int s = sumToFind; s >= 0; s--) {
                if (s >= nums[i])
                    countSum[s] += countSum[s - nums[i]];
            }
        return countSum[sumToFind];
    }
}
