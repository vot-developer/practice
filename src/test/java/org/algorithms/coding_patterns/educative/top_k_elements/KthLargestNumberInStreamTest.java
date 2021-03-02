package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestNumberInStreamTest {

    @Test
    void add() {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        assertEquals(5, kthLargestNumber.add(6));
        assertEquals(6, kthLargestNumber.add(13));
        assertEquals(6, kthLargestNumber.add(4));
    }
}