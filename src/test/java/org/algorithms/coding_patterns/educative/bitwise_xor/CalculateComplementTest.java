package org.algorithms.coding_patterns.educative.bitwise_xor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateComplementTest {

    @Test
    void bitwiseComplement() {
        assertEquals(7, CalculateComplement.bitwiseComplement(8));
        assertEquals(5, CalculateComplement.bitwiseComplement(10));
        assertEquals(1, CalculateComplement.bitwiseComplement(0));
    }
}