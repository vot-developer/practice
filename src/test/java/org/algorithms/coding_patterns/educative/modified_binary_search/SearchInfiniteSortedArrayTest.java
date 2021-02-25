package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInfiniteSortedArrayTest {

    @Test
    void search1() {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        assertEquals(6, SearchInfiniteSortedArray.search(reader, 16));
        assertEquals(-1, SearchInfiniteSortedArray.search(reader, 11));
        assertEquals(-1, SearchInfiniteSortedArray.search(reader, 200));
    }

    @Test
    void search2() {
        ArrayReader reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        assertEquals(4, SearchInfiniteSortedArray.search(reader, 15));
        assertEquals(-1, SearchInfiniteSortedArray.search(reader, 200));
    }
}