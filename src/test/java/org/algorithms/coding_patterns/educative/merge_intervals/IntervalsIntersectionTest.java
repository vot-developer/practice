package org.algorithms.coding_patterns.educative.merge_intervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalsIntersectionTest {

    @Test
    void merge1() {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        assertEquals(3, result.length);
        assertEquals(new Interval(2, 3), result[0]);
        assertEquals(new Interval(5, 6), result[1]);
        assertEquals(new Interval(7, 7), result[2]);
    }

    @Test
    void merge2() {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        Interval[] input2 = new Interval[] { new Interval(5, 10) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        assertEquals(2, result.length);
        assertEquals(new Interval(5, 7), result[0]);
        assertEquals(new Interval(9, 10), result[1]);
    }
}