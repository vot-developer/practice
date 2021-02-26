package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchBitonicArrayTest {

    @Test
    void search() {
        assertEquals(3, SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        assertEquals(1, SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        assertEquals(3, SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        assertEquals(0, SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
        assertEquals(2, SearchBitonicArray.search(new int[] { 5, 1, 3 }, 3));
        assertEquals(4, SearchBitonicArray.search(new int[] { 5, 1, 2, 3, 4 }, 4));
        assertEquals(5, SearchBitonicArray.search(new int[] { 3,4,5,6,1,2 }, 2));
    }
}