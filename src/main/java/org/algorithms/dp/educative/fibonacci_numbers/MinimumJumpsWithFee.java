package org.algorithms.dp.educative.fibonacci_numbers;

/*
Given a staircase with 'n' steps and an array of 'n' numbers representing the fee that you have to pay
if you take the step.
Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step).
At every step, you have an option to take either 1 step, 2 steps, or 3 steps.
You should assume that you are standing at the first step.
 */
public class MinimumJumpsWithFee {

    //time - O(3^n), space - O(n)
    public int naive(int[] nums, int n) {
        return doNaive(nums, n, 0);
    }

    private int doNaive(int[] nums, int n, int index) {
        if (index >= n)
            return 0;

        int count1 = doNaive(nums, n, index + 1);
        int count2 = doNaive(nums, n, index + 2);
        int count3 = doNaive(nums, n, index + 3);
        return nums[index] + Math.min(count1, Math.min(count2, count3));
    }

    //time - O(n), space - O(n)
    public int topToDown(int[] nums, int n) {
        return doTopToDown(new Integer[nums.length], nums, n, 0);
    }

    private int doTopToDown(Integer[] dp, int[] nums, int n,  int index) {
        if (index >= n)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int count1 = doNaive(nums, n, index + 1);
        int count2 = doNaive(nums, n, index + 2);
        int count3 = doNaive(nums, n, index + 3);
        dp[index] = nums[index] + Math.min(count1, Math.min(count2, count3));
        return dp[index];
    }

    //time - O(n), space - O(n)
    public int bottomToUp(int[] nums, int n) {
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            dp[i] = Integer.MAX_VALUE;

        dp[0] = nums[0];
        dp[1] = nums[0];
        dp[2] = nums[0];
        dp[3] = nums[0];
        for (int i = 3; i < nums.length; i++)
            dp[i + 1] = Math.min(nums[i] + dp[i], Math.min(nums[i - 1] + dp[i - 1], nums[i - 2] + dp[i - 2]));

        return dp[n];
    }
}
