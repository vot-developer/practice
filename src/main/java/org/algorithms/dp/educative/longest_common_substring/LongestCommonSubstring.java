package org.algorithms.dp.educative.longest_common_substring;

/*
Given two strings 's1' and 's2', find the length of the longest substring which is common in both the strings.
 */
public class LongestCommonSubstring {

    //time - O(3^{n1 + n2}), space - O(n1 + n2)
    public int naive(String s1, String s2) {
        return doNaive(s1, s2, 0, 0, 0);
    }

    private int doNaive(String s1, String s2, int i1, int i2, int count) {
        if (i1 == s1.length() || i2 == s2.length())
            return count;

        if (s1.charAt(i1) == s2.charAt(i2))
            count = doNaive(s1, s2, i1 + 1, i2 + 1, count + 1);

        int newCount = Math.max(
                doNaive(s1, s2, i1 + 1, i2, 0),
                doNaive(s1, s2, i1, i2 + 1, 0)
        );
        return Math.max(count, newCount);
    }

    //time - O({n1 + n2}^2), space - O({n1 + n2}^2)
    public int topToDown(String s1, String s2) {
        return doTopToDown(new Integer[s1.length()][s2.length()], s1, s2, 0, 0, 0);
    }

    private int doTopToDown(Integer[][] dp, String s1, String s2, int i1, int i2, int count) {
        if (i1 >= s1.length() || i2 >= s2.length())
            return count;

        if (dp[i1][i2] != null)
            return dp[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2))
            count = doTopToDown(dp, s1, s2, i1 + 1, i2 + 1, count + 1);

        int newCount = Math.max(
                doTopToDown(dp, s1, s2, i1 + 1, i2, count),
                doTopToDown(dp, s1, s2, i1, i2 + 1, count)
        );

        dp[i1][i2] = Math.max(count, newCount);
        return dp[i1][i2];
    }

    //time - O({n1 + n2}^2), space - O({n1 + n2}^2)
    public int bottomToUp(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int max = 0;

        if (s1.charAt(0) == s2.charAt(0))
            dp[0][0] = 1;

        for (int i1 = 1; i1 < s1.length(); i1++)
            for (int i2 = 1; i2 < s2.length(); i2++){
                if (s1.charAt(i1) == s2.charAt(i2)) {
                    dp[i1][i2] = dp[i1 - 1][i2 - 1] + 1;
                    max = Math.max(dp[i1][i2], max);
                }
            }

        return max;
    }

    //time - O({n1 + n2}^2), space - O(n2)
    public int bottomToUpSpaceImproved(String s1, String s2) {
        int[][] dp = new int[2][s2.length() + 1];
        int max = 0;

        for (int i1 = 1; i1 <= s1.length(); i1++)
            for (int i2 = 1; i2 <= s2.length(); i2++){
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1 % 2][i2] = dp[(i1 - 1) % 2][i2 - 1] + 1;
                    max = Math.max(dp[i1 % 2][i2], max);
                } else {
                    dp[i1 % 2][i2] = 0;
                }
            }

        return max;
    }
}
