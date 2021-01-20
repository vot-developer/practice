package org.algorithms.dp.educative.knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetSumTest {
    private TargetSum targetSum;

    @BeforeEach
    void setUp() {
        targetSum = new TargetSum();
    }

    @Test
    void naive() {
        assertEquals(3, targetSum.naive(new int[]{1, 1, 2, 3}, 1));
        assertEquals(2, targetSum.naive(new int[]{1, 2, 7, 1}, 9));
    }

    @Test
    void naive2() {
        assertEquals(3, targetSum.naive2(new int[]{1, 1, 2, 3}, 1));
        assertEquals(2, targetSum.naive2(new int[]{1, 2, 7, 1}, 9));
    }

    @Test
    void topToDown() {
        assertEquals(3, targetSum.topToDown(new int[]{1, 1, 2, 3}, 1));
        assertEquals(2, targetSum.topToDown(new int[]{1, 2, 7, 1}, 9));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, targetSum.bottomToUp(new int[]{1, 1, 2, 3}, 1));
        assertEquals(2, targetSum.bottomToUp(new int[]{1, 2, 7, 1}, 9));
    }
}