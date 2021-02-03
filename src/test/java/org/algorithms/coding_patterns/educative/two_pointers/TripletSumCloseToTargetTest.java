package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripletSumCloseToTargetTest {

    @Test
    void searchTriplet() {
        assertEquals(1, TripletSumCloseToTarget.searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        assertEquals(0, TripletSumCloseToTarget.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        assertEquals(3, TripletSumCloseToTarget.searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}