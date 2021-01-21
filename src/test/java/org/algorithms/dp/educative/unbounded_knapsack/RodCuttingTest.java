package org.algorithms.dp.educative.unbounded_knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RodCuttingTest {
    private RodCutting rodCutting;

    @BeforeEach
    void setUp() {
        rodCutting = new RodCutting();
    }

    @Test
    void naive() {
        assertEquals(14, rodCutting.naive(new int[]{1, 2, 3, 4, 5}, new int[]{2, 6, 7, 10, 13}, 5));
    }

    @Test
    void bottomToUp() {
        assertEquals(14, rodCutting.bottomToUp(new int[]{1, 2, 3, 4, 5}, new int[]{2, 6, 7, 10, 13}, 5));
    }
}