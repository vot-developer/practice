package org.algorithms.coding_patterns.educative.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void solveKnapsack1() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        assertEquals(22,new Knapsack().solveKnapsack(profits, weights, 7));
    }

    @Test
    void solveKnapsack2() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        assertEquals(17,new Knapsack().solveKnapsack(profits, weights, 6));
    }
}