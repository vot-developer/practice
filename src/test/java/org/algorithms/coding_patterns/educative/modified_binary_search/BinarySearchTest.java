package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search() {
        assertEquals(2, BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        assertEquals(4, BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        assertEquals(0, BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        assertEquals(2, BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}