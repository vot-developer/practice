package org.algorithms.coding_patterns.educative.two_heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMedianTest {

    @Test
    void findSlidingWindowMedian1() {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        assertArrayEquals(new double[]{1.5, 0.5, 1.0, 4.0}, result);
    }

    @Test
    void findSlidingWindowMedian2() {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, result);
    }

    @Test
    void findSlidingWindowMedian3() {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] {2147483647,2147483647}, 2);
        assertArrayEquals(new double[]{2147483647.0}, result);
    }
}