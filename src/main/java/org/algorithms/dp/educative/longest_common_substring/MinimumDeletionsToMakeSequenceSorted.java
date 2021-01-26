package org.algorithms.dp.educative.longest_common_substring;

/*
Given a number sequence, find the minimum number of elements that should be deleted to make the remaining sequence sorted.
 */
public class MinimumDeletionsToMakeSequenceSorted {

    //time - O(2^n) space - O(n)
    public int naive(int[] nums){
        return nums.length - doNaive(nums, 0, -1);
    }

    private int doNaive(int[] nums, int index, int prevIndex) {
        if (index == nums.length)
            return 0;

        int count1 = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex])
            count1 = 1 + doNaive(nums, index + 1, index);

        int count2 = doNaive(nums, index + 1, prevIndex);
        return Math.max(count1, count2);
    }

    //time - O(n^2) space - O(n)
    public int bottomToUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0 ; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < n; j++){
                if (nums[j] < nums[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
                max = Math.max(dp[i], max);
            }
        }

        return nums.length - max;
    }
}
