package org.algorithms.dp.educative.knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountSubsetSumTest {
    private CountSubsetSum subsetSum;

    @BeforeEach
    void setUp() {
        subsetSum = new CountSubsetSum();
    }

    @Test
    void naive() {
        assertEquals(3, subsetSum.naive(new int[]{1, 1, 2, 3}, 4));
        assertEquals(3, subsetSum.naive(new int[]{1, 2, 7, 1, 5}, 9));
    }

    @Test
    void topToDown() {
        assertEquals(3, subsetSum.topToDown(new int[]{1, 1, 2, 3}, 4));
        assertEquals(3, subsetSum.topToDown(new int[]{1, 2, 7, 1, 5}, 9));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, subsetSum.bottomToUp(new int[]{1, 1, 2, 3}, 4));
        assertEquals(3, subsetSum.bottomToUp(new int[]{1, 2, 7, 1, 5}, 9));
    }

    @Test
    void bottomToUpImproved() {
        assertEquals(3, subsetSum.bottomToUpImproved(new int[]{1, 1, 2, 3}, 4));
        assertEquals(3, subsetSum.bottomToUpImproved(new int[]{1, 2, 7, 1, 5}, 9));
    }
}