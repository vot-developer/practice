package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRotatedArrayTest {

    @Test
    void search() {
        assertEquals(1, SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        assertEquals(4, SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}