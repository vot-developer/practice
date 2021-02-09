package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllDuplicateTest {

    @Test
    void findNumbers1() {
        assertArrayEquals(new Integer[]{5, 4}, FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 }).toArray());
    }

    @Test
    void findNumbers2() {
        assertArrayEquals(new Integer[]{3, 5}, FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 }).toArray());
    }
}