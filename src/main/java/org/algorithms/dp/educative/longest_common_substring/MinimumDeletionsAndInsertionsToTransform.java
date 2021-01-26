package org.algorithms.dp.educative.longest_common_substring;

/*
Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters.
Write a function to calculate the count of the minimum number of deletion and insertion operations.
 */
public class MinimumDeletionsAndInsertionsToTransform {

    //time - O(2^{n1 + n2}), space - O(n1 + n2)
    public int naive(String s1, String s2) {
        return s1.length() - doNaive(s1, s2, 0, 0);
    }

    private int doNaive(String s1, String s2, int i1, int i2) {
        if (i1 >= s1.length() || i2 >= s2.length())
            return 0;

        if (s1.charAt(i1) == s2.charAt(i2))
            return 1 + doNaive(s1, s2, i1 + 1, i2 + 1);

        return Math.max(
                doNaive(s1, s2, i1 + 1, i2),
                doNaive(s1, s2, i1, i2 + 1)
        );
    }

    //time - O({n1 + n2}^2), space - O({n1 + n2}^2)
    public int topToDown(String s1, String s2) {
        return s1.length() - doTopToDown(new Integer[s1.length()][s2.length()], s1, s2, 0, 0);
    }

    private int doTopToDown(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (i1 >= s1.length() || i2 >= s2.length())
            return 0;

        if (dp[i1][i2] != null)
            return dp[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2)) {
            dp[i1][i2] = 1 + doTopToDown(dp, s1, s2, i1 + 1, i2 + 1);
            return dp[i1][i2];
        }

        dp[i1][i2] = Math.max(
                doTopToDown(dp, s1, s2, i1 + 1, i2),
                doTopToDown(dp, s1, s2, i1, i2 + 1)
        );
        return dp[i1][i2];
    }

    //time - O({n1 + n2}^2), space - O({n1 + n2}^2)
    public int bottomToUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i1 = 1; i1 <= s1.length(); i1++)
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                } else {
                    dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
                }
            }

        return s1.length() - dp[s1.length()][s2.length()];
    }

    //time - O({n1 + n2}^2), space - O(n2)
    public int bottomToUpSpaceImproved(String s1, String s2) {
        int[][] dp = new int[2][s2.length() + 1];

        for (int i1 = 1; i1 <= s1.length(); i1++)
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1 % 2][i2] = 1 + dp[(i1 - 1) % 2][i2 - 1];
                } else {
                    dp[i1 % 2][i2] = Math.max(dp[(i1 - 1) % 2][i2], dp[i1 % 2][i2 - 1]);
                }
            }

        return s1.length() - Math.max(dp[0][s2.length()], dp[1][s2.length()]);
    }
}
