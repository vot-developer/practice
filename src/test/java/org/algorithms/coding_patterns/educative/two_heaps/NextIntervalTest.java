package org.algorithms.coding_patterns.educative.two_heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextIntervalTest {

    @Test
    void findNextInterval1() {
        Interval[] intervals = new Interval[]{new Interval(2, 3), new Interval(3, 4), new Interval(5, 6)};
        assertArrayEquals(new int[]{1, 2, -1}, NextInterval.findNextInterval(intervals));
    }

    @Test
    void findNextInterval2() {
        Interval[] intervals = new Interval[]{new Interval(3, 4), new Interval(1, 5), new Interval(4, 6)};
        assertArrayEquals(new int[]{2, -1, -1}, NextInterval.findNextInterval(intervals));
    }
}