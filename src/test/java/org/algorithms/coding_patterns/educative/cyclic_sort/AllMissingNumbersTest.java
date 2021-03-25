package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllMissingNumbersTest {

    @Test
    void findNumbers1() {
        assertArrayEquals(new Integer[]{4, 6, 7}, AllMissingNumbers.findNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1}).toArray());
    }

    @Test
    void findNumbers2() {
        assertArrayEquals(new Integer[]{3}, AllMissingNumbers.findNumbers(new int[]{2, 4, 1, 2}).toArray());
    }

    @Test
    void findNumbers3() {
        assertArrayEquals(new Integer[]{4}, AllMissingNumbers.findNumbers(new int[]{2, 3, 2, 1}).toArray());
    }

    @Test
    void findNumbers4() {
        assertArrayEquals(new Integer[]{4, 6, 7}, AllMissingNumbers.findNumbers(new int[]{2, 2, 3, 8, 1, 3, 5, 1}).toArray());
    }
}