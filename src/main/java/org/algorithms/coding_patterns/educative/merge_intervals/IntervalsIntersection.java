package org.algorithms.coding_patterns.educative.merge_intervals;

import java.util.ArrayList;
import java.util.List;

/*
Given two lists of intervals, find the intersection of these two lists.
Each list consists of disjoint intervals sorted on their start time.
 */
public class IntervalsIntersection {
    //time - O(n + m), space - O(n + m)
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0)
            return new Interval[0];

        int index1 = 0;
        int index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1].end < arr2[index2].start){
                index1++;
            } else if (arr2[index2].end < arr1[index1].start){
                index2++;
            } else {
                Interval intersection = new Interval(Math.max(arr1[index1].start, arr2[index2].start),
                        Math.min(arr1[index1].end, arr2[index2].end));
                intervalsIntersection.add(intersection);
                if (arr1[index1].end < arr2[index2].end)
                    index1++;
                else
                    index2++;
            }
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    //time - O(n + m), space - O(n + m)
    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        List<int[]> intervalsIntersection = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0)
            return new int[0][];

        int index1 = 0;
        int index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1][1] < arr2[index2][0]){
                index1++;
            } else if (arr2[index2][1] < arr1[index1][0]){
                index2++;
            } else {
                int[] intersection = new int[2];
                intersection[0] = Math.max(arr1[index1][0], arr2[index2][0]);
                intersection[1] = Math.min(arr1[index1][1], arr2[index2][1]);
                intervalsIntersection.add(intersection);
                if (arr1[index1][1] < arr2[index2][1])
                    index1++;
                else
                    index2++;
            }
        }

        return intervalsIntersection.toArray(new int[intervalsIntersection.size()][]);
    }
}
