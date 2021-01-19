package org.algorithms.dp.educative.knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {
    private Knapsack ks;
    private int[] profits;
    private int[] weights;

    @BeforeEach
    void setUp() {
        ks = new Knapsack();
        profits = new int[]{1, 6, 10, 16};
        weights = new int[]{1, 2, 3, 5};
    }

    //NAIVE
    @Test
    void findMaxProfitNaive() {
        assertEquals(17, ks.naive(profits, weights, 6));
        assertEquals(22, ks.naive(profits, weights, 7));
    }

    //TOP TO BOTTOM
    @Test
    void topToBottom() {
        assertEquals(17, ks.topToBottom(profits, weights, 6));
        assertEquals(22, ks.topToBottom(profits, weights, 7));
    }

    //BOTTOM TO TOP
    @Test
    void bottomToTop() {
        assertEquals(17, ks.bottomToTop(profits, weights, 6));
        assertEquals(22, ks.bottomToTop(profits, weights, 7));
    }

    //BOTTOM TO TOP (IMPROVED)
    @Test
    void bottomToTopImproved() {
        assertEquals(17, ks.bottomToTopImproved(profits, weights, 6));
        assertEquals(22, ks.bottomToTopImproved(profits, weights, 7));
    }
}