package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskSchedulingOrderTest {

    @Test
    void findOrder0() {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        assertArrayEquals(new Integer[]{0, 1, 2}, result.toArray());
    }

    @Test
    void findOrder1() {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        assertArrayEquals(new Integer[]{0, 1, 2}, result.toArray());
    }

    @Test
    void findOrder2() {
        List<Integer> result = TaskSchedulingOrder.findOrder(3,
            new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        assertTrue(result.isEmpty());
    }

    @Test
    void findOrder3() {
        List<Integer> result = TaskSchedulingOrder.findOrder(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
            new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        assertArrayEquals(new Integer[]{0, 1, 3, 4, 2, 5}, result.toArray());
    }
}