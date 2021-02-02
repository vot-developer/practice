package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedArraySquaresTest {

    @Test
    void makeSquares() {
        assertArrayEquals(new int[]{0, 1, 4, 4, 9}, SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3}));
        assertArrayEquals(new int[]{0, 1, 1, 4, 9}, SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2}));
    }
}