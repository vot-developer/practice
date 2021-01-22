package org.algorithms.dp.educative.unbounded_knapsack;

/*
Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.
 */
public class CoinChange {

    //time - O(2^{n + amount}), space - O(n + amount)
    public int naive(int[] nums, int amount) {
        return doNaive(nums, amount, 0);
    }

    private int doNaive(int[] nums, int amount, int index) {
        if (amount == 0)
            return 1;
        if (index == nums.length)
            return 0;

        int sum1 = 0;
        if (amount >= nums[index])
            sum1 = doNaive(nums, amount - nums[index], index);

        int sum2 = doNaive(nums, amount, index + 1);
        return sum1 + sum2;
    }

    //time - O(n*a), space - O(n*a)
    public int topToDown(int[] nums, int amount) {
        return topToDown(new Integer[nums.length][amount + 1], nums, amount, 0);
    }

    private int topToDown(Integer[][] cache, int[] nums, int amount, int index) {
        if (amount == 0)
            return 1;
        if (index == nums.length)
            return 0;

        if (cache[index][amount] != null)
            return cache[index][amount];

        int sum1 = 0;
        if (amount >= nums[index])
            sum1 = topToDown(cache, nums, amount - nums[index], index);

        int sum2 = topToDown(cache, nums, amount, index + 1);

        cache[index][amount] = sum1 + sum2;
        return cache[index][amount];
    }

    //time - O(n*a), space - O(n*a)
    public int bottomUp(int[] nums, int amount) {
        int n = nums.length;
        int[][] aux = new int[n][amount + 1];

        for (int i = 0; i < n; i++)
            aux[i][0] = 1;

        for (int i = 0; i < n; i++)
            for (int s = 1; s <= amount; s++) {
                if (i > 0)
                    aux[i][s] = aux[i - 1][s];
                if (s >= nums[i])
                    aux[i][s] += aux[i][s - nums[i]];
            }

        return aux[n - 1][amount];
    }
}
