package org.algorithms.dp.educative;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsetSumTest {
    private SubsetSum subsetSum;

    @BeforeEach
    void setUp() {
        subsetSum = new SubsetSum();
    }

    @Test
    void testNaive() {
        assertTrue(subsetSum.naive(new int[]{1, 2, 3, 7}, 6));
        assertTrue(subsetSum.naive(new int[]{1, 2, 7, 1, 5}, 10));
        assertFalse(subsetSum.naive(new int[]{1, 3, 4, 8}, 6));
    }

    @Test
    void testTopToDown() {
        assertTrue(subsetSum.topToDown(new int[]{1, 2, 3, 7}, 6));
        assertTrue(subsetSum.topToDown(new int[]{1, 2, 7, 1, 5}, 10));
        assertFalse(subsetSum.topToDown(new int[]{1, 3, 4, 8}, 6));
    }

    @Test
    void testBottomToUp() {
        assertTrue(subsetSum.bottomToUp(new int[]{1, 2, 3, 7}, 6));
        assertTrue(subsetSum.bottomToUp(new int[]{1, 2, 7, 1, 5}, 10));
        assertFalse(subsetSum.bottomToUp(new int[]{1, 3, 4, 8}, 6));
    }
}