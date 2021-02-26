package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotationCountOfRotatedArrayTest {

    @Test
    void countRotations() {
        assertEquals(2, RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        assertEquals(5, RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        assertEquals(0, RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}