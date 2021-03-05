package org.algorithms.coding_patterns.educative.k_way_merge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestInSortedMatrixTest {

    @Test
    void findKthSmallest() {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        assertEquals(7, KthSmallestInSortedMatrix.findKthSmallest(matrix, 5));
    }
}