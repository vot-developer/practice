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
        assertEquals(3, new int[]{2,1,1,1,4});
        assertEquals(4, new int[]{1,1,3,6,9,3,0,1,3});
    }
}