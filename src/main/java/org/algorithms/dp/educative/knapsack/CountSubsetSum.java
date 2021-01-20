package org.algorithms.dp.educative.knapsack;

public class CountSubsetSum {
    //time - O(2^n), space - O(n) (stack)
    public int naive(int[] nums, int sum) {
        return doNaive(nums, sum, 0);
    }

    private int doNaive(int[] nums, int sum, int index) {
        if (sum == 0)
            return 1;
        if (index == nums.length)
            return 0;

        int sum1 = doNaive(nums, sum, index + 1); //add nothing
        int sum2 = 0;
        if (sum >= nums[index])
            sum2 = doNaive(nums, sum - nums[index], index + 1); //add something

        return sum1 + sum2;
    }

    //time - O(n*S), space - O(n*S)
    public int topToDown(int[] nums, int sum) {
        return topToDown(new Integer[nums.length][sum + 1], nums, sum, 0);
    }

    private int topToDown(Integer[][] cache, int[] nums, int sum, int index) {
        if (sum == 0)
            return 1;
        if (index == nums.length)
            return 0;

        if (cache[index][sum] != null)
            return cache[index][sum];

        int sum1 = doNaive(nums, sum, index + 1); //add nothing
        int sum2 = 0;
        if (sum >= nums[index])
            sum2 = doNaive(nums, sum - nums[index], index + 1); //add something

        cache[index][sum] = sum1 + sum2;
        return cache[index][sum];
    }

    //time - O(n*S), space - O(n*S)
    public int bottomToUp(int[] nums, int sum) {
        int[][] countOfSubsets = new int[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++)
            countOfSubsets[i][0] = 1;

        for (int s = 1; s <= sum; s++)
            if (s == nums[0])
                countOfSubsets[0][s] = 1;

        for (int i = 1; i < nums.length; i++)
            for (int s = 1; s <= sum; s++) {
                countOfSubsets[i][s] = countOfSubsets[i - 1][s]; //add nothing
                if (s >= nums[i])
                    countOfSubsets[i][s] += countOfSubsets[i - 1][s - nums[i]]; //add something
            }
        return countOfSubsets[nums.length - 1][sum];
    }

    //time - O(n*S), space - O(S)
    public int bottomToUpImproved(int[] nums, int sum) {
        int[] countOfSubsets = new int[sum + 1];
        countOfSubsets[0] = 1;

        for (int s = 1; s <= sum; s++)
            if (s == nums[0])
                countOfSubsets[s] = 1;

        for (int i = 1; i < nums.length; i++)
            for (int s = sum; s >= 0; s--) {
                if (s >= nums[i])
                    countOfSubsets[s] += countOfSubsets[s - nums[i]];
            }
        return countOfSubsets[sum];
    }
}
