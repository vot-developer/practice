package org.algorithms.coding_patterns.educative.subsets;

/*
Given a number 'n', write a function to return the count of structurally unique Binary Search Trees (BST)
that can store values 1 to 'n'.
 */
public class CountUniqueTrees {
    //time - O(n^2), space - O(n)
    public int countTrees(int n) {
        return doDP(n, new Integer[n + 1]);
    }

    private int doDP(int n, Integer[] dp) {
        if (n <= 1)
            return 1;

        if (dp[n] != null)
            return dp[n];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = doDP( i - 1, dp);
            int right = doDP(n - i, dp);
            count += left * right;
        }

        dp[n] = count;
        return dp[n];
    }
}
