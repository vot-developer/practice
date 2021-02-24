package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeilingOfANumberTest {

    @Test
    void searchCeilingOfANumber() {
        assertEquals(1, CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        assertEquals(4, CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15, 16 }, 12));
        assertEquals(-1, CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        assertEquals(0, CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}