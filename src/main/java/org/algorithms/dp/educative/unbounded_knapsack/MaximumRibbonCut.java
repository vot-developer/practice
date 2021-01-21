package org.algorithms.dp.educative.unbounded_knapsack;

public class MaximumRibbonCut {

    //time - O(2^{n + length}), space - O(n + length)
    public int naive(int[] nums, int length) {
        return doNaive(nums, length, 0);
    }

    private int doNaive(int[] nums, int length, int index) {
        if (length == 0)
            return 0;
        if (index == nums.length)
            return Integer.MIN_VALUE;

        int count1 = Integer.MIN_VALUE;
        if (length >= nums[index]) {
            int result = doNaive(nums, length - nums[index], index); //add something
            if (result != Integer.MIN_VALUE)
                count1 = 1 + result;
        }
        int count2 = doNaive(nums, length, index + 1); //add nothing
        return Math.max(count1, count2);
    }

    //time - O(n + length), space - O(n + length)
    public int bottomToUp(int[] nums, int length) {
        int n = nums.length;
        int[][] dp = new int[n][length + 1];

        for (int i = 0; i < n; i++)
            for (int s = 0; s <= length; s++)
                dp[i][s] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        for (int i = 0; i < n; i++)
            for (int s = 1; s <= length; s++) {
                if (i > 0)
                    dp[i][s] = dp[i - 1][s];
                if (s >= nums[i])
                    if (dp[i][s - nums[i]] != Integer.MIN_VALUE)
                        dp[i][s] = Math.max(dp[i][s], 1 + dp[i][s - nums[i]]);
            }

        return dp[n - 1][length];
    }
}
