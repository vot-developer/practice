package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstSmallestMissingPositiveTest {

    @Test
    void findMissingNumber1() {
        assertEquals(3, FirstSmallestMissingPositive.findNumber(new int[]{-3, 1, 5, 4, 2}));
    }

    @Test
    void findMissingNumber2() {
        assertEquals(4, FirstSmallestMissingPositive.findNumber(new int[]{3, -2, 0, 1, 2}));
    }
}