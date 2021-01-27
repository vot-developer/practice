package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestBitonicSubsequenceTest {
    private LongestBitonicSubsequence subsequence;

    @BeforeEach
    void setUp() {
        subsequence = new LongestBitonicSubsequence();
    }

    @Test
    void naive() {
        assertEquals(5, subsequence.naive(new int[]{4,2,3,6,10,1,12}));
        assertEquals(7, subsequence.naive(new int[]{4,2,5,9,7,6,10,3,1}));
    }

    @Test
    void topToDown() {
        assertEquals(5, subsequence.topToDown(new int[]{4,2,3,6,10,1,12}));
        assertEquals(7, subsequence.topToDown(new int[]{4,2,5,9,7,6,10,3,1}));
    }

    @Test
    void bottomToUp() {
        assertEquals(5, subsequence.bottomToUp(new int[]{4,2,3,6,10,1,12}));
        assertEquals(7, subsequence.bottomToUp(new int[]{4,2,5,9,7,6,10,3,1}));
    }
}