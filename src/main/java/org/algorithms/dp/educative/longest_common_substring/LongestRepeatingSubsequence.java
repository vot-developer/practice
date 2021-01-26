package org.algorithms.dp.educative.longest_common_substring;

/*
Given a sequence, find the length of its longest repeating subsequence (LRS).
A repeating subsequence will be the one that appears at least twice in the original sequence and is not overlapping
(i.e. none of the corresponding characters in the repeating subsequences have the same index).
 */
public class LongestRepeatingSubsequence {

    //time - O(2^n), space - O(n)
    public int naive(String s){
        return doNaive(s, 0, 1);
    }

    private int doNaive(String s, int i1, int i2) {
        if (i1 >= i2 || i1 == s.length() || i2 == s.length())
            return 0;

        if (s.charAt(i1) == s.charAt(i2))
            return 1 + doNaive(s, i1 + 1, i2 + 1);

        return Math.max(doNaive(s, i1 + 1, i2), doNaive(s, i1, i2 + 1));
    }

    //time - O(n^2), space - O(n^2)
    public int topToDown(String s){
        return doTopToDown(new Integer[s.length()][s.length()], s, 0, 1);
    }

    private int doTopToDown(Integer[][] dp, String s, int i1, int i2) {
        if (i1 >= i2 || i1 == s.length() || i2 == s.length())
            return 0;

        if (dp[i1][i2] != null)
            return dp[i1][i2];

        if (s.charAt(i1) == s.charAt(i2))
            dp[i1][i2] = 1 + doNaive(s, i1 + 1, i2 + 1);
        else
            dp[i1][i2] = Math.max(doNaive(s, i1 + 1, i2), doNaive(s, i1, i2 + 1));

        return dp[i1][i2];
    }

    public int bottomToUp(String s){
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        int max = 0;

        for (int i1 = 1; i1 <= s.length(); i1++)
            for (int i2 = i1 + 1; i2 <= s.length(); i2++){
                if (s.charAt(i1 - 1) == s.charAt(i2 - 1))
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                max = Math.max(dp[i1][i2], max);
            }

        return max;
    }
}
