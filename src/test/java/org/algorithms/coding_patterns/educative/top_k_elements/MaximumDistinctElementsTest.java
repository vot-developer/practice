package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDistinctElementsTest {

    @Test
    void findMaximumDistinctElements1() {
        assertEquals(3,
            MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2));
    }

    @Test
    void findMaximumDistinctElements2() {
        assertEquals(2,
            MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3));
    }

    @Test
    void findMaximumDistinctElements3() {
        assertEquals(3,
            MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2));
    }
}