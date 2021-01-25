package org.algorithms.dp.educative.palindromic_subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicPartitioningTest {
    private PalindromicPartitioning partitioning;

    @BeforeEach
    void setUp() {
        partitioning = new PalindromicPartitioning();
    }

    @Test
    void naive() {
        assertEquals(3, partitioning.naive("abdbca"));
        assertEquals(2, partitioning.naive("cddpd"));
        assertEquals(2, partitioning.naive("pqr"));
        assertEquals(0, partitioning.naive("pp"));
    }

    @Test
    void topToDown() {
        assertEquals(3, partitioning.doTopToDown("abdbca"));
        assertEquals(2, partitioning.doTopToDown("cddpd"));
        assertEquals(2, partitioning.doTopToDown("pqr"));
        assertEquals(0, partitioning.doTopToDown("pp"));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, partitioning.bottomToUp("abdbca"));
        assertEquals(2, partitioning.bottomToUp("cddpd"));
        assertEquals(2, partitioning.bottomToUp("pqr"));
        assertEquals(0, partitioning.bottomToUp("pp"));
    }
}