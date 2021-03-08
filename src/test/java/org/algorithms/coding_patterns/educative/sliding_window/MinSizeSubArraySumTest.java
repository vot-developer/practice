package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSizeSubArraySumTest {

    @Test
    void findMinSubArray() {
        assertEquals(2, MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        assertEquals(1, MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        assertEquals(3, MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
        assertEquals(0, MinSizeSubArraySum.findMinSubArray(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}