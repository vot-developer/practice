package org.algorithms.coding_patterns.educative.topological_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulingTest {

    @Test
    void isSchedulingPossible1() {
        assertTrue(TaskScheduling.isSchedulingPossible(3,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } }));
    }

    @Test
    void isSchedulingPossible2() {
        assertFalse(TaskScheduling.isSchedulingPossible(3,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } }));
    }

    @Test
    void isSchedulingPossible3() {
        assertTrue(TaskScheduling.isSchedulingPossible(6,
            new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } }));
    }
}