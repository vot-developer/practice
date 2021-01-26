package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingSubsequenceTest {
    private LongestRepeatingSubsequence subsequence;

    @BeforeEach
    void setUp() {
        subsequence = new LongestRepeatingSubsequence();
    }

    @Test
    void naive() {
        assertEquals(2, subsequence.naive("tomorrow"));
        assertEquals(3, subsequence.naive("aabdbcec"));
        assertEquals(2, subsequence.naive("fmff"));
    }

    @Test
    void topToDown() {
        assertEquals(2, subsequence.topToDown("tomorrow"));
        assertEquals(3, subsequence.topToDown("aabdbcec"));
        assertEquals(2, subsequence.topToDown("fmff"));
    }

    @Test
    void bottomToUp() {
        assertEquals(2, subsequence.bottomToUp("tomorrow"));
        assertEquals(3, subsequence.bottomToUp("aabdbcec"));
        assertEquals(2, subsequence.bottomToUp("fmff"));
    }
}