package org.algorithms.coding_patterns.educative.two_heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximizeCapitalTest {

    @Test
    void findMaximumCapital1() {
        int result = MaximizeCapital.findMaximumCapital(
                new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        assertEquals(6, result);
    }

    @Test
    void findMaximumCapital2() {
        int result = MaximizeCapital.findMaximumCapital(
                new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        assertEquals(8, result);
    }

    @Test
    void findMaximumCapital3() {
        int result = MaximizeCapital.findMaximumCapital(
                new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 10, 0);
        assertEquals(6, result);
    }
}