package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestWindowSortTest {

    @Test
    void sort() {
        assertEquals(5, ShortestWindowSort.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        assertEquals(5, ShortestWindowSort.sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        assertEquals(0, ShortestWindowSort.sort(new int[]{1, 2, 3}));
        assertEquals(3, ShortestWindowSort.sort(new int[]{3, 2, 1}));
        assertEquals(0, ShortestWindowSort.sort(new int[]{1,2,3,3,3}));
        assertEquals(2, ShortestWindowSort.sort(new int[]{1,3,2,3,3}));
    }
}