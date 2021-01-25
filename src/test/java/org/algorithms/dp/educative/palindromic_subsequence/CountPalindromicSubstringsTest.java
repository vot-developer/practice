package org.algorithms.dp.educative.palindromic_subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPalindromicSubstringsTest {
    private CountPalindromicSubstrings cps;

    @BeforeEach
    void setUp() {
        cps = new CountPalindromicSubstrings();
    }

    @Test
    void bottomToUp() {
        assertEquals(7, cps.bottomToUp("abdbca"));
        assertEquals(7, cps.bottomToUp("cddpd"));
        assertEquals(3, cps.bottomToUp("pqr"));
    }
}