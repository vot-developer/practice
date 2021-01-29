package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitsIntoBasketsTest {

    @Test
    void findLength() {
        assertEquals(3, FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        assertEquals(5, FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}