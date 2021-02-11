package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripletSumToZeroTest {

    @Test
    void searchTriplets1() {
        List<List<Integer>> result = TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});
        assertEquals(4, result.size());
        assertArrayEquals(new Integer[]{-3, 1, 2}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{-2, 0, 2}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{-2, 1, 1}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{-1, 0, 1}, result.get(3).toArray());
    }

    @Test
    void searchTriplets2() {
        List<List<Integer>> result = TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3});
        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{-5, 2, 3}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{-2, -1, 3}, result.get(1).toArray());
    }
}