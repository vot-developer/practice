package org.algorithms.coding_patterns.educative.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of intervals, find the next interval of each interval.
In a list of intervals, for an interval ‘i’ its next interval ‘j’ will have
the smallest ‘start’ greater than or equal to the ‘end’ of ‘i’.

Write a function to return an array containing indices of the next interval of each input interval.
If there is no next interval of a given interval, return -1.
It is given that none of the intervals have the same start point.
 */
public class NextInterval {
    //time - O(n log n), space - O(n)
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        PriorityQueue<Integer> startPQ = new PriorityQueue<>(intervals.length,
                Comparator.comparingInt(a -> intervals[a].start));
        PriorityQueue<Integer> endPQ = new PriorityQueue<>(intervals.length,
                Comparator.comparingInt(a -> intervals[a].end));

        for (int i = 0; i < intervals.length; i++){
            startPQ.offer(i);
            endPQ.offer(i);
        }

        for (int i = 0; i < intervals.length; i++){
            int index = endPQ.poll();
            int end = intervals[index].end;
            while (!startPQ.isEmpty() && intervals[startPQ.peek()].start < end)
                startPQ.poll();

            if (!startPQ.isEmpty())
                result[index] = startPQ.poll();
            else
                result[index] = -1;
        }

        return result;
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
