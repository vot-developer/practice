package org.algorithms.dp.educative.palindromic_subsequence;

/*
Given a string, find the length of its Longest Palindromic Substring (LPS).
In a palindromic string, elements read the same backward and forward.
 */
public class LongestPalindromicSubstring {

    //time - O(2^n), space - O(n)
    public int naive(String s) {
        return doNaive(s, 0, s.length() - 1);
    }

    private int doNaive(String s, int start, int end) {
        if (start == end)
            return 1;
        if (start > end)
            return 0;

        if (s.charAt(start) == s.charAt(end)) {
            int possibleSum = end - start - 1; // future shift included here because start and end are included = (diff - 2)
            if (possibleSum == doNaive(s, start + 1, end - 1))
                return 2 + possibleSum;
        }

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

        if (dp[start][end] == null) {

            if (s.charAt(start) == s.charAt(end)) {
                int possibleSum = end - start - 1; // future shift included here because start and end are included = (diff - 2)
                if (possibleSum == doNaive(s, start + 1, end - 1))
                    dp[start][end] = 2 + possibleSum;
            }

            dp[start][end] = Math.max(
                    doNaive(s, start + 1, end),
                    doNaive(s, start, end - 1)
            );
        }

        return dp[start][end];
    }

    //time - O(n*n), space - O(n*n)
    public int bottomToUp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        int maxLength = 1;
        for (int start = n; start >= 0; start--)
            for (int end = start + 1; end < n; end++){
                if (s.charAt(start) == s.charAt(end)){
                    if (start - end == 1 || dp[start + 1][end - 1]){
                        dp[start][end] = true;
                        maxLength = Math.max(end - start + 1, maxLength);
                    }
                }
            }

        return maxLength;
    }
}
