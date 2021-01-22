package org.algorithms.dp.educative.fibonacci_numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumJumpsWithFeeTest {
    private MinimumJumpsWithFee minimumJumpsWithFee;

    @BeforeEach
    void setUp() {
        minimumJumpsWithFee = new MinimumJumpsWithFee();
    }

    @Test
    void naive() {
        assertEquals(3, minimumJumpsWithFee.naive(new int[]{1,2,5,2,1,2}, 6));
        assertEquals(5, minimumJumpsWithFee.naive(new int[]{2,3,4,5}, 4));
    }

    @Test
    void topToDown() {
        assertEquals(3, minimumJumpsWithFee.topToDown(new int[]{1,2,5,2,1,2}, 6));
        assertEquals(5, minimumJumpsWithFee.topToDown(new int[]{2,3,4,5}, 4));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, minimumJumpsWithFee.bottomToUp(new int[]{1,2,5,2,1,2}, 6));
        assertEquals(5, minimumJumpsWithFee.bottomToUp(new int[]{2,3,4,5}, 4));
    }
}