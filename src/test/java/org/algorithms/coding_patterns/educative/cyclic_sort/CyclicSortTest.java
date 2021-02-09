package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class CyclicSortTest {

    @Test
    void sort1() {
        int[] nums = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

    @Test
    void sort2() {
        int[] nums = new int[]{2, 6, 4, 3, 1, 5};
        CyclicSort.sort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums);
    }

    @Test
    void sort3() {
        int[] nums = new int[]{1, 5, 6, 4, 3, 2};
        CyclicSort.sort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums);
    }
}