package org.algorithms.dp.educative.longest_common_substring;

public class LongestAlternatingSubsequence {

    //time - O(2^n), space - O(n)
    public int naive(int[] nums) {
        return Math.max(
                doNaive(nums, 0, -1, false),
                doNaive(nums, 0, -1, true)
        );
    }

    private int doNaive(int[] nums, int i, int prev, boolean isNeedIncrease) {
        if (i == nums.length)
            return 0;
        if (i == 0)
            return 1 + doNaive(nums, i + 1, i, !isNeedIncrease);

        int count = 0;
        if (isNeedIncrease) {
            if (isNeedIncrease && nums[i] > nums[prev])
                count = 1 + doNaive(nums, i + 1, i, !isNeedIncrease);
        } else if (nums[i] < nums[prev])
            count = 1 + doNaive(nums, i + 1, i, !isNeedIncrease);

        return Math.max(count, doNaive(nums, i + 1, prev, isNeedIncrease)); //skip current
    }

    //time - O(2^n), space - O(n^2)
    public int topToDown(int[] nums) {
        return Math.max(
                doTopToDown(new Integer[nums.length][nums.length][2], nums, 0, -1, false),
                doTopToDown(new Integer[nums.length][nums.length][2], nums, 0, -1, true)
        );
    }

    private int doTopToDown(Integer[][][] dp, int[] nums, int i, int prev, boolean isNeedIncrease) {
        if (i == nums.length)
            return 0;
        if (i == 0)
            return 1 + doNaive(nums, i + 1, i, !isNeedIncrease);

        int b = isNeedIncrease ? 1 : 0;
        if (dp[i][prev][b] != null)
            return dp[i][prev][b];

        int count = 0;
        if (isNeedIncrease) {
            if (isNeedIncrease && nums[i] > nums[prev])
                count = 1 + doNaive(nums, i + 1, i, !isNeedIncrease);
        } else if (nums[i] < nums[prev])
            count = 1 + doNaive(nums, i + 1, i, !isNeedIncrease);

        dp[i][prev][b] = Math.max(count,
                doNaive(nums, i + 1, prev, isNeedIncrease) //skip current
        );
        return dp[i][prev][b];
    }

    //time - O(2^n), space - O(n^2)
    public int bottomToUp(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                    maxLength = Math.max(maxLength, dp[i][0]);
                } else if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                    maxLength = Math.max(maxLength, dp[i][1]);
                }
            }
        }
        return maxLength;
    }
}
