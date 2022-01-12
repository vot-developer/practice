package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllTaskSchedulingOrdersTest {

    @Test
    void printOrders() {
        List<List<Integer>> result = AllTaskSchedulingOrders.printOrders(6,
            new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 1, 4 },
                new int[]{3, 2}, new int[]{1, 3}
        });
        assertArrayEquals(new Integer[]{0, 1, 4, 3, 2, 5}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{1, 3, 2, 0, 4, 5}, result.get(12).toArray());
    }
}