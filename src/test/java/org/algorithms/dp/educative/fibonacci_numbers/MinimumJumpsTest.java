package org.algorithms.dp.educative.fibonacci_numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumJumpsTest {
    private MinimumJumps minimumJumps;

    @BeforeEach
    void setUp() {
        minimumJumps = new MinimumJumps();
    }

    @Test
    void naive() {
        assertEquals(3, minimumJumps.naive(new int[]{2,1,1,1,4}));
        assertEquals(4, minimumJumps.naive(new int[]{1,1,3,6,9,3,0,1,3}));
        assertEquals(Integer.MAX_VALUE, minimumJumps.naive(new int[]{3,2,1,0,4}));
    }

    @Test
    void topToDown() {
        assertEquals(3, minimumJumps.topToDown(new int[]{2,1,1,1,4}));
        assertEquals(4, minimumJumps.topToDown(new int[]{1,1,3,6,9,3,0,1,3}));
        assertEquals(Integer.MAX_VALUE, minimumJumps.topToDown(new int[]{3,2,1,0,4}));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, minimumJumps.bottomToUp(new int[]{2,1,1,1,4}));
        assertEquals(4, minimumJumps.bottomToUp(new int[]{1,1,3,6,9,3,0,1,3}));
        assertEquals(Integer.MAX_VALUE, minimumJumps.bottomToUp(new int[]{3,2,1,0,4}));
    }
}