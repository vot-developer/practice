package org.algorithms.dp.educative.unbounded_knapsack;

public class MinimumCoinChange {

    //time - O(2^{n + amount}), space - O(n + amount)
    public int naive(int[] nums, int amount) {
        return doNaive(nums, amount, 0);
    }

    private int doNaive(int[] nums, int amount, int index) {
        if (amount == 0)
            return 0;

        if (index >= nums.length)
            return Integer.MAX_VALUE;

        int sum1 = Integer.MAX_VALUE;
        if (amount >= nums[index]) {
            int result = doNaive(nums, amount - nums[index], index); //add something
            if (result < Integer.MAX_VALUE)
                sum1 = 1 + result;
        }
        int sum2 = doNaive(nums, amount, index + 1); //add nothing

        return Math.min(sum1, sum2);
    }

    //time - O(n*a), space - O(n*a)
    public int topToDown(int[] nums, int amount) {
        return topToDown(new Integer[nums.length][amount + 1], nums, amount, 0);
    }

    private int topToDown(Integer[][] cache, int[] nums, int amount, int index) {
        if (amount == 0)
            return 0;

        if (index >= nums.length)
            return Integer.MAX_VALUE;

        if (cache[index][amount] != null)
            return cache[index][amount];

        int sum1 = Integer.MAX_VALUE;
        if (amount >= nums[index]) {
            int result = doNaive(nums, amount - nums[index], index); //add something
            if (result < Integer.MAX_VALUE)
                sum1 = 1 + result;
        }
        int sum2 = doNaive(nums, amount, index + 1); //add nothing
        cache[index][amount] = Math.min(sum1, sum2);
        return cache[index][amount];
    }

    //time - O(n*a), space - O(n*a)
    public int bottomUp(int[] nums, int amount) {
        int n = nums.length;
        int[][] aux = new int[n][amount + 1];

        for (int i = 0; i < n; i++)
            for (int s = 0; s <= amount; s++)
                aux[i][s] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            aux[i][0] = 0;

        for (int i = 0; i < n; i++)
            for (int s = 1; s <= amount; s++) {
                int sum1 = Integer.MAX_VALUE, sum2 = Integer.MAX_VALUE;
                if (i > 0)
                    sum1 = aux[i - 1][s];
                if (s >= nums[i])
                    if (aux[i][s - nums[i]] != Integer.MAX_VALUE)
                        sum2 = 1 + aux[i][s - nums[i]];
                aux[i][s] = Math.min(sum1, sum2);
            }

        return aux[n - 1][amount];
    }
}
