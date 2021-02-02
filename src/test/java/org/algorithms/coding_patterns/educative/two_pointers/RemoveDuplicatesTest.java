package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void remove() {
        assertEquals(4, RemoveDuplicates.remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        assertEquals(2, RemoveDuplicates.remove(new int[]{2, 2, 2, 11}));
    }

    @Test
    void removeKey() {
        assertEquals(4, RemoveDuplicates.removeKey(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3));
        assertEquals(2, RemoveDuplicates.removeKey(new int[]{2, 11, 2, 2, 1}, 2));
    }
}