package org.algorithms.dp.educative.fibonacci_numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaircaseTest {
    private Staircase staircase;

    @BeforeEach
    void setUp() {
        staircase = new Staircase();
    }

    @Test
    void naive() {
        assertEquals(4, staircase.naive(3));
        assertEquals(7, staircase.naive(4));
    }

    @Test
    void topToDown() {
        assertEquals(4, staircase.topToDown(3));
        assertEquals(7, staircase.topToDown(4));
    }

    @Test
    void bottomToUp() {
        assertEquals(4, staircase.bottomToUp(3));
        assertEquals(7, staircase.bottomToUp(4));
    }

    @Test
    void bottomToUpImprovedSpace() {
        assertEquals(4, staircase.bottomToUpImprovedSpace(3));
        assertEquals(7, staircase.bottomToUpImprovedSpace(4));
    }
}