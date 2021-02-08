package org.algorithms.coding_patterns.educative.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumMeetingRoomsTest {

    @Test
    void findMinimumMeetingRooms1() {
        List<Interval> input = new ArrayList<>() {
            {
                add(new Interval(1, 4));
                add(new Interval(2, 5));
                add(new Interval(7, 9));
            }
        };
        assertEquals(2, MinimumMeetingRooms.findMinimumMeetingRooms(input));
    }

    @Test
    void findMinimumMeetingRooms2() {
        List<Interval> input = new ArrayList<>() {
            {
                add(new Interval(6, 7));
                add(new Interval(2, 4));
                add(new Interval(8, 12));
            }
        };
        assertEquals(1, MinimumMeetingRooms.findMinimumMeetingRooms(input));
    }

    @Test
    void findMinimumMeetingRooms3() {
        List<Interval> input = new ArrayList<>() {
            {
                add(new Interval(1, 4));
                add(new Interval(2, 3));
                add(new Interval(3, 6));
            }
        };
        assertEquals(2, MinimumMeetingRooms.findMinimumMeetingRooms(input));
    }

    @Test
    void findMinimumMeetingRooms4() {
        List<Interval> input = new ArrayList<>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };
        assertEquals(2, MinimumMeetingRooms.findMinimumMeetingRooms(input));
    }
}