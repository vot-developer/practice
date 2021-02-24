package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountUniqueTreesTest {

    @Test
    void countTrees() {
        assertEquals(2, new CountUniqueTrees().countTrees(2));
        assertEquals(5, new CountUniqueTrees().countTrees(3));
    }
}