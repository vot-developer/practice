package org.algorithms.dp.educative.palindromic_subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDeletionsToPalindromeTest {
    private MinimumDeletionsToPalindrome mdp;

    @BeforeEach
    void setUp() {
        mdp = new MinimumDeletionsToPalindrome();
    }

    @Test
    void bottomToUp() {
        assertEquals(1, mdp.bottomToUp("abdbca"));
        assertEquals(2, mdp.bottomToUp("cddpd"));
        assertEquals(2, mdp.bottomToUp("pqr"));
    }
}