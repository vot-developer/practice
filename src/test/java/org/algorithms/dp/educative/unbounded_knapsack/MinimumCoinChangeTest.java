package org.algorithms.dp.educative.unbounded_knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCoinChangeTest {
    private MinimumCoinChange coinChange;

    @BeforeEach
    void setUp() {
        coinChange = new MinimumCoinChange();
    }

    @Test
    void naive() {
        assertEquals(2, coinChange.naive(new int[]{1,2,3},5));
        assertEquals(4, coinChange.naive(new int[]{1,2,3},11));
        assertEquals(2, coinChange.naive(new int[]{2,3},5));
        assertEquals(4, coinChange.naive(new int[]{2,3},11));
        assertEquals(Integer.MAX_VALUE, coinChange.naive(new int[]{3, 4},5));
    }

    @Test
    void topToDown() {
        assertEquals(2, coinChange.topToDown(new int[]{1,2,3},5));
        assertEquals(4, coinChange.topToDown(new int[]{1,2,3},11));
        assertEquals(2, coinChange.topToDown(new int[]{2,3},5));
        assertEquals(4, coinChange.topToDown(new int[]{2,3},11));
        assertEquals(Integer.MAX_VALUE, coinChange.naive(new int[]{3, 4},5));
    }

    @Test
    void bottomUp() {
        assertEquals(2, coinChange.bottomUp(new int[]{1,2,3},5));
        assertEquals(4, coinChange.bottomUp(new int[]{1,2,3},11));
        assertEquals(2, coinChange.bottomUp(new int[]{2,3},5));
        assertEquals(4, coinChange.bottomUp(new int[]{2,3},11));
        assertEquals(Integer.MAX_VALUE, coinChange.naive(new int[]{3, 4},5));
    }
}