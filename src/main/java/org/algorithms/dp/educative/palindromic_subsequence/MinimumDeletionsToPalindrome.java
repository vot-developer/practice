package org.algorithms.dp.educative.palindromic_subsequence;

public class MinimumDeletionsToPalindrome {

    //time - O(n^2), space - O(n^2)
    public int bottomToUp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        for (int start = n - 1; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end))
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                else
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
            }
        }
        return n - dp[0][n - 1];
    }
}
