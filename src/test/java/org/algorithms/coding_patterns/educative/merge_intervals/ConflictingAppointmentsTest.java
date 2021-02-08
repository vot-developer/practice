package org.algorithms.coding_patterns.educative.merge_intervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConflictingAppointmentsTest {

    @Test
    void canAttendAllAppointments1() {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        assertFalse(ConflictingAppointments.canAttendAllAppointments(intervals));
    }

    @Test
    void canAttendAllAppointments2() {
        Interval[] intervals = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        assertTrue(ConflictingAppointments.canAttendAllAppointments(intervals));
    }

    @Test
    void canAttendAllAppointments3() {
        Interval[] intervals = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        assertFalse(ConflictingAppointments.canAttendAllAppointments(intervals));
    }
}