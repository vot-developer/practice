package org.algorithms.coding_patterns.educative.merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a list of intervals representing the start and end time of ‘N’ meetings,
find the minimum number of rooms required to hold all the meetings.
 */
public class MinimumMeetingRooms {
    //time - O(n * log n), space - O(n)
    public static int findMinimumMeetingRooms(List<Interval> meetings) {
        if (meetings.size() == 0)
            return 0;

        if (meetings.size() == 1)
            return 1;

        Collections.sort(meetings, Comparator.comparingInt(meeting -> meeting.start));
        int max = 0;
        PriorityQueue<Interval> activeMeetings = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.end));
        for (Interval meeting : meetings){
            while (!activeMeetings.isEmpty() && meeting.start >= activeMeetings.peek().end)
                activeMeetings.poll();

            activeMeetings.add(meeting);
            max = Math.max(activeMeetings.size(), max);
        }

        return max;
    }
}
