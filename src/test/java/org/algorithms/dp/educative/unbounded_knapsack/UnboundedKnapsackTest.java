package org.algorithms.dp.educative.unbounded_knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnboundedKnapsackTest {
    private UnboundedKnapsack unboundedKnapsack;

    @BeforeEach
    void setUp() {
        unboundedKnapsack = new UnboundedKnapsack();
    }

    @Test
    void naive() {
        assertEquals(80, unboundedKnapsack.naive(
                new int[]{15, 20, 50}, new int[]{1, 2, 3}, 5));
    }

    @Test
    void topToDown() {
        assertEquals(80, unboundedKnapsack.topToDown(
                new int[]{15, 20, 50}, new int[]{1, 2, 3}, 5));
    }

    @Test
    void bottomToUp() {
        assertEquals(80, unboundedKnapsack.bottomToUp(
                new int[]{15, 20, 50}, new int[]{1, 2, 3}, 5));
        assertEquals(140, unboundedKnapsack.bottomToUp(
                new int[]{15, 50, 60, 90}, new int[]{1, 3, 4, 5}, 8));
    }
}