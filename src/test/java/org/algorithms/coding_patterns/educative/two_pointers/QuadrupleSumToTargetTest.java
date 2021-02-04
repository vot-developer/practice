package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuadrupleSumToTargetTest {

    @Test
    void searchQuadruplets1() {
        List<List<Integer>> result = QuadrupleSumToTarget.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1);
        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{-3, -1, 1, 4}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{-3, 1, 1, 2}, result.get(1).toArray());
    }

    @Test
    void searchQuadruplets2() {
        List<List<Integer>> result = QuadrupleSumToTarget.searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2);
        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{-2, 0, 2, 2}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{-1, 0, 1, 2}, result.get(1).toArray());
    }
}