package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortTest {

    @Test
    void sort1() {
        List<Integer> result = TopologicalSort.sort(4,
            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        assertArrayEquals(new Integer[]{3, 2, 0, 1}, result.toArray());
    }

    @Test
    void sort2() {
        List<Integer> result = TopologicalSort.sort(5, new int[][]
            { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
            new int[] { 2, 1 }, new int[] { 3, 1 } });
        assertArrayEquals(new Integer[]{4, 2, 3, 0, 1}, result.toArray());
    }

    @Test
    void sort3() {
        List<Integer> result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
            new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        assertArrayEquals(new Integer[]{5, 6, 3, 4, 0, 2, 1}, result.toArray());
    }
}