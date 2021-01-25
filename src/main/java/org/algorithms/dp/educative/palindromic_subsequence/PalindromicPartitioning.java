package org.algorithms.dp.educative.palindromic_subsequence;

/*
Given a string, we want to cut it into pieces such that each piece is a palindrome.
Write a function to return the minimum number of cuts needed.
 */
public class PalindromicPartitioning {

    //time - O(2^n), space - O(n)
    public int naive(String s) {
        return doNaive(s, 0, s.length() - 1);
    }

    private int doNaive(String s, int start, int end) {
        if (start >= end)
            return 0;

        if (s.charAt(start) == s.charAt(end)) {
            if (doNaive(s, start + 1, end - 1) == 0)
                return 0;
        }

        return 1 + Math.min(
                doNaive(s, start + 1, end),
                doNaive(s, start, end - 1)
        );
    }

    //time - O(n^2), space - O(n^2)
    public int doTopToDown(String s) {
        return doTopToDown(new Integer[s.length()][s.length()], s, 0, s.length() - 1);
    }

    private int doTopToDown(Integer[][] dp, String s, int start, int end) {
        if (start >= end)
            return 0;

        if (dp[start][end] == null) {
            if (s.charAt(start) == s.charAt(end))
                if (doTopToDown(dp, s, start + 1, end - 1) == 0) {
                    dp[start][end] = 0;
                    return dp[start][end];
                }

            dp[start][end] = 1 + Math.min(
                    doTopToDown(dp, s, start + 1, end),
                    doTopToDown(dp, s, start, end - 1)
            );
        }
        return dp[start][end];
    }

    //time - O(n^2), space - O(n^2)
    public int bottomToUp(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++)
            isPalindrome[i][i] = true;

        for (int start = n - 1; start >= 0; start--)
            for (int end = start + 1; end < n; end++)
                if (s.charAt(start) == s.charAt(end))
                    if (end - start == 1 || isPalindrome[start + 1][end - 1])
                        isPalindrome[start][end] = true;

        int[] cuts = new int[n];
        for (int start = n - 1; start >= 0; start--) {
            int minCuts = n;
            for (int end = n - 1; end >= start; end--)
                if (isPalindrome[start][end])
                    minCuts = (end == n - 1) ? 0 : Math.min(minCuts, 1 + cuts[end + 1]);
            cuts[start] = minCuts;
        }

        return cuts[0];
    }
}
