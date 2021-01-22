package org.algorithms.dp.educative.fibonacci_numbers;

/**
 * Given an array of positive numbers, where each element represents the min number of jumps that can be made forward
 * from that element, write a program to find the minimum number of jumps needed to reach the end of the array (starting
 * from the first element). If an element is 0, then we cannot move through that element.
 */
public class MinimumJumps {

    //time - O(2^n), space - O(n)
    public int naive(int[] nums) {
        return doNaive(nums, 0);
    }

    private int doNaive(int[] nums, int index) {
        if (index == nums.length - 1)
            return 0; // found way
        if (index >= nums.length || nums[index] == 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        int result;
        for (int i = 1; i <= nums[index]; i++) {
            result = doNaive(nums, index + i);
            if (result != Integer.MAX_VALUE && result + 1 < min)
                min = result + 1;
        }
        return min;
    }

    //time - O(n^2), space - O(n)
    public int topToDown(int[] nums) {
        return doTopToDown(new Integer[nums.length], nums, 0);
    }

    private int doTopToDown(Integer[] dp, int[] nums, int index) {
        if (index == nums.length - 1)
            return 0;
        if (index >= nums.length || nums[index] == 0)
            return Integer.MAX_VALUE;

        if (dp[index] != null)
            return dp[index];

        int result, min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            result = doTopToDown(dp, nums, index + i);
            if (result != Integer.MAX_VALUE && result + 1 < min)
                min = result + 1;
        }
        dp[index] = min;
        return min;
    }

    //time - O(n^2), space - O(n)
    public int bottomToUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n - 1; i++) //dp[n - 1] = 0;
            dp[i] = Integer.MAX_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++)
                if (dp[j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(1 + dp[j], dp[i]);
        }

        return dp[0];
    }
}
