package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentNumbersTest {

    @Test
    void findTopKFrequentNumbers1() {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        assertArrayEquals(new Integer[]{12, 11}, result.toArray());
    }

    @Test
    void findTopKFrequentNumbers2() {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        assertArrayEquals(new Integer[]{12, 11}, result.toArray());
    }
}