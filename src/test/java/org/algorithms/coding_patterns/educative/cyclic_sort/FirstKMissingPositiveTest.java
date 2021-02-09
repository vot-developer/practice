package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstKMissingPositiveTest {

    @Test
    void findNumbers1() {
        assertArrayEquals(new Integer[]{1, 2, 6}, FirstKMissingPositive.findNumbers(new int[]{3, -1, 4, 5, 5}, 3).toArray());
    }

    @Test
    void findNumbers2() {
        assertArrayEquals(new Integer[]{1, 5, 6}, FirstKMissingPositive.findNumbers(new int[]{2, 3, 4}, 3).toArray());
    }

    @Test
    void findNumbers3() {
        assertArrayEquals(new Integer[]{1, 2}, FirstKMissingPositive.findNumbers(new int[]{-2, -3, 4}, 2).toArray());
    }

    @Test
    void findNumbers4() {
        assertArrayEquals(new Integer[]{4, 7}, FirstKMissingPositive.findNumbers(new int[]{2, 1, 3, 6, 5}, 2).toArray());
    }
}