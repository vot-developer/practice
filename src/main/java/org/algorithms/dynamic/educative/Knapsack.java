package org.algorithms.dynamic.educative;

/**
 * Find max profit with limited capacity using stuff according them profits and weights
 * (could put in knapsack only one thing by one index)
 */
public class Knapsack {

    //NAIVE
    //time - (2^n), space - O(n) - on stack
    public int naive(int[] profits, int[] weights, int capacity) {
        return doNaive(profits, weights, capacity, 0);
    }

    private int doNaive(int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || index == profits.length)
            return 0;

        int prof1 = 0;//include current element
        if (weights[index] <= capacity)
            prof1 = profits[index] + doNaive(profits, weights, capacity - weights[index], index + 1);

        int prof2 = doNaive(profits, weights, capacity, index + 1); //exclude current element

        return Math.max(prof1, prof2);
    }

    // TOP TO BOTTOM
    //space - O(n * capacity) => time - (n * capacity)
    public int topToBottom(int[] profits, int[] weights, int capacity) {
        Integer[][] memoization = new Integer[profits.length][capacity + 1];
        return dotopToBottomWithMemoization(profits, weights, capacity, 0, memoization);
    }

    private int dotopToBottomWithMemoization(int[] profits, int[] weights, int capacity, int index, Integer[][] memoization) {
        if (capacity <= 0 || index == profits.length)
            return 0;

        if (memoization[index][capacity] != null)
            return memoization[index][capacity];

        int prof1 = 0;//include current element
        if (weights[index] <= capacity)
            prof1 = profits[index] + dotopToBottomWithMemoization(profits, weights,
                    capacity - weights[index], index + 1, memoization);

        int prof2 = dotopToBottomWithMemoization(profits, weights, capacity, index + 1, memoization); //exclude current element

        memoization[index][capacity] = Math.max(prof1, prof2);
        return memoization[index][capacity];
    }

    // BOTTOM TO TOP
    //time - (n * capacity), space - O(n * capacity)
    public int bottomToTop(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        int max = 0;
        for (int i = 0; i < profits.length; i++) //step
            for (int j = 0; j <= capacity; j++) { //capacity which we already have on this step
                if (i == 0){
                    if (j + weights[i] <= capacity)
                        dp[i][j + weights[i]] = profits[i]; //add something
                    continue;
                }
                if (dp[i][j] < dp[i - 1][j])
                    dp[i][j] = dp[i - 1][j]; //add nothing
                if (j + weights[i] <= capacity) {
                    dp[i][j + weights[i]] = dp[i - 1][j] + profits[i]; //add something
                    max = Math.max(dp[i][j + weights[i]], max);
                }
            }
        return max;
    }

    // BOTTOM TO TOP
    //time - (n * capacity), space - O(capacity)
    public int bottomToTopImproved(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[2][capacity + 1];
        int max = 0;
        for (int j = 0; j <= capacity; j++){
            if (j + weights[0] <= capacity)
                dp[0][j + weights[0]] = dp[1][j + weights[0]] = profits[0]; //add something
        }

        for (int i = 1; i < profits.length; i++) { //step
            for (int j = 0; j <= capacity; j++) { //capacity which we already have on this step
                if (dp[i % 2][j] < dp[(i - 1) % 2][j])
                    dp[i % 2][j] = dp[(i - 1) % 2][j]; //add nothing
                if (j + weights[i] <= capacity) {
                    dp[i % 2][j + weights[i]] = dp[(i - 1) % 2][j] + profits[i]; //add something
                    max = Math.max(dp[i % 2][j + weights[i]], max);
                }
            }
        }
        return max;
    }
}
