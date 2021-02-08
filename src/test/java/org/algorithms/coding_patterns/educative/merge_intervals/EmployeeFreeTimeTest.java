package org.algorithms.coding_patterns.educative.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFreeTimeTest {

    @Test
    void findEmployeeFreeTime1() {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        assertEquals(1, result.size());
        assertEquals(new Interval(3, 5), result.get(0));
    }

    @Test
    void findEmployeeFreeTime2() {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        assertEquals(2, result.size());
        assertEquals(new Interval(4, 6), result.get(0));
        assertEquals(new Interval(8, 9), result.get(1));
    }

    @Test
    void findEmployeeFreeTime3() {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        assertEquals(1, result.size());
        assertEquals(new Interval(5, 7), result.get(0));
    }
}