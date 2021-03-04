package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

    @Test
    void scheduleTasks1() {
        assertEquals(7, TaskScheduler.scheduleTasks(new char[] { 'a', 'a', 'a', 'b', 'c', 'c' }, 2));
    }

    @Test
    void scheduleTasks2() {
        assertEquals(5, TaskScheduler.scheduleTasks(new char[] { 'a', 'b', 'a' }, 3));
    }

    @Test
    void scheduleTasks3() {
        assertEquals(8, TaskScheduler.scheduleTasks(new char[] { 'a', 'a', 'a', 'b', 'b', 'b' }, 2));
    }

    @Test
    void scheduleTasks4() {
        assertEquals(16, TaskScheduler.scheduleTasks(new char[] { 'A','A','A','A','A','A','B','C','D','E','F','G' }, 2));
    }
}