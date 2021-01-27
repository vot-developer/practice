package org.algorithms.dp.educative.longest_common_substring;

public class SubsequencePatternMatching {

    //time - O(2^n), space - O(n)
    public int naive(String s, String pattern) {
        return doNaive(s, pattern, 0, 0);
    }

    private int doNaive(String s, String pattern, int sIndex, int pIndex) {
        if (pIndex == pattern.length())
            return 1;
        if (sIndex == s.length())
            return 0;

        int count = 0;
        if (s.charAt(sIndex) == pattern.charAt(pIndex))
            count = doNaive(s, pattern, sIndex + 1, pIndex + 1);

        return count + doNaive(s, pattern, sIndex + 1, pIndex);
    }

    //time - O(n1 * n2), space - O(n1 * n2)
    public int topToDown(String s, String pattern) {
        return doTopToDown(new Integer[s.length()][pattern.length()], s, pattern, 0, 0);
    }

    private int doTopToDown(Integer[][] dp, String s, String pattern, int sIndex, int pIndex) {
        if (pIndex == pattern.length())
            return 1;
        if (sIndex == s.length())
            return 0;

        if (dp[sIndex][pIndex] != null)
            return dp[sIndex][pIndex];

        int count = 0;
        if (s.charAt(sIndex) == pattern.charAt(pIndex))
            count = doTopToDown(dp, s, pattern, sIndex + 1, pIndex + 1);

        dp[sIndex][pIndex] = count + doTopToDown(dp, s, pattern, sIndex + 1, pIndex);

        return dp[sIndex][pIndex];
    }

    //time - O(n1 * n2), space - O(n1 * n2)
    public int bottomToUp(String s, String pattern) {
        int[][] dp = new int[s.length() + 1][pattern.length() + 1];

        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = 1;

        for (int sIndex = 1; sIndex <= s.length(); sIndex++)
            for (int pIndex = 1; pIndex <= pattern.length(); pIndex++) {
                if (s.charAt(sIndex - 1) == pattern.charAt(pIndex - 1))
                    dp[sIndex][pIndex] = dp[sIndex - 1][pIndex - 1];
                dp[sIndex][pIndex] += dp[sIndex - 1][pIndex];
            }
        return dp[s.length()][pattern.length()];
    }
}
