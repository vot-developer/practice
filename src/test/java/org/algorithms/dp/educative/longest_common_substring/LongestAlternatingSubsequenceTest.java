package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestAlternatingSubsequenceTest {
    private LongestAlternatingSubsequence subsequence;

    @BeforeEach
    void setUp() {
        subsequence = new LongestAlternatingSubsequence();
    }

    @Test
    void naive() {
        assertEquals(2, subsequence.naive(new int[]{1,2,3,4}));
        assertEquals(3, subsequence.naive(new int[]{3,2,1,4}));
        assertEquals(4, subsequence.naive(new int[]{1,3,2,4}));
    }

    @Test
    void topToDown() {
        assertEquals(2, subsequence.topToDown(new int[]{1,2,3,4}));
        assertEquals(3, subsequence.topToDown(new int[]{3,2,1,4}));
        assertEquals(4, subsequence.topToDown(new int[]{1,3,2,4}));
    }

    @Test
    void bottomToUp() {
        assertEquals(2, subsequence.bottomToUp(new int[]{1,2,3,4}));
        assertEquals(3, subsequence.bottomToUp(new int[]{3,2,1,4}));
        assertEquals(4, subsequence.bottomToUp(new int[]{1,3,2,4}));
    }
}