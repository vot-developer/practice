package org.algorithms.coding_patterns.educative.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    void merge1() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));

        List<Interval> mergedIntervals = MergeIntervals.merge(input);
        assertEquals(2, mergedIntervals.size());
        assertEquals(new Interval(1, 5), mergedIntervals.get(0));
        assertEquals(new Interval(7, 9), mergedIntervals.get(1));
    }

    @Test
    void merge2() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));

        List<Interval> mergedIntervals = MergeIntervals.merge(input);
        assertEquals(2, mergedIntervals.size());
        assertEquals(new Interval(2, 4), mergedIntervals.get(0));
        assertEquals(new Interval(5, 9), mergedIntervals.get(1));
    }

    @Test
    void merge3() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));

        List<Interval> mergedIntervals = MergeIntervals.merge(input);
        assertEquals(1, mergedIntervals.size());
        assertEquals(new Interval(1, 6), mergedIntervals.get(0));
    }
}