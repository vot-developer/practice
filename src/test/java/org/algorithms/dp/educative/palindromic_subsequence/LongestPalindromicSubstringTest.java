package org.algorithms.dp.educative.palindromic_subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring lps;

    @BeforeEach
    void setUp() {
        lps = new LongestPalindromicSubstring();
    }

    @Test
    void naive() {
        assertEquals(3, lps.naive("abdbca"));
        assertEquals(3, lps.naive("cddpd"));
        assertEquals(1, lps.naive("pqr"));
    }

    @Test
    void topToDown() {
        assertEquals(3, lps.topToDown("abdbca"));
        assertEquals(3, lps.topToDown("cddpd"));
        assertEquals(1, lps.topToDown("pqr"));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, lps.bottomToUp("abdbca"));
        assertEquals(3, lps.bottomToUp("cddpd"));
        assertEquals(1, lps.bottomToUp("pqr"));
    }
}