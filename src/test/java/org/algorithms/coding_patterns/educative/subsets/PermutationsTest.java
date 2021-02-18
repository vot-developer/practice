package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void findPermutations() {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        assertEquals(6, result.size());
        assertArrayEquals(new Integer[]{5, 3, 1}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{3, 5, 1}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{3, 1, 5}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{5, 1, 3}, result.get(3).toArray());
        assertArrayEquals(new Integer[]{1, 5, 3}, result.get(4).toArray());
        assertArrayEquals(new Integer[]{1, 3, 5}, result.get(5).toArray());
    }
}