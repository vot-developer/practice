package org.algorithms.dp.educative.longest_common_substring;

/*
Given a number sequence, find the length of its Longest Bitonic Subsequence (LBS).
A subsequence is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 */
public class LongestBitonicSubsequence {

    //NAIVE
    //time - O(2^n), space - O(n)
    public int naive(int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            int c1 = naiveCountDecrement(nums, i, -1);
            int c2 = naiveCountIncrement(nums, i, -1);
            max = Math.max(c1 + c2 - 1, max);
        }
        return max;
    }

    private int naiveCountDecrement(int[] nums, int i, int prev) {
        if (i == nums.length)
            return 0;

        int max = 0;
        if (prev == -1 || nums[i] < nums[prev])
            max = 1 + naiveCountDecrement(nums, i + 1, i);

        return Math.max(max, naiveCountDecrement(nums, i + 1, prev));
    }

    private int naiveCountIncrement(int[] nums, int i, int prev) {
        if (i < 0)
            return 0;

        int max = 0;
        if (prev == -1 || nums[i] < nums[prev])
            max = 1 + naiveCountIncrement(nums, i - 1, i);

        return Math.max(max, naiveCountIncrement(nums, i - 1, prev));
    }

    //TOP TO DOWN
    //time - O(n^2), space - O(n^2)
    public int topToDown(int[] nums){
        Integer[][] dpInc = new Integer[nums.length][nums.length + 1];
        Integer[][] dpDec = new Integer[nums.length][nums.length + 1];

        int max = 0;
        for (int i = 0; i < nums.length; i++){
            int c1 = topToDownCountDecrement(dpDec, nums, i, -1);
            int c2 = topToDownCountIncrement(dpInc, nums, i, -1);
            max = Math.max(c1 + c2 - 1, max);
        }
        return max;
    }

    private int topToDownCountDecrement(Integer[][] dp, int[] nums, int i, int prev) {
        if (i == nums.length)
            return 0;
        if (dp[i][prev + 1] != null)
            return dp[i][prev + 1];

        int max = 0;
        if (prev == -1 || nums[i] < nums[prev])
            max = 1 + topToDownCountDecrement(dp, nums, i + 1, i);

        dp[i][prev + 1] = Math.max(max, topToDownCountDecrement(dp, nums, i + 1, prev));
        return dp[i][prev + 1];
    }

    private int topToDownCountIncrement(Integer[][] dp, int[] nums, int i, int prev) {
        if (i < 0)
            return 0;
        if (dp[i][prev + 1] != null)
            return dp[i][prev + 1];

        int max = 0;
        if (prev == -1 || nums[i] < nums[prev])
            max = 1 + topToDownCountIncrement(dp, nums, i - 1, i);

        dp[i][prev + 1] = Math.max(max, topToDownCountIncrement(dp, nums, i - 1, prev));
        return dp[i][prev + 1];
    }

    //BOTTOM TO UP
    //time - O(n^2), space - O(n^2)
    public int bottomToUp(int[] nums){
        int[] dpInc = new int[nums.length];
        int[] dpDec = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dpInc[i] = 1;
            for (int j = i - 1; j >= 0; j--)
                if (nums[j] < nums[i])
                    dpInc[i] = Math.max(dpInc[i], dpInc[j] + 1);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            dpDec[i] = 1;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[i])
                    dpDec[i] = Math.max(dpDec[i], dpDec[j] + 1);
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++)
            maxLength = Math.max(maxLength, dpInc[i] + dpDec[i] - 1);

        return maxLength;
    }
}
