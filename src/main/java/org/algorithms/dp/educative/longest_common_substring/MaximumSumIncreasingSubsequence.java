package org.algorithms.dp.educative.longest_common_substring;

public class MaximumSumIncreasingSubsequence {

    //time - O(2^n) space - O(n)
    public int naive(int[] nums) {
        return doNaive(nums, 0, -1);
    }

    private int doNaive(int[] nums, int index, int prevIndex) {
        if (index == nums.length)
            return 0;

        int c1 = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex])
            c1 = nums[index] + doNaive(nums, index + 1, index);

        int c2 = doNaive(nums, index + 1, prevIndex);
        return Math.max(c1, c2);
    }

    //time - O(n^2) space - O(n^2)
    public int topToDown(int[] nums) {
        return doTopToDown(new Integer[nums.length][nums.length], nums, 0, -1);
    }

    private int doTopToDown(Integer[][] dp, int[] nums, int index, int prevIndex) {
        if (index == nums.length)
            return 0;

        if (dp[index][prevIndex + 1] != null)
            return dp[index][prevIndex + 1];

        int c1 = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex])
            c1 = nums[index] + doNaive(nums, index + 1, index);

        int c2 = doNaive(nums, index + 1, prevIndex);
        dp[index][prevIndex + 1] = Math.max(c1, c2);
        return dp[index][prevIndex + 1];
    }

    //time - O(n^2) space - O(n)
    public int bottomToUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            dp[i] = nums[i];
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && dp[j] + nums[i] > dp[i]) { //for don't include negative or smaller values
                    dp[i] = dp[j] + nums[i];
                }
                max = Math.max(dp[i], max);
            }
        }

        return max;
    }
}
