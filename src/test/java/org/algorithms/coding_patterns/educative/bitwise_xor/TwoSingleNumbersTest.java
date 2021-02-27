package org.algorithms.coding_patterns.educative.bitwise_xor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSingleNumbersTest {

    @Test
    void findSingleNumbers() {
        assertArrayEquals(new int[]{1, 3}, TwoSingleNumbers.findSingleNumbers(new int[] { 2, 1, 3, 2 }));
        assertArrayEquals(new int[]{4, 6}, TwoSingleNumbers.findSingleNumbers(new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 }));
    }
}