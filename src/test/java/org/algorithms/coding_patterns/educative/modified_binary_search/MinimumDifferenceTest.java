package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDifferenceTest {

    @Test
    void searchMinDiffElement() {
        assertEquals(6, MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        assertEquals(4, MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        assertEquals(10, MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        assertEquals(10, MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
        assertEquals(7, MinimumDifference.searchMinDiffElement(new int[] { 2, 4, 7, 9 }, 6));
    }
}