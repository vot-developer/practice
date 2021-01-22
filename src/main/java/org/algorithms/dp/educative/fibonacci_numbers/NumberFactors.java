package org.algorithms.dp.educative.fibonacci_numbers;

/**
 Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.
 */
public class NumberFactors {

    //time - O(3^n), space - O(n)
    public int naive(int n) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        int count = 0;
        count += naive(n - 1);
        count += naive(n - 3);
        count += naive(n - 4);

        return count;
    }

    //time - O(n), space - O(n)
    public int topToDown(int n) {
        return doTopToDown(new Integer[n + 1], n);
    }

    private int doTopToDown(Integer[] dp, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp[n] != null)
            return dp[n];

        dp[n] = 0;
        dp[n] += doTopToDown(dp, n - 1);
        dp[n] += doTopToDown(dp, n - 3);
        dp[n] += doTopToDown(dp, n - 4);
        return dp[n];
    }

    //time - O(n), space - O(n)
    public int bottomToUp(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n == 4)
            return 4;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;

        for (int i = 5; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];

        return dp[n];
    }
}
