package org.algorithms.dp.educative.palindromic_subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubsequenceTest {
    private LongestPalindromicSubsequence longestPalindromicSubsequence;

    @BeforeEach
    void setUp() {
        longestPalindromicSubsequence = new LongestPalindromicSubsequence();
    }

    @Test
    void naive() {
        assertEquals(5, longestPalindromicSubsequence.naive("abdbca"));
        assertEquals(3, longestPalindromicSubsequence.naive("cddpd"));
        assertEquals(1, longestPalindromicSubsequence.naive("pqr"));
    }

    @Test
    void topToDown() {
        assertEquals(5, longestPalindromicSubsequence.topToDown("abdbca"));
        assertEquals(3, longestPalindromicSubsequence.topToDown("cddpd"));
        assertEquals(1, longestPalindromicSubsequence.topToDown("pqr"));
    }

    @Test
    void bottomToUp() {
        assertEquals(5, longestPalindromicSubsequence.bottomToUp("abdbca"));
        assertEquals(3, longestPalindromicSubsequence.bottomToUp("cddpd"));
        assertEquals(1, longestPalindromicSubsequence.bottomToUp("pqr"));
    }
}