package org.algorithms.dynamic.educative;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualSubsetSumTest {
    private EqualSubsetSum equalSubsetSum;

    @BeforeEach
    void setUp(){
        equalSubsetSum = new EqualSubsetSum();
    }

    @Test
    void naive() {
        assertTrue(equalSubsetSum.naive(new int[]{1, 2, 3, 4}));
        assertTrue(equalSubsetSum.naive(new int[]{1, 1, 3, 4, 7}));
        assertFalse(equalSubsetSum.naive(new int[]{2, 3, 4, 6}));
    }

    @Test
    void topToDown() {
        assertTrue(equalSubsetSum.topToDown(new int[]{1, 2, 3, 4}));
        assertTrue(equalSubsetSum.topToDown(new int[]{1, 1, 3, 4, 7}));
        assertFalse(equalSubsetSum.topToDown(new int[]{2, 3, 4, 6}));
    }

    @Test
    void bottomToUp() {
        assertTrue(equalSubsetSum.bottomToTop(new int[]{1, 2, 3, 4}));
        assertTrue(equalSubsetSum.bottomToTop(new int[]{1, 1, 3, 4, 7}));
        assertFalse(equalSubsetSum.bottomToTop(new int[]{2, 3, 4, 6}));
    }
}