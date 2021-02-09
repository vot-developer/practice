package org.algorithms.coding_patterns.educative.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberTest {

    @Test
    void findMissingNumber2() {
        assertEquals(2, MissingNumber.findMissingNumber(new int[]{4, 0, 3, 1}));
    }

    @Test
    void findMissingNumber7() {
        assertEquals(7, MissingNumber.findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}