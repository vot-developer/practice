package org.algorithms.dp.educative.palindromic_subsequence;

/*
Given a sequence, find the length of its Longest Palindromic Subsequence (LPS).
In a palindromic subsequence, elements read the same backward and forward.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
without changing the order of the remaining elements.
 */
public class LongestPalindromicSubsequence {

    //time - O(2^n), space - O(n)
    public int naive(String s) {
        return doNaive(s, 0, s.length() - 1);
    }

    private int doNaive(String s, int start, int end) {
        if (start == end)
            return 1;
        if (start > end)
            return 0;

        if (s.charAt(start) == s.charAt(end))
            return 2 + doNaive(s, start + 1, end - 1);

        return Math.max(
                doNaive(s, start + 1, end),
                doNaive(s, start, end - 1)
        );
    }

    //time - O(n*n), space - O(n*n)
    public int topToDown(String s) {
        return doTopToDown(new Integer[s.length()][s.length()], s, 0, s.length() - 1);
    }

    private int doTopToDown(Integer[][] dp, String s, int start, int end) {
        if (start == end)
            return 1;
        if (start > end)
            return 0;

        if (dp[start][end] != null)
            return dp[start][end];

        if (s.charAt(start) == s.charAt(end))
            dp[start][end] = 2 + doTopToDown(dp, s, start + 1, end - 1);
        else
            dp[start][end] = Math.max(
                    doTopToDown(dp, s, start + 1, end),
                    doTopToDown(dp, s, start, end - 1)
            );
        return dp[start][end];
    }

    //time - O(n*n), space - O(n*n)
    public int bottomToUp(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;

        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end))
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                else
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }
}
