package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindCorruptNumsTest {

    @Test
    void findNumbers1() {
        assertArrayEquals(new int[]{4, 2}, FindCorruptNums.findNumbers(new int[]{3, 1, 2, 5, 2}));
    }

    @Test
    void findNumbers2() {
        assertArrayEquals(new int[]{5, 3}, FindCorruptNums.findNumbers(new int[]{3, 1, 2, 3, 6, 4}));
    }
}