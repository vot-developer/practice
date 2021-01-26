package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSumIncreasingSubsequenceTest {
    private MaximumSumIncreasingSubsequence maximumSumIncreasingSubsequence;

    @BeforeEach
    void setUp() {
        maximumSumIncreasingSubsequence = new MaximumSumIncreasingSubsequence();
    }

    @Test
    void naive() {
        assertEquals(32, maximumSumIncreasingSubsequence.naive(new int[]{4,1,2,6,10,1,12}));
        assertEquals(25, maximumSumIncreasingSubsequence.naive(new int[]{-4,10,3,7,15}));
    }

    @Test
    void topToDown() {
        assertEquals(32, maximumSumIncreasingSubsequence.topToDown(new int[]{4,1,2,6,10,1,12}));
        assertEquals(25, maximumSumIncreasingSubsequence.topToDown(new int[]{-4,10,3,7,15}));
    }

    @Test
    void bottomToUp() {
        assertEquals(32, maximumSumIncreasingSubsequence.bottomToUp(new int[]{4,1,2,6,10,1,12}));
        assertEquals(25, maximumSumIncreasingSubsequence.bottomToUp(new int[]{-4,10,3,7,15}));
    }
}