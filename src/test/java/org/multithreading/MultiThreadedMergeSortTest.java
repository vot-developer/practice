package org.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MultiThreadedMergeSortTest {

    @Test
    void merge() {
        int[] input = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        MultiThreadedMergeSort mergeSort = new MultiThreadedMergeSort();
        mergeSort.merge(input, 0, input.length - 1);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, input);
    }
}