package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {
    private LongestIncreasingSubsequence lis;

    @BeforeEach
    void setUp() {
        lis = new LongestIncreasingSubsequence();
    }

    @Test
    void naive() {
        assertEquals(5, lis.naive(new int[]{4,2,3,6,10,1,12}));
        assertEquals(4, lis.naive(new int[]{-4,10,3,7,15}));
    }

    @Test
    void topToDown() {
        assertEquals(5, lis.topToDown(new int[]{4,2,3,6,10,1,12}));
        assertEquals(4, lis.topToDown(new int[]{-4,10,3,7,15}));
    }

    @Test
    void bottomToUp() {
        assertEquals(5, lis.bottomToUp(new int[]{4,2,3,6,10,1,12}));
        assertEquals(4, lis.bottomToUp(new int[]{-4,10,3,7,15}));
    }
}