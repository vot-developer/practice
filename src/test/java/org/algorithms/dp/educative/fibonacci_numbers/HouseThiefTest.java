package org.algorithms.dp.educative.fibonacci_numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseThiefTest {
    private HouseThief houseThief;

    @BeforeEach
    void setUp() {
        houseThief = new HouseThief();
    }

    @Test
    void naive() {
        assertEquals(15, houseThief.naive(new int[]{2, 5, 1, 3, 6, 2, 4}));
        assertEquals(18, houseThief.naive(new int[]{2, 10, 14, 8, 1}));
    }

    @Test
    void topToUp() {
        assertEquals(15, houseThief.topToDown(new int[]{2, 5, 1, 3, 6, 2, 4}));
        assertEquals(18, houseThief.topToDown(new int[]{2, 10, 14, 8, 1}));
    }

    @Test
    void bottomToUp() {
        assertEquals(15, houseThief.bottomToUp(new int[]{2, 5, 1, 3, 6, 2, 4}));
        assertEquals(18, houseThief.bottomToUp(new int[]{2, 10, 14, 8, 1}));
    }
}