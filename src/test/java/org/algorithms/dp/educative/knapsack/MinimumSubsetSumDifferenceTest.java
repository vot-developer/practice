package org.algorithms.dp.educative.knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSubsetSumDifferenceTest {
    private MinimumSubsetSumDifference difference;

    @BeforeEach
    void setUp() {
        difference = new MinimumSubsetSumDifference();
    }

    @Test
    void naive() {
        assertEquals(3, difference.naive(new int[]{1, 2, 3, 9}));
        assertEquals(0, difference.naive(new int[]{1, 2, 7, 1, 5}));
        assertEquals(92, difference.naive(new int[]{1, 3, 100, 4}));
    }

    @Test
    void topToDown() {
        assertEquals(3, difference.topToDown(new int[]{1, 2, 3, 9}));
        assertEquals(0, difference.topToDown(new int[]{1, 2, 7, 1, 5}));
        assertEquals(92, difference.topToDown(new int[]{1, 3, 100, 4}));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, difference.bottomToUp(new int[]{1, 2, 3, 9}));
        assertEquals(0, difference.bottomToUp(new int[]{1, 2, 7, 1, 5}));
        assertEquals(92, difference.bottomToUp(new int[]{1, 3, 100, 4}));
    }
}