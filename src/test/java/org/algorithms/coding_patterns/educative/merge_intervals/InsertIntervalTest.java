package org.algorithms.coding_patterns.educative.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {

    @Test
    void insertInterval1() {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));

        List<Interval> mergedIntervals = InsertInterval.insert(input, new Interval(4, 6));
        assertEquals(3, mergedIntervals.size());
        assertEquals(new Interval(1, 3), mergedIntervals.get(0));
        assertEquals(new Interval(4, 7), mergedIntervals.get(1));
        assertEquals(new Interval(8, 12), mergedIntervals.get(2));
    }

    @Test
    void insertInterval2() {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));

        List<Interval> mergedIntervals = InsertInterval.insert(input, new Interval(4, 10));
        assertEquals(2, mergedIntervals.size());
        assertEquals(new Interval(1, 3), mergedIntervals.get(0));
        assertEquals(new Interval(4, 12), mergedIntervals.get(1));
    }

    @Test
    void insertInterval3() {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));

        List<Interval> mergedIntervals = InsertInterval.insert(input, new Interval(1, 4));
        assertEquals(2, mergedIntervals.size());
        assertEquals(new Interval(1, 4), mergedIntervals.get(0));
        assertEquals(new Interval(5, 7), mergedIntervals.get(1));
    }
}