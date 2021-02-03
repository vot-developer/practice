package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DutchFlagTest {

    @Test
    void sort1() {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        DutchFlag.sort(arr);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2}, arr);
    }

    @Test
    void sort2() {
        int[] arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        assertArrayEquals(new int[]{0, 0, 1, 2, 2, 2}, arr);
    }
}