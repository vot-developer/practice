package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxInBitonicArrayTest {

    @Test
    void findMax() {
        assertEquals(12, MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        assertEquals(8, MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
        assertEquals(12, MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
        assertEquals(10, MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
        assertEquals(6, MaxInBitonicArray.findMax(new int[] { 1,6,5,4,3,2,1 }));
    }
}