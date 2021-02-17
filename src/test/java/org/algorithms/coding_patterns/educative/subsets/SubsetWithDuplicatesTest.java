package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetWithDuplicatesTest {

    @Test
    void findSubsets1() {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        assertEquals(6, result.size());
        assertArrayEquals(new Integer[]{}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{1}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{3}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{1, 3}, result.get(3).toArray());
        assertArrayEquals(new Integer[]{3, 3}, result.get(4).toArray());
        assertArrayEquals(new Integer[]{1, 3, 3}, result.get(5).toArray());
    }

    @Test
    void findSubsets2() {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        assertEquals(12, result.size());
        assertArrayEquals(new Integer[]{}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{1}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{3}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{1, 3}, result.get(3).toArray());
        assertArrayEquals(new Integer[]{3, 3}, result.get(4).toArray());
        assertArrayEquals(new Integer[]{1, 3, 3}, result.get(5).toArray());
        assertArrayEquals(new Integer[]{5}, result.get(6).toArray());
        assertArrayEquals(new Integer[]{1, 5}, result.get(7).toArray());
        assertArrayEquals(new Integer[]{3, 5}, result.get(8).toArray());
        assertArrayEquals(new Integer[]{1, 3, 5}, result.get(9).toArray());
        assertArrayEquals(new Integer[]{3, 3, 5}, result.get(10).toArray());
        assertArrayEquals(new Integer[]{1, 3, 3, 5}, result.get(11).toArray());
    }
}