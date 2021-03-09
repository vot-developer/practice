package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestPairsTest {

    @Test
    void findKLargestPairs() {
        int[] l1 = new int[]{9, 8, 2};
        int[] l2 = new int[]{6, 3, 1};
        List<List<Integer>> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        assertEquals(3, result.size());
        assertArrayEquals(new Integer[]{9, 3}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{8, 6}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{9, 6}, result.get(2).toArray());
    }
}