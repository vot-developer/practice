package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubarrayProductLessThanKTest {

    @Test
    void findSubarrays1() {
        List<List<Integer>> result = SubarrayProductLessThanK.findSubarrays(new int[]{2, 5, 3, 10}, 30);
        assertEquals(6, result.size());
        assertArrayEquals(new Integer[]{2}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{5}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{5, 2}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{3}, result.get(3).toArray());
        assertArrayEquals(new Integer[]{3, 5}, result.get(4).toArray());
        assertArrayEquals(new Integer[]{10}, result.get(5).toArray());
    }

    @Test
    void findSubarrays2() {
        List<List<Integer>> result = SubarrayProductLessThanK.findSubarrays(new int[]{8, 2, 6, 5}, 50);
        assertEquals(7, result.size());
        assertArrayEquals(new Integer[]{8}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{2}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{2, 8}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{6}, result.get(3).toArray());
        assertArrayEquals(new Integer[]{6, 2}, result.get(4).toArray());
        assertArrayEquals(new Integer[]{5}, result.get(5).toArray());
        assertArrayEquals(new Integer[]{5, 6}, result.get(6).toArray());
    }
}