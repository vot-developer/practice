package org.algorithms.coding_patterns.educative.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

/*
Given an array of intervals representing 'N' appointments, find out if a person can attend all the appointments.
 */
public class ConflictingAppointments {
    //time - O(n log n), space - O(1)
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        if (intervals.length < 2)
            return true;

        Arrays.sort(intervals, Comparator.comparingInt(value -> value.start));
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i - 1].end > intervals[i].start)
                return false;

        return true;
    }
}
