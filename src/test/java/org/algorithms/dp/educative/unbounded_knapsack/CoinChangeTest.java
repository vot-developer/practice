package org.algorithms.dp.educative.unbounded_knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {
    private CoinChange coinChange;

    @BeforeEach
    void setUp() {
        coinChange = new CoinChange();
    }

    @Test
    void naive() {
        assertEquals(5, coinChange.naive(new int[]{1, 2, 3}, 5));
        assertEquals(2, coinChange.topToDown(new int[]{2, 3}, 6));
    }

    @Test
    void topToDown() {
        assertEquals(5, coinChange.topToDown(new int[]{1, 2, 3}, 5));
        assertEquals(2, coinChange.topToDown(new int[]{2, 3}, 6));
    }

    @Test
    void bottomToUp() {
        assertEquals(5, coinChange.bottomUp(new int[]{1, 2, 3}, 5));
        assertEquals(2, coinChange.bottomUp(new int[]{2, 3}, 6));
    }
}