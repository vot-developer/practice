package org.algorithms.coding_patterns.educative.merge_intervals;

import java.util.ArrayList;
import java.util.List;

/*
Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position
and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 */
public class InsertInterval {
    //time - O(n), space - O(n)
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        for (; i < intervals.size() && intervals.get(i).end < newInterval.start; i++)
            mergedIntervals.add(intervals.get(i));

        //merging
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(newInterval);

        for (; i < intervals.size(); i++)
            mergedIntervals.add(intervals.get(i));

        return mergedIntervals;
    }

    //time - O(n), space - O(n)
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int i = 0;
        for (; i < intervals.length && intervals[i][1] < newInterval[0]; i++)
            mergedIntervals.add(intervals[i]);

        //merging
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        mergedIntervals.add(newInterval);

        for (; i < intervals.length; i++)
            mergedIntervals.add(intervals[i]);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
