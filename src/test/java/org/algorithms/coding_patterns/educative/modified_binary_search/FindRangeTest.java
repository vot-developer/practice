package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindRangeTest {

    @Test
    void findRange() {
        assertArrayEquals(new int[]{1, 3}, FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6));
        assertArrayEquals(new int[]{3, 3}, FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10));
        assertArrayEquals(new int[]{-1, -1}, FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12));
    }

    @Test
    void cornerCase() {
        assertArrayEquals(new int[]{0, 1}, FindRange.findRange(new int[] { 2, 2 }, 2));
    }
}