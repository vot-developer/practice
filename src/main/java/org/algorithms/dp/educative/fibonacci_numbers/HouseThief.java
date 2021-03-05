package org.algorithms.dp.educative.fibonacci_numbers;

/*
There are 'n' houses built in a line. A thief wants to steal maximum possible money from these houses.
The only restriction the thief has is that he can't steal from two consecutive houses,
as that would alert the security system.
How should the thief maximize his stealing?
 */
public class HouseThief {

    //time - O (2^n), space - O(n)
    public int naive(int[] nums) {
        return doNaive(nums, 0);
    }

    private int doNaive(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        int current = nums[index] + doNaive(nums, index + 2);
        int next = doNaive(nums, index + 1);
        return Math.max(current, next);
    }

    //time - O (n), space - O(n)
    public int topToDown(int[] nums){
        return doTopToDown(new Integer[nums.length], nums, 0);
    }

    private int doTopToDown(Integer[] dp, int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int current = nums[index] + doTopToDown(dp, nums, index + 2);
        int next = doTopToDown(dp, nums, index + 1);
        dp[index] = Math.max(current, next);
        return dp[index];
    }

    //time - O (n), space - O(n)
    public int bottomToUp(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + dp[0];

        for (int i = 3; i < nums.length; i++){
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
