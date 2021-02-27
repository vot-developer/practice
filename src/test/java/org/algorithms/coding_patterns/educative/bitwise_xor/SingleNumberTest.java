package org.algorithms.coding_patterns.educative.bitwise_xor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

    @Test
    void findSingleNumber() {
        assertEquals(4, SingleNumber.findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
        assertEquals(9, SingleNumber.findSingleNumber(new int[]{7, 9, 7}));
    }
}