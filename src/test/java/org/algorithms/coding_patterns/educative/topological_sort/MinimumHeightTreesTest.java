package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumHeightTreesTest {

    @Test
    void findTrees1() {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        assertArrayEquals(new Integer[]{1, 2}, result.toArray());
    }

    @Test
    void findTrees2() {
        List<Integer> result = MinimumHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        assertArrayEquals(new Integer[]{0, 2}, result.toArray());
    }

    @Test
    void findTrees3() {
        List<Integer> result = MinimumHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        assertArrayEquals(new Integer[]{1}, result.toArray());
    }
}