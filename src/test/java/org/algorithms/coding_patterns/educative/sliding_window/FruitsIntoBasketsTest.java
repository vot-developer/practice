package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitsIntoBasketsTest {

    @Test
    void findLength() {
        assertEquals(3, FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        assertEquals(5, FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
        assertEquals(5, FruitsIntoBaskets.findLength(new char[]{
                'C', 'C', 'C', 'A', 'B', 'A', 'A', 'B', 'C', 'C', 'D'
        }));
        assertEquals(5, FruitsIntoBaskets.findLength(new char[]{
                'B','A','B','E','B','E','B','C','D'
        }));
    }
}