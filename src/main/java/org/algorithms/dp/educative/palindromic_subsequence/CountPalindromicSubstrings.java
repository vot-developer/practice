package org.algorithms.dp.educative.palindromic_subsequence;

/*
Given a string, find the total number of palindromic substrings in it.
Please note we need to find the total number of substrings and not subsequences.
 */
public class CountPalindromicSubstrings {

    //time - O(n^2), space - O(n)
    public int bottomToUp(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int start = n - 1; start >= 0; start--)
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        count++;
                    }
                }
            }
        return count;
    }
}
