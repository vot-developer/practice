package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllTaskSchedulingOrdersTest {

    @Test
    void printOrders() {
        List<List<Integer>> result = AllTaskSchedulingOrders.printOrders(4,
            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        assertArrayEquals(new Integer[]{3, 2, 1, 0}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{3, 2, 0, 1}, result.get(1).toArray());
    }
}