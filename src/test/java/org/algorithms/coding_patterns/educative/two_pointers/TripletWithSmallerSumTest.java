package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripletWithSmallerSumTest {

    @Test
    void searchTriplets() {
        assertEquals(2, TripletWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
//        assertEquals(4, TripletWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}