package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfElementsTest {

    @Test
    void findSumOfElements1() {
        assertEquals(23, SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6));
    }

    @Test
    void findSumOfElements2() {
        assertEquals(12, SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4));
    }
}