package org.algorithms.dp.educative.fibonacci_numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberFactorsTest {
    private NumberFactors factors;

    @BeforeEach
    void setUp() {
        factors = new NumberFactors();
    }

    @Test
    void naive() {
        assertEquals(4, factors.naive(4));
        assertEquals(6, factors.naive(5));
    }

    @Test
    void topToDown() {
        assertEquals(4, factors.topToDown(4));
        assertEquals(6, factors.topToDown(5));
    }

    @Test
    void bottomToUp() {
        assertEquals(4, factors.bottomToUp(4));
        assertEquals(6, factors.bottomToUp(5));
    }
}