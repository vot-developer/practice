package org.algorithms.coding_patterns.educative.fast_slow_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularArrayLoopTest {

    @Test
    void loopExists1() {
        assertTrue(CircularArrayLoop.loopExists(new int[]{1, 2, -1, 2, 2}));
    }

    @Test
    void loopExists2() {
        assertTrue(CircularArrayLoop.loopExists(new int[]{2, 2, -1, 2}));
    }

    @Test
    void loopExists3() {
        assertTrue(CircularArrayLoop.loopExists(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void loopExists4() {
        assertFalse(CircularArrayLoop.loopExists(new int[]{-2, -3, -9}));
    }

    @Test
    void loopNotExists1() {
        assertFalse(CircularArrayLoop.loopExists(new int[]{2, 1, -1, -2}));
    }

    @Test
    void loopNotExists2() {
        assertFalse(CircularArrayLoop.loopExists(new int[]{-1, 2}));
    }
}