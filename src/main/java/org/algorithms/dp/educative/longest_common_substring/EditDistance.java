package org.algorithms.dp.educative.longest_common_substring;

/*
Given strings s1 and s2, we need to transform s1 into s2 by deleting, inserting, or replacing characters.
Write a function to calculate the count of the minimum number of edit operations.
 */
public class EditDistance {

    //time - O(3^{n1 + n2}), space - O(n1 + n2)
    public int naive(String s1, String s2) {
        return doNaive(s1, s2, 0, 0);
    }

    private int doNaive(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length())
            return s2.length() - i2;
        if (i2 == s2.length())
            return s1.length() - i1;

        if (s1.charAt(i1) == s2.charAt(i2))
            return doNaive(s1, s2, i1 + 1, i2 + 1);

        int c1 = doNaive(s1, s2, i1 + 1, i2); //skip in s1
        int c2 = doNaive(s1, s2, i1, i2 + 1); //skip in s2
        int c3 = doNaive(s1, s2, i1 + 1, i2 + 1); //replace symbol
        return 1 + Math.min(c1, Math.min(c2, c3));
    }

    //time - O(n1*n2), space - O(n1*n2)
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
            dp[i1][i2] = doNaive(s1, s2, i1 + 1, i2 + 1);
            return dp[i1][i2];
        }

        int c1 = doNaive(s1, s2, i1 + 1, i2); //skip in s1
        int c2 = doNaive(s1, s2, i1, i2 + 1); //skip in s2
        int c3 = doNaive(s1, s2, i1 + 1, i2 + 1); //replace symbol
        dp[i1][i2] = 1 + Math.min(c1, Math.min(c2, c3));
        return dp[i1][i2];
    }

    //time - O(n1*n2), space - O(n1*n2)
    public int bottomToUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i1 = 1; i1 <= s1.length(); i1++)
            for (int i2 = 1; i2 <= s2.length(); i2++){
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2 - 1], Math.min(dp[i1 - 1][i2], dp[i1][i2 - 1]));
            }

        return dp[s1.length()][s2.length()];
    }
}

