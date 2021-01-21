package org.algorithms.dp.educative.unbounded_knapsack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumRibbonCutTest {
    private MaximumRibbonCut cut;

    @BeforeEach
    void setUp() {
        cut = new MaximumRibbonCut();
    }

    @Test
    void naive() {
        assertEquals(2, cut.naive(new int[]{2, 3, 5}, 5));
        assertEquals(3, cut.naive(new int[]{2, 3}, 7));
        assertEquals(3, cut.naive(new int[]{3, 5, 7}, 13));
    }

    @Test
    void bottomToUp() {
        assertEquals(2, cut.bottomToUp(new int[]{2, 3, 5}, 5));
        assertEquals(3, cut.bottomToUp(new int[]{2, 3}, 7));
        assertEquals(3, cut.bottomToUp(new int[]{3, 5, 7}, 13));
    }
}