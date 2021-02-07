package org.algorithms.coding_patterns.educative.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 */
public class MergeIntervals {

    //time - O(n log n), space - O(n)
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> it = intervals.iterator();
        Interval intervalOne = it.next();
        while (it.hasNext()) {
            Interval intervalTwo = it.next();
            if (intervalOne.end < intervalTwo.start) {
                mergedIntervals.add(intervalOne);
                intervalOne = intervalTwo;
            } else {
                intervalOne = new Interval(
                        intervalOne.start,
                        Math.max(intervalOne.end, intervalTwo.end));
            }
        }
        mergedIntervals.add(intervalOne);
        return mergedIntervals;
    }

    //time - O(n log n), space - O(1)
    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();

        int[] intervalOne = intervals[0];
        for (int[] intervalTwo : intervals) {
            if (intervalOne[1] < intervalTwo[0]) {
                result.add(intervalOne);
                intervalOne = intervalTwo;
            } else {
                intervalOne[1] = Math.max(intervalOne[1], intervalTwo[1]);
            }
        }
        result.add(intervalOne);

        return result.toArray(new int[result.size()][]);
    }
}
