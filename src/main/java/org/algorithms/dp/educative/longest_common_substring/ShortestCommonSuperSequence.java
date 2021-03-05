package org.algorithms.dp.educative.longest_common_substring;

/*
ven two sequences 's1' and 's2', write a method to find the length of the shortest sequence which has 's1' and 's2' as subsequences.
 */
public class ShortestCommonSuperSequence {

    // time - O(2^{n1 + n2}), space - O(n1 + n2)
    public int naive(String s1, String s2) {
        return doNaive(s1, s2, 0, 0);
    }

    private int doNaive(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length())
            return s2.length() - i2;

        if (i2 == s2.length())
            return s1.length() - i1;

        if (s1.charAt(i1) == s2.charAt(i2))
            return 1 + doNaive(s1, s2, i1 + 1, i2 + 1);

        int sum1 = 1 + doNaive(s1, s2, i1 + 1, i2);
        int sum2 = 1 + doNaive(s1, s2, i1, i2 + 1);
        return Math.min(sum1, sum2);
    }

    // time - O(n1*n2), space - O(n1*n2)
    public int topToDown(String s1, String s2) {
        return doTopToDown(new Integer[s1.length()][s2.length()], s1, s2, 0, 0);
    }

    private int doTopToDown(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (i1 == s1.length())
            return s2.length() - i2;

        if (i2 == s2.length())
            return s1.length() - i1;

        if (dp[i1][i2] != null)
            return dp[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2)) {
            dp[i1][i2] = 1 + doTopToDown(dp, s1, s2, i1 + 1, i2 + 1);
        } else {
            int sum1 = 1 + doTopToDown(dp, s1, s2, i1 + 1, i2);
            int sum2 = 1 + doTopToDown(dp, s1, s2, i1, i2 + 1);
            dp[i1][i2] = Math.min(sum1, sum2);
        }
        return dp[i1][i2];
    }

    // time - O(n1*n2), space - O(n1*n2)
    public int bottomToUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i1 = 0; i1 <= s1.length(); i1++)
            dp[i1][0] = i1;

        for (int i2 = 0; i2 <= s2.length(); i2++)
            dp[0][i2] = i2;

        for (int i1 = 1; i1 <= s1.length(); i1++)
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], dp[i1][i2 - 1]);
            }
        return dp[s1.length()][s2.length()];
    }
}
