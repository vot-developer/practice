package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicateTest {

    @Test
    void findNumber1() {
        assertEquals(4, FindDuplicate.findNumber(new int[]{1, 4, 4, 3, 2}));
    }

    @Test
    void findNumber2() {
        assertEquals(3, FindDuplicate.findNumber(new int[]{2, 1, 3, 3, 5, 4}));
    }

    @Test
    void findNumber3() {
        assertEquals(4, FindDuplicate.findNumber(new int[]{2, 4, 1, 4, 4}));
    }
}